package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/9.
 */

public class ExchangeAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ExchangeAdapter(@Nullable List<String> data) {
        super(R.layout.item_exchange,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
