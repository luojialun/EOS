package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 钱包列表适配器
 */
public class WalletListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public WalletListAdapter(@Nullable List<String> data) {
        super(R.layout.item_wallet_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.more_iv);
    }
}
