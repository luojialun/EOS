package com.android.eos.ui.fragment;


import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.activity.GameActivity;

import butterknife.OnClick;

/**
 * 发现-游戏-banner
 */
public class BannerFragment extends BaseFragment {

    @Override
    public int setViewId() {
        return R.layout.fragment_banner;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.banner_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.banner_iv:
                readyGo(GameActivity.class);
                break;
        }
    }


}
