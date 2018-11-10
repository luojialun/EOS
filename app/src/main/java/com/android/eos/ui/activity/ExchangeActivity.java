package com.android.eos.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.ExchangeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 兑换页面
 */
public class ExchangeActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTV;
    @BindView(R.id.exchange_rv)
    RecyclerView exchangeRv;

    private ExchangeAdapter adapter;

    @Override
    public int setViewId() {
        return R.layout.activity_exchange;
    }

    @Override
    public void initView() {
        initTitle();
        initAdapter();

    }

    private void initTitle() {
        titleTV.setText(R.string.exchange);
    }

    public void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        exchangeRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExchangeAdapter(dataList);
        exchangeRv.setAdapter(adapter);
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
