package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.android.eos.R;
import com.android.eos.bean.CurrencyListResponse;
import com.android.eos.bean.MixCurrencyListBean;
import com.android.eos.net.GlideApp;
import com.bumptech.glide.Glide;
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
        if (null != item.getEosBean()) {
            GlideApp.with(mContext).load(item.getEosBean().getIcon()).into((ImageView) helper.getView(R.id.icon_iv));
            helper.setText(R.id.name_tv, item.getEosBean().getName());
            helper.setText(R.id.address_tv, item.getEosBean().getAddress());
        }
        if (null != item.getPriceBean()) {
            helper.setText(R.id.price_tv, item.getPriceBean().getPrice() + "");
        }
        helper.setText(R.id.count_tv, item.getCount());

        helper.addOnClickListener(R.id.collection_code_iv);
        helper.addOnClickListener(R.id.item_ll);
    }
}
