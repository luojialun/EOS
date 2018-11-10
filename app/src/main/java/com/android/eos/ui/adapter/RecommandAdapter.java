package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 发现-推荐-
 */
public class RecommandAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public RecommandAdapter(@Nullable List<String> data) {
        super(R.layout.item_recommand, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
