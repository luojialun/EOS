package com.android.eos.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.android.eos.ui.fragment.BuyInFragment;
import com.android.eos.ui.fragment.DiscoveryDAPPFragment;
import com.android.eos.ui.fragment.DiscoveryGameFragment;
import com.android.eos.ui.fragment.SellOutFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 内存页面
 */
public class MemoryActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    SlidingTabLayout tableLayout;
    @BindView(R.id.bottom_fl)
    FrameLayout bottomFl;
    @BindView(R.id.bottom_iv)
    ImageView bottomIv;
    @BindView(R.id.bottom_tip_tv)
    TextView bottomTipTv;

    private String[] titles = {"买入", "卖出"};

    @Override
    public int setViewId() {
        return R.layout.activity_memory;
    }

    @Override
    public void initView() {
        initTitle();
        initTabAndViewpager();

    }


    private void initTitle() {
        titleTv.setText(R.string.memory);
    }

    private void initTabAndViewpager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new BuyInFragment());
        fragmentList.add(new SellOutFragment());
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        tableLayout.setViewPager(viewPager, titles);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (0 == i) {
                    bottomFl.setBackgroundColor(getResources().getColor(R.color.green));
                    bottomIv.setImageResource(R.mipmap.buy_in);
                    bottomTipTv.setText(getResources().getString(R.string.buy_in));
                    bottomTipTv.setTextColor(getResources().getColor(R.color.white));
                } else if (1 == i) {
                    bottomFl.setBackgroundColor(getResources().getColor(R.color.gray3));
                    bottomIv.setImageResource(R.mipmap.sell_out);
                    bottomTipTv.setText(getResources().getString(R.string.sell_out));
                    bottomTipTv.setTextColor(getResources().getColor(R.color.gray));
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }
}
