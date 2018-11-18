package com.android.eos.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.eos.R;
import com.android.eos.bean.HelpProblemResponse;
import com.android.eos.ui.activity.H5Activity;
import com.android.eos.utils.ConstantUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/17.
 */

public class TypeProblemAdapter extends BaseQuickAdapter<HelpProblemResponse.TypesBean, BaseViewHolder> {
    public TypeProblemAdapter(@Nullable List<HelpProblemResponse.TypesBean> data) {
        super(R.layout.item_type_problem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HelpProblemResponse.TypesBean item) {

        helper.setText(R.id.title_tv, item.getTitle());
        helper.setText(R.id.desc_tv, item.getDetail());

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
