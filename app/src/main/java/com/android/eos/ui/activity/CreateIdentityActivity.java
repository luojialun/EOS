package com.android.eos.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建身份页面
 */
public class CreateIdentityActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

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
                readyGo(MyIdentityActivity.class);
                break;
        }
    }
}
