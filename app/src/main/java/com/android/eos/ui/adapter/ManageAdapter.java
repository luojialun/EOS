package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.android.eos.bean.ManageBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/10.
 */

public class ManageAdapter extends BaseQuickAdapter<ManageBean, BaseViewHolder> {

    public ManageAdapter(@Nullable List<ManageBean> data) {
        super(R.layout.item_manage,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ManageBean item) {
        helper.setImageResource(R.id.icon_iv, item.getImg());
        helper.setText(R.id.content_tv, item.getDesc());
        if (helper.getLayoutPosition() == getData().size() - 1) {
            helper.setVisible(R.id.view, false);
        } else {
            helper.setVisible(R.id.view, true);
        }
    }
}
