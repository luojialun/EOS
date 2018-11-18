package com.android.eos.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.HelpProblemResponse;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.ui.adapter.CommonProblemAdapter;
import com.android.eos.ui.adapter.TypeProblemAdapter;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.KeyboardUtils;
import com.android.eos.utils.ToastUtils;
import com.android.eos.widget.MyRecyclerView;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.OnClick;

public class HelpAndFeedbackActivity extends BaseActivity {

    @BindView(R.id.common_rv)
    MyRecyclerView commonRv;
    @BindView(R.id.type_rv)
    MyRecyclerView typeRv;
    @BindView(R.id.search_et)
    EditText searchEt;

    private CommonProblemAdapter commonProblemAdapter;
    private TypeProblemAdapter typeProblemAdapter;

    @Override
    public int setViewId() {
        return R.layout.activity_help_and_feedback;
    }

    @Override
    public void initView() {
        initAdapter();
        searchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_SEND
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || (KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    KeyboardUtils.hideSoftInput(HelpAndFeedbackActivity.this);
                    if (TextUtils.isEmpty(v.getText().toString())) {
                        ToastUtils.showToast(R.string.please_enter_search);
                    } else {
                        Intent intent = new Intent(HelpAndFeedbackActivity.this, H5Activity.class);
                        intent.putExtra(ConstantUtils.H5_TYPE, ConstantUtils.SELF_WEB);
                        intent.putExtra(ConstantUtils.SELF_WEB_URL, UrlHelper.help_search + v.getText().toString());
                        startActivity(intent);
                        return true;
                    }
                }
                return false;
            }
        });

    }

    private void initAdapter() {
        commonRv.setLayoutManager(new LinearLayoutManager(this));
        commonProblemAdapter = new CommonProblemAdapter(null);
        commonRv.setAdapter(commonProblemAdapter);
        typeRv.setLayoutManager(new LinearLayoutManager(this));
        typeProblemAdapter = new TypeProblemAdapter(null);
        typeRv.setAdapter(typeProblemAdapter);
    }

    @Override
    public void initData() {
        getProblems();
    }

    private void getProblems() {
        showProgress();
        HttpUtils.getRequets(UrlHelper.help_feedback, this, null, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                dismissProgress();
                HelpProblemResponse helpProblemResponse = (HelpProblemResponse) parseStringToBean(response.body().toString(), HelpProblemResponse.class);
                if (null != helpProblemResponse) {
                    commonProblemAdapter.setNewData(helpProblemResponse.getCommon());
                    typeProblemAdapter.setNewData(helpProblemResponse.getTypes());
                }
            }
        });
    }

    @OnClick({R.id.back_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }
}
