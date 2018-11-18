package com.android.eos.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.LoginResponse;
import com.android.eos.data.UserInfo;
import com.android.eos.net.GlideApp;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.utils.EncryptUtils;
import com.android.eos.utils.ToastUtils;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的身份页面
 */
public class MyIdentityActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.avatar_iv)
    ImageView avatarIv;
    @BindView(R.id.idcard_et)
    TextView idcardEt;
    @BindView(R.id.identity_id_et)
    TextView identityIdEt;

    @Override
    public int setViewId() {
        return R.layout.activity_my_identity;
    }

    @Override
    public void initView() {
        initTitle();
    }

    private void initTitle() {
        titleTv.setText(R.string.my_identity);
    }

    @Override
    public void initData() {
        login();
    }

    @OnClick({R.id.back_iv, R.id.backup_btn, R.id.logout_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.backup_btn:
//                if (TextUtils.isEmpty(idcardEt.getText().toString())) {
//                    ToastUtils.showToast("name 不能为空");
//                    return;
//                }
                backup();
                break;
            case R.id.logout_btn:
                logout();
                break;
        }
    }

    private void login() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", EncryptUtils.encryptMD5ToString(UserInfo.getName()));
        paramsMap.put("pass", EncryptUtils.encryptMD5ToString(UserInfo.getPass()));
        HttpUtils.getRequets(UrlHelper.login, this, paramsMap, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                LoginResponse loginResponse = (LoginResponse) parseStringToBean(response.body().toString(), LoginResponse.class);
                if (null != loginResponse) {
                    GlideApp.with(MyIdentityActivity.this).load(loginResponse.getData().getFace()).placeholder(R.mipmap.default_avatar).into(avatarIv);
                    idcardEt.setText(loginResponse.getData().getId_card());
                    identityIdEt.setText(loginResponse.getData().getId_name());
                    UserInfo.setName(loginResponse.getData().getName());
                    UserInfo.setIdcard(loginResponse.getData().getId_card());
                    UserInfo.setIdname(loginResponse.getData().getId_name());
                    UserInfo.setToken(loginResponse.getData().getToken());
                    UserInfo.setEmail(loginResponse.getData().getEmail());

                }
            }
        });
    }

    public void backup() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("name", UserInfo.getName());
        paramsMap.put("token", UserInfo.getToken());
        paramsMap.put("email", UserInfo.getEmail());
        paramsMap.put("id_name", identityIdEt.getText().toString());
        paramsMap.put("id_card", idcardEt.getText().toString());

        HttpUtils.getRequets(UrlHelper.update_identity, this, paramsMap, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                LoginResponse loginResponse = (LoginResponse) parseStringToBean(response.body().toString(), LoginResponse.class);
                if (null != loginResponse && loginResponse.isRet()) {
                    UserInfo.setName(loginResponse.getData().getName());
                    UserInfo.setIdcard(loginResponse.getData().getId_card());
                    UserInfo.setIdname(loginResponse.getData().getId_name());
                    UserInfo.setToken(loginResponse.getData().getToken());
                    UserInfo.setEmail(loginResponse.getData().getEmail());
                    ToastUtils.showToast(R.string.backup_success);
                } else {
                    ToastUtils.showToast(R.string.backup_fail);
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtils.showToast(R.string.backup_fail);
            }
        });

    }

    public void logout() {
        UserInfo.setName("");
        UserInfo.setPass("");
        MainActivity.readGoMain(MyIdentityActivity.this);
    }
}
