package com.android.eos.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.activity.CollectionCodeActivity;
import com.android.eos.ui.activity.ExchangeActivity;
import com.android.eos.ui.activity.MyWalletActivity;
import com.android.eos.ui.activity.PropertyAddActivity;
import com.android.eos.ui.activity.TransAndCollectionActivity;
import com.android.eos.ui.activity.WalletMessageActivity;
import com.android.eos.ui.adapter.MoneyListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 资产页面
 */
public class PropertyFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.money_rv)
    RecyclerView moneyRv;

    private MoneyListAdapter adapter;

    @Override
    public int setViewId() {
        return R.layout.fragment_property;
    }

    @Override
    public void initView() {
        initAdapter();
    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add("1");
        }
        adapter = new MoneyListAdapter(dataList);
        moneyRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        moneyRv.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.scan_iv, R.id.right_iv, R.id.wallet_message_iv, R.id.exchange_ll, R.id.collection_code_ll, R.id.property_add_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan_iv:
                break;
            case R.id.right_iv:
                readyGo(MyWalletActivity.class);
                break;
            case R.id.wallet_message_iv:
                readyGo(WalletMessageActivity.class);
                break;
            case R.id.exchange_ll:
                readyGo(ExchangeActivity.class);
                break;
            case R.id.collection_code_ll:
                readyGo(CollectionCodeActivity.class);
                break;
            case R.id.property_add_iv:
                readyGo(PropertyAddActivity.class);
                break;

        }
    }

    /**
     * MoneyListAdapter  子view点击事件
     *
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
