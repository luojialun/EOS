package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/7.
 */

public class LatestGameAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public LatestGameAdapter(@Nullable List<String> data) {
        super(R.layout.item_latest_game,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
