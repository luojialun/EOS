package com.android.eos.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.RegisterResponse;
import com.android.eos.data.UserInfo;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.utils.EncryptUtils;
import com.android.eos.utils.LogUtils;
import com.android.eos.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建身份页面
 */
public class CreateIdentityActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.name_et)
    EditText nameEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.password_confirm_et)
    EditText passwordConfirmEt;
    @BindView(R.id.pass_hint_et)
    EditText passHintEt;

    @Override
    public int setViewId() {
        return R.layout.activity_create_identity;
    }

    @Override
    public void initView() {
        iniTitle();

    }

    private void iniTitle() {
        titleTv.setText(R.string.create_id);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.create_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.create_btn:
                String name = nameEt.getText().toString();
                String password = passwordEt.getText().toString();
                String passwordConfirm = passwordConfirmEt.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    ToastUtils.showToast(R.string.please_enter_identity);
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    ToastUtils.showToast(R.string.please_enter_password);
                    return;
                }
                if (TextUtils.isEmpty(passwordConfirm)) {
                    ToastUtils.showToast(R.string.please_confirm_password);
                    return;
                }
                if (!password.equals(passwordConfirm)) {
                    ToastUtils.showToast(R.string.password_difference);
                    return;
                }
                registerIdentity(name, password);
                break;
        }
    }

    private void registerIdentity(String name, String password) {
        showProgress();
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", EncryptUtils.encryptMD5ToString(name));
        paramsMap.put("pass", EncryptUtils.encryptMD5ToString(password));
        HttpUtils.getRequets(UrlHelper.register, this, paramsMap, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                RegisterResponse registerResponse = (RegisterResponse) parseStringToBean(response.body().toString(), RegisterResponse.class);
                if (null != registerResponse && registerResponse.isRet()) {
                    UserInfo.setName(name);
                    UserInfo.setPass(password);
                    UserInfo.setPassHint(passHintEt.getText().toString());
                    readyGoThenKill(MyIdentityActivity.class);
                } else {
                    ToastUtils.showToast(R.string.identity_fail);
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtils.showToast(R.string.identity_fail);
            }
        });

    }
}
