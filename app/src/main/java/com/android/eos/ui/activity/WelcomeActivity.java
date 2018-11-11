package com.android.eos.ui.activity;

import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.OnClick;

/**
 * 入口欢迎页
 */
public class WelcomeActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.create_id_btn, R.id.import_id})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.create_id_btn:
                readyGo(CreateEOSActivity.class);
                break;
            case R.id.import_id:
                readyGo(ImportEOSWalletActivity.class);
                break;
        }
    }
}
