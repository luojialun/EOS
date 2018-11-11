package com.android.eos.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 使用设置页面
 */
public class UseSettingActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_use_setting;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.use_setting);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv,R.id.node_setting_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.node_setting_rl:
                readyGo(NodeSettingActivity.class);
                break;
        }
    }
}
