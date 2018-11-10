package com.android.eos.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.adapter.ExchangeAdapter;
import com.android.eos.ui.adapter.TCAllAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 转账和收款-全部页面
 */
public class TCAllFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    TCAllAdapter adapter;

    @Override
    public int setViewId() {
        return R.layout.fragment_tcall;
    }

    @Override
    public void initView() {
        initAdapter();

    }

    public void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TCAllAdapter(dataList);
        rv.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }

}
