package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 钱包列表适配器
 */

public class WalletAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public WalletAdapter(@Nullable List<String> data) {
        super(R.layout.item_wallet,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
