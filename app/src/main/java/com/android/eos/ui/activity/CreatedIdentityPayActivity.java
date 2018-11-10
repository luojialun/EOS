package com.android.eos.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 付费创建
 */
public class CreatedIdentityPayActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_created_identity_pay;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.create_pay_2);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.collection_code_ll, R.id.create_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.collection_code_ll:
                readyGo(CollectionCodeActivity.class);
                break;
            case R.id.create_btn:
                MainActivity.readGoMain(CreatedIdentityPayActivity.this);
                break;
        }
    }


}
