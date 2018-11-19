package com.android.eos.ui.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.bean.DealListMsgResponse;
import com.android.eos.data.TempData;
import com.android.eos.data.UserInfo;
import com.android.eos.event.GetDealListEvent;
import com.android.eos.ui.adapter.TCAllAdapter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 转账和收款-转出页面
 */
public class TCOutFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    TCAllAdapter adapter;

    @Override
    public int setViewId() {
        return R.layout.fragment_tcall;
    }

    @Override
    public void initView() {
        initAdapter();
    }

    private void initAdapter() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TCAllAdapter(null);
        rv.setAdapter(adapter);
    }

    public void setData() {
        List<DealListMsgResponse.ActionsBean> dataList = new ArrayList<>();
        for (DealListMsgResponse.ActionsBean actionsBean : TempData.getActionsBeanList()) {
            if (actionsBean.getAction_trace().getAct().getData().getFrom().equals(UserInfo.getAccount())) {
                dataList.add(actionsBean);
            }
        }
        if (0 == dataList.size()) {
            adapter.setNewData(null);
            adapter.setEmptyView(R.layout.layout_empty,rv);
        } else {
            adapter.setNewData(dataList);
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean bindEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDealListMsg(GetDealListEvent event) {
        if (event.isSuccess()) {
            setData();
        } else {
            adapter.setEmptyView(R.layout.layout_empty,rv);
        }
    }
}
