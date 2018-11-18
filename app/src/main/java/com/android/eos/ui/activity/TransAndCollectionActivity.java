package com.android.eos.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.android.eos.ui.fragment.TCAllFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 转账和收款页面
 */
public class TransAndCollectionActivity extends BaseActivity {

    @BindView(R.id.left_iv)
    ImageView leftIv;
    @BindView(R.id.right_iv)
    ImageView rightIv;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    SlidingTabLayout tableLayout;

    private String[] titles = {"全部", "转入", "转出", "失败"};

    @Override
    public int setViewId() {
        return R.layout.activity_trans_and_collection;
    }

    @Override
    public void initView() {
        initTitle();
        initTabAndViewpager();

    }

    private void initTitle() {
        titleTv.setText("ETH");
        leftIv.setImageResource(R.mipmap.back_white);
        rightIv.setImageResource(R.mipmap.trans_collection_1);
    }

    private void initTabAndViewpager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCAllFragment());
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        tableLayout.setViewPager(viewPager, titles);

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.left_iv, R.id.collection_fl, R.id.transfer_fl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_iv:
                finish();
                break;
            case R.id.collection_fl:
                readyGo(CollectionCodeActivity.class);
                break;
            case R.id.transfer_fl:
                readyGo(TransferActivity.class);
                break;
        }
    }

}
