package com.android.eos.ui.activity;

import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.OnClick;

/**
 * 资源管理页面
 */

public class ResourceManageActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_resource_manage;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.memory_ll, R.id.broadband_ll})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.memory_ll:
                readyGo(MemoryActivity.class);
                break;
            case R.id.broadband_ll:
                readyGo(BoardBandActivity.class);
                break;
        }
    }
}
