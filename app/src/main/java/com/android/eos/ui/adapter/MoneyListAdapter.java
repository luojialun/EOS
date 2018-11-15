package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.android.eos.bean.CurrencyListResponse;
import com.android.eos.bean.MixCurrencyListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 货币列表适配器
 */
public class MoneyListAdapter extends BaseQuickAdapter<MixCurrencyListBean, BaseViewHolder> {

    public MoneyListAdapter(@Nullable List<MixCurrencyListBean> data) {
        super(R.layout.item_money_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MixCurrencyListBean item) {



        helper.addOnClickListener(R.id.collection_code_iv);
        helper.addOnClickListener(R.id.item_ll);
    }
}
