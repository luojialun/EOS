package com.android.eos.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.bean.FindResponse;
import com.android.eos.data.TempData;
import com.android.eos.event.FindDataEvent;
import com.android.eos.ui.adapter.BaseFragmentPagerAdapter;
import com.android.eos.ui.adapter.HotAdapter;
import com.android.eos.ui.adapter.LatestGameAdapter;
import com.android.eos.ui.adapter.RecommandAdapter;
import com.android.eos.widget.MyRecyclerView;
import com.android.eos.widget.TransformViewPager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    }

    private void initBannerAdapter() {
        if (null != TempData.getFindResponse()) {
            List<Fragment> fragmentList = new ArrayList<>();
            for (FindResponse.BannerBean bean : TempData.getFindResponse().getGame().getBanner()) {
                fragmentList.add(BannerFragment.newInstance(bean.getIcon(), bean.getUrl()));
            }
            bannerVp.setAdapter(new BaseFragmentPagerAdapter(getChildFragmentManager(), fragmentList));
            bannerVp.setOffscreenPageLimit(fragmentList.size());
        }
    }

    private void initLatestGameAdapter() {
        if (null != TempData.getFindResponse()) {
            List<FindResponse.WeekBean> dataList = new ArrayList<>();
            for (FindResponse.WeekBean bean : TempData.getFindResponse().getGame().getWeek()) {
                dataList.add(bean);
            }
            latestGameRv.setLayoutManager(new LinearLayoutManager(getActivity()));
            latestGameRv.setAdapter(new LatestGameAdapter(dataList));
        }
    }

    private void initRecommandAdapter() {
        if (null != TempData.getFindResponse()) {
            List<FindResponse.HotsBean> dataList = new ArrayList<>();
            for (FindResponse.HotsBean bean : TempData.getFindResponse().getGame().getHots()) {
                dataList.add(bean);
            }
            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            hotRv.setLayoutManager(manager);
            hotRv.setAdapter(new RecommandAdapter(dataList));

        }


    }

    @Override
    public void initData() {

    }

    @Override
    public boolean bindEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void findData(FindDataEvent event) {
        initBannerAdapter();
        initLatestGameAdapter();
        initRecommandAdapter();
    }

}
