package com.android.eos.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 输入密码页
 */
public class EnterPasswordActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_enter_password;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.enter_password);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.confirm_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm_btn:
                Intent intent = new Intent(this, TransAndCollectionActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
        }

    }
}
