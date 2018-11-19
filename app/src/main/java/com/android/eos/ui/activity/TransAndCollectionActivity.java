package com.android.eos.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.DealListMsgRequest;
import com.android.eos.bean.DealListMsgResponse;
import com.android.eos.data.TempData;
import com.android.eos.data.UserInfo;
import com.android.eos.event.GetDealListEvent;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.android.eos.ui.fragment.TCAllFragment;
import com.android.eos.ui.fragment.TCInFragment;
import com.android.eos.ui.fragment.TCOutFragment;
import com.android.eos.utils.ChartUtil;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.TimeUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.github.mikephil.charting.charts.LineChart;
import com.google.gson.Gson;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 转账和收款页面
 */
public class TransAndCollectionActivity extends BaseActivity {

    @BindView(R.id.left_iv)
    ImageView leftIv;
    @BindView(R.id.right_iv)
    ImageView rightIv;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tablayout)
    SlidingTabLayout tableLayout;
    @BindView(R.id.chart)
    LineChart chart;

    private String[] titles = {"全部", "转入", "转出"};
    private int offset = 100;

    @Override
    public int setViewId() {
        return R.layout.activity_trans_and_collection;
    }

    @Override
    public void initView() {
        initTitle();
        initTabAndViewpager();
        ChartUtil.initChart(chart);
    }

    private void initTitle() {
        titleTv.setText("EOS");
        leftIv.setImageResource(R.mipmap.back_white);
        rightIv.setImageResource(R.mipmap.trans_collection_1);
    }

    private void initTabAndViewpager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCInFragment());
        fragmentList.add(new TCOutFragment());
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        tableLayout.setViewPager(viewPager, titles);
        viewPager.setOffscreenPageLimit(fragmentList.size());
    }

    @Override
    public void initData() {
        getDealMsg(10, offset);
    }

    @OnClick({R.id.left_iv, R.id.collection_fl, R.id.transfer_fl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_iv:
                finish();
                break;
            case R.id.collection_fl:
                Intent intent = new Intent(this, CollectionCodeActivity.class);
                intent.putExtra(ConstantUtils.ACCOUNT, UserInfo.getAccount());
                startActivity(intent);
                break;
            case R.id.transfer_fl:
                readyGo(TransferActivity.class);
                break;
        }
    }

    public void getDealMsg(int pos, int offset) {
        showProgress();
        DealListMsgRequest request = new DealListMsgRequest();
        request.setAccount_name(UserInfo.getAccount());
        request.setOffset(offset);
        request.setPos(pos);
        String params = new Gson().toJson(request);
        HttpUtils.postRequest(UrlHelper.getDealMsgList, this, params, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                dismissProgress();
                DealListMsgResponse dealListMsgResponse = (DealListMsgResponse) parseStringToBean(response.body().toString(), DealListMsgResponse.class);
                if (null != dealListMsgResponse && 0 < dealListMsgResponse.getActions().size()) {
                    //过滤交易列表
                    List<DealListMsgResponse.ActionsBean> actionsBeanList = new ArrayList<>();
                    for (DealListMsgResponse.ActionsBean actionsBean : dealListMsgResponse.getActions()) {
                        if (actionsBean.getAction_trace().getAct().getName().equals("transfer")) {
                            actionsBeanList.add(actionsBean);
                        }
                    }
                    TempData.setActionsBeanList(actionsBeanList);
                    EventBus.getDefault().post(new GetDealListEvent(true));
                    //图表数据
                    List<Float> yData = new ArrayList<>(7);
                    for (int i = 0; i < 7; i++) {
                        boolean isAdd = false;
                        if (actionsBeanList.size() > 0) {
                            for (DealListMsgResponse.ActionsBean actionsBean : actionsBeanList) {
                                if (TimeUtils.getOldDate(i - 6, "yyyy-MM-dd HH:mm:ss").equals(TimeUtils.dealEosTime(actionsBean.getBlock_time()))) {
                                    yData.add((float) dealListMsgResponse.getActions().get(i).getBlock_num());
                                    isAdd = true;
                                    continue;
                                }
                            }
                        }
                        if (!isAdd) {
                            yData.add(0f);
                        }
                    }
                    ChartUtil.setChartData(chart, yData);
                } else {
                    EventBus.getDefault().post(new GetDealListEvent(true));
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                EventBus.getDefault().post(new GetDealListEvent(true));
            }
        });
    }

}
