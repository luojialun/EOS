package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/11.
 */

public class RecommandIDAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RecommandIDAdapter(@Nullable List<String> data) {
        super(R.layout.item_recommand_id,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
