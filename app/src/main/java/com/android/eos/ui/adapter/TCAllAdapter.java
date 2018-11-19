package com.android.eos.ui.adapter;

import android.support.annotation.Nullable;

import com.android.eos.R;
import com.android.eos.bean.DealListMsgResponse;
import com.android.eos.data.UserInfo;
import com.android.eos.utils.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by luojialun on 2018/11/9.
 */

public class TCAllAdapter extends BaseQuickAdapter<DealListMsgResponse.ActionsBean, BaseViewHolder> {

    public TCAllAdapter(@Nullable List<DealListMsgResponse.ActionsBean> data) {
        super(R.layout.item_exchange, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DealListMsgResponse.ActionsBean item) {
        helper.setText(R.id.currency1_tv, item.getAction_trace().getAct().getData().getFrom());
        helper.setText(R.id.currency2_tv, item.getAction_trace().getAct().getData().getTo());
        if (item.getAction_trace().getAct().getData().getFrom().equals(UserInfo.getAccount())) {
            helper.setText(R.id.count_tv, "-" + item.getAction_trace().getAct().getData().getQuantity());
        } else if (item.getAction_trace().getAct().getData().getTo().equals(UserInfo.getAccount())) {
            helper.setText(R.id.count_tv, "+" + item.getAction_trace().getAct().getData().getQuantity());
        }

        helper.setText(R.id.time_tv, TimeUtils.dealEosTime(item.getAction_trace().getBlock_time()));

    }
}
