package com.android.eos.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.bean.FindResponse;
import com.android.eos.data.TempData;
import com.android.eos.event.FindDataEvent;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

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
        getDiscoveryData();
    }

    private void getDiscoveryData() {
        HttpUtils.getRequets(UrlHelper.find, getActivity(), new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                FindResponse findResponse = (FindResponse) parseStringToBean(response.body().toString(), FindResponse.class);
                if (null != findResponse) {
                    TempData.setFindResponse(findResponse);
                    EventBus.getDefault().post(new FindDataEvent(true));
                } else {
                    EventBus.getDefault().post(new FindDataEvent(false));
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                EventBus.getDefault().post(new FindDataEvent(false));
            }
        });
    }


}
