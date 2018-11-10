package com.android.eos.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 发现页面
 */
public class DiscoveryFragment extends BaseFragment {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.back_iv)
    ImageView searchIv;
    @BindView(R.id.tablayout)
    SlidingTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private String[] titles = {"游戏", "DAPP"};

    @Override
    public int setViewId() {
        return R.layout.fragment_discovery;
    }

    @Override
    public void initView() {
        iniTitle();
        initTabAndViewpager();
    }

    private void iniTitle() {
        titleTv.setText(R.string.discovery);
        searchIv.setVisibility(View.GONE);
    }

    private void initTabAndViewpager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new DiscoveryGameFragment());
        fragmentList.add(new DiscoveryDAPPFragment());
        viewPager.setAdapter(new MainPagerAdapter(getChildFragmentManager(), fragmentList));
        tablayout.setViewPager(viewPager, titles);
    }

    @Override
    public void initData() {

    }

}
