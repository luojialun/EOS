package com.android.eos.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.adapter.BaseFragmentPagerAdapter;
import com.android.eos.ui.adapter.HotAdapter;
import com.android.eos.ui.adapter.LatestGameAdapter;
import com.android.eos.ui.adapter.RecommandAdapter;
import com.android.eos.widget.MyRecyclerView;
import com.android.eos.widget.TransformViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 发现-游戏页面
 */
public class DiscoveryGameFragment extends BaseFragment {

    @BindView(R.id.banner_vp)
    TransformViewPager bannerVp;
    @BindView(R.id.latest_game_rv)
    RecyclerView latestGameRv;
    @BindView(R.id.hot_rv)
    RecyclerView hotRv;

    @Override
    public int setViewId() {
        return R.layout.fragment_discovery_game;
    }

    @Override
    public void initView() {
        initBannerAdapter();
        initLatestGameAdapter();
        initRecommandAdapter();

    }


    private void initBannerAdapter() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new BannerFragment());
        fragmentList.add(new BannerFragment());
        fragmentList.add(new BannerFragment());
        fragmentList.add(new BannerFragment());
        fragmentList.add(new BannerFragment());
        bannerVp.setAdapter(new BaseFragmentPagerAdapter(getChildFragmentManager(), fragmentList));
        bannerVp.setOffscreenPageLimit(fragmentList.size());
    }

    private void initLatestGameAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1");
        latestGameRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        latestGameRv.setAdapter(new LatestGameAdapter(dataList));

    }

    private void initRecommandAdapter() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            dataList.add("1");
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hotRv.setLayoutManager(manager);
        hotRv.setAdapter(new RecommandAdapter(dataList));


    }

    @Override
    public void initData() {

    }

}
