package com.android.eos.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.WalletAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectWalletActivity extends BaseActivity {

    @BindView(R.id.wallet_rv)
    RecyclerView walletRv;
    @BindView(R.id.title_tv)
    TextView titleTv;

    private WalletAdapter adapter;

    @Override
    public int setViewId() {
        return R.layout.activity_select_wallet;
    }

    @Override
    public void initView() {
        iniTitle();
        initAdapter();
    }

    private void iniTitle() {
        titleTv.setText(R.string.select_wallet_type);
    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("2");
        dataList.add("3");
        walletRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WalletAdapter(dataList);
        walletRv.setAdapter(adapter);
    }


    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }
}
