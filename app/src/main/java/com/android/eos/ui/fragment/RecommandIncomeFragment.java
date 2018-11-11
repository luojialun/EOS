package com.android.eos.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.adapter.RecommandIDAdapter;
import com.android.eos.ui.adapter.RecommandIncomeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 推荐收入页面
 */
public class RecommandIncomeFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    public int setViewId() {
        return R.layout.fragment_recommand_income;
    }

    @Override
    public void initView() {
        initAdapter();
    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("111");
        dataList.add("111");
        dataList.add("111");
        dataList.add("111");
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new RecommandIncomeAdapter(dataList));
    }

    @Override
    public void initData() {

    }

}
