package com.android.eos.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.bean.CurrencyListResponse;
import com.android.eos.bean.PriceResponse;
import com.android.eos.data.UserInfo;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.ui.activity.CollectionCodeActivity;
import com.android.eos.ui.activity.ExchangeActivity;
import com.android.eos.ui.activity.MyWalletActivity;
import com.android.eos.ui.activity.PropertyAddActivity;
import com.android.eos.ui.activity.TransAndCollectionActivity;
import com.android.eos.ui.activity.WalletMessageActivity;
import com.android.eos.ui.adapter.MoneyListAdapter;
import com.android.eos.utils.LogUtils;
import com.android.eos.widget.dialog.ShowDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

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
        adapter = new MoneyListAdapter(null);
        moneyRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        moneyRv.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
    }

    @Override
    public void initData() {
        getCurrencyList();
        getKeyAccounts();
    }

    private void getCurrencyList() {
        showProgress();
        HttpUtils.getRequets(UrlHelper.getCurrencyList, getActivity(), null, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                CurrencyListResponse currencyListResponse = (CurrencyListResponse) parseStringToBean(response.body().toString(), CurrencyListResponse.class);
                StringBuffer symbol = new StringBuffer();
                for (CurrencyListResponse.EOSBean eosBean : currencyListResponse.getEos()) {
                    symbol.append(eosBean.getName() + ",");
                    getCurrencyBalance(eosBean.getAddress(), UserInfo.getAccount());
                }
                symbol.deleteCharAt(symbol.length() - 1);
                getPrice(symbol.toString());

            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);

            }
        });
    }

    private void getPrice(String symbol) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("symbol", symbol);
        HttpUtils.getRequets(UrlHelper.getPrice, getActivity(), paramsMap, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                PriceResponse priceResponse = (PriceResponse) parseStringToBean(response.body().toString(), PriceResponse.class);

            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);

            }
        });
    }

    private void getKeyAccounts() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("public_key", UserInfo.getOwnerKey());
        String params = new Gson().toJson(paramsMap);
        HttpUtils.postRequest(UrlHelper.getKeyAccounts, getActivity(), params, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                LogUtils.loge("key account-->" + response.body().toString());
            }
        });
    }

    public void getCurrencyBalance(String code, String account) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("code", code);
        paramsMap.put("account", account);
        String params = new Gson().toJson(paramsMap);
        HttpUtils.postRequest(UrlHelper.getCurrencyBalance, getActivity(), params, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                LogUtils.loge("getCurrencyBalance-->" + response.body().toString());
            }
        });
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
