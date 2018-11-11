package com.android.eos.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.android.eos.ui.adapter.MoneyListAdapter;
import com.android.eos.ui.fragment.MortgageFragment;
import com.android.eos.ui.fragment.RecommandIDFragment;
import com.android.eos.ui.fragment.RecommandIncomeFragment;
import com.android.eos.ui.fragment.RedeemFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyRecommandActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener{

    @BindView(R.id.recommand_rv)
    RecyclerView recommandRv;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    SlidingTabLayout tableLayout;

    private MoneyListAdapter adapter;
    private String[] titles = {"推荐ID", "推荐收益"};

    @Override
    public int setViewId() {
        return R.layout.activity_my_recommand;
    }

    @Override
    public void initView() {
        initAdapter();
        initTabAndViewpager();
    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            dataList.add("1");
        }
        adapter = new MoneyListAdapter(dataList);
        recommandRv.setLayoutManager(new LinearLayoutManager(this));
        recommandRv.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
    }

    private void initTabAndViewpager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new RecommandIDFragment());
        fragmentList.add(new RecommandIncomeFragment());
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        tableLayout.setViewPager(viewPager, titles);

    }


    @Override
    public void initData() {

    }

    /**
     * MoneyListAdapter的点击事件
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.item_ll:
                readyGo(TransAndCollectionActivity.class);
                break;
            case R.id.collection_code_iv:
                readyGo(CollectionCodeActivity.class);
                break;
        }
    }
}
