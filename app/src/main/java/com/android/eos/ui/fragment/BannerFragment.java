package com.android.eos.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.net.GlideApp;
import com.android.eos.ui.activity.GameActivity;
import com.android.eos.ui.activity.H5Activity;
import com.android.eos.utils.ConstantUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发现-游戏-banner
 */
public class BannerFragment extends BaseFragment {

    @BindView(R.id.banner_iv)
    ImageView bannerIv;

    private String picUrl;
    private String jumpUrl;

    public static BannerFragment newInstance(String picUrl, String jumpUrl) {
        Bundle bundle = new Bundle();
        bundle.putString(ConstantUtils.PIC_URL, picUrl);
        bundle.putString(ConstantUtils.JUMP_URL, jumpUrl);
        BannerFragment fragment = new BannerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public int setViewId() {
        return R.layout.fragment_banner;
    }

    @Override
    public void initView() {
        initParams();
    }

    private void initParams() {
        picUrl = getArguments().getString(ConstantUtils.PIC_URL);
        jumpUrl = getArguments().getString(ConstantUtils.JUMP_URL);
    }

    @Override
    public void initData() {
        GlideApp.with(getActivity()).load(picUrl).into(bannerIv);
        bannerIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), H5Activity.class);
                intent.putExtra(ConstantUtils.H5_TYPE, ConstantUtils.SELF_WEB);
                intent.putExtra(ConstantUtils.SELF_WEB_URL, jumpUrl);
                startActivity(intent);
            }
        });
    }

}
