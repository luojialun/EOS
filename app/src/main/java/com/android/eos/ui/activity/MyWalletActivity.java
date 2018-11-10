package com.android.eos.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.WalletListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的钱包
 */
public class MyWalletActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.coin_rv)
    RecyclerView coinRv;
    private WalletListAdapter adapter;

    @Override
    public int setViewId() {
        return R.layout.activity_my_wallet;
    }

    @Override
    public void initView() {
        initTitle();
        initAdapter();
    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        coinRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WalletListAdapter(dataList);
        coinRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                readyGo(WalletMessageActivity.class);
            }
        });
    }

    private void initTitle() {
        titleTv.setText(R.string.my_wallet);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.import_wallet_ll})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.import_wallet_ll:
                readyGo(SelectWalletActivity.class);
                break;
        }
    }
}
