package com.android.eos.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.android.eos.R;
import com.android.eos.bean.FindResponse;
import com.android.eos.net.GlideApp;
import com.android.eos.ui.activity.H5Activity;
import com.android.eos.utils.ConstantUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/7.
 */

public class HotAdapter extends BaseQuickAdapter<FindResponse.RecommendBean, BaseViewHolder> {

    public HotAdapter(@Nullable List<FindResponse.RecommendBean> data) {
        super(R.layout.item_hot, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindResponse.RecommendBean item) {
        helper.setText(R.id.name_tv, item.getName());
        GlideApp.with(mContext).load(item.getIcon()).into((ImageView) helper.getView(R.id.icon_iv));
        helper.getView(R.id.item_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, H5Activity.class);
                intent.putExtra(ConstantUtils.H5_TYPE, ConstantUtils.SELF_WEB);
                intent.putExtra(ConstantUtils.SELF_WEB_URL, item.getUrl());
                mContext.startActivity(intent);
            }
        });
    }
}
