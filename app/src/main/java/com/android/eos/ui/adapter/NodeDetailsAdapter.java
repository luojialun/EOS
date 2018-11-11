package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 节点设置详情适配器
 */

public class NodeDetailsAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public NodeDetailsAdapter(@Nullable List<String> data) {
        super(R.layout.item_node_details,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
