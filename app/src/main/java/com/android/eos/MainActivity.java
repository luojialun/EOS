package com.android.eos;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.android.eos.bean.TabEntity;
import com.android.eos.ui.fragment.BusinessFragment;
import com.android.eos.ui.fragment.DiscoveryFragment;
import com.android.eos.ui.fragment.MineFragment;
import com.android.eos.ui.fragment.PropertyFragment;
import com.android.eos.utils.ToastUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_tablayout)
    CommonTabLayout bottomTablayout;
    @BindView(R.id.vp)
    ViewPager viewPager;

    private long firstTime = 0;
    private ArrayList<CustomTabEntity> tabEntityList = new ArrayList<>();
    private String[] iconTexts = {"资产", "交易", "发现", "我的"};
    private int[] iconselectIds = {R.mipmap.tab_property_select, R.mipmap.tab_business_select, R.mipmap.tab_discovery_select, R.mipmap.tab_mine_select};
    private int[] iconUnselectIds = {R.mipmap.tab_property_unselect, R.mipmap.tab_business_unselect, R.mipmap.tab_discovery_unselect, R.mipmap.tab_mine_unselect};

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                ToastUtils.showToast("再按一次退出");
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initTabAndViewPager();
    }

    private void initTabAndViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PropertyFragment());
        fragmentList.add(new BusinessFragment());
        fragmentList.add(new DiscoveryFragment());
        fragmentList.add(new MineFragment());

        for (int i = 0; i < fragmentList.size(); i++) {
            tabEntityList.add(new TabEntity(iconselectIds[i], iconUnselectIds[i], iconTexts[i]));
        }
        bottomTablayout.setTabData(tabEntityList);
        bottomTablayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.setOffscreenPageLimit(fragmentList.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bottomTablayout.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void initData() {

    }

    public static void readGoMain(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }


}
