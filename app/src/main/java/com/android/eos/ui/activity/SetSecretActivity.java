package com.android.eos.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.data.UserInfo;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置密码页面
 */
public class SetSecretActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.tip_ll)
    LinearLayout tipLl;
    @BindView(R.id.confirm_et)
    EditText confirmEt;
    @BindView(R.id.hint_et)
    EditText hintEt;

    @Override
    public int setViewId() {
        return R.layout.activity_set_secret;
    }

    @Override
    public void initView() {
        initTitle();
        passwordEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tipLl.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    private void initTitle() {
        titleTv.setText(R.string.set_secret);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.complete_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.complete_btn:
                String password=passwordEt.getText().toString();
                String passwordConfirm=confirmEt.getText().toString();
                String passwordHit=passwordEt.getText().toString();
                if (TextUtils.isEmpty(password)) {
                    ToastUtils.showToast(getResources().getString(R.string.please_enter_password));
                    return;
                }
                if (TextUtils.isEmpty(passwordConfirm)) {
                    ToastUtils.showToast(getResources().getString(R.string.please_confirm_password));
                    return;
                }
                if (!password.equals(passwordConfirm)) {
                    ToastUtils.showToast(getResources().getString(R.string.password_difference));
                    return;
                }
                Intent intent = new Intent(this, CreatedIdentityFreeActivity.class);
                intent.putExtra(ConstantUtils.PASSWORD, passwordEt.getText().toString());
                intent.putExtra(ConstantUtils.PASSWORD_HINT, hintEt.getText().toString());
                startActivity(intent);
                break;
        }
    }


}
