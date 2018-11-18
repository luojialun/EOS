package com.android.eos.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.DealListMsgRequest;
import com.android.eos.bean.DealListMsgResponse;
import com.android.eos.data.UserInfo;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.ui.adapter.MainPagerAdapter;
import com.android.eos.ui.fragment.TCAllFragment;
import com.android.eos.utils.ChartUtil;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.LogUtils;
import com.android.eos.utils.TimeUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.google.gson.Gson;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private String[] titles = {"全部", "转入", "转出", "失败"};

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
        titleTv.setText("ETH");
        leftIv.setImageResource(R.mipmap.back_white);
        rightIv.setImageResource(R.mipmap.trans_collection_1);
    }

    private void initTabAndViewpager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCAllFragment());
        fragmentList.add(new TCAllFragment());
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        tableLayout.setViewPager(viewPager, titles);

    }

    @Override
    public void initData() {
        getDealMsg(0, 0);
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
        DealListMsgRequest request = new DealListMsgRequest();
        request.setAccount_name(UserInfo.getAccount());
        request.setOffset(offset);
        request.setPos(pos);
        String params = new Gson().toJson(request);
        HttpUtils.postRequest(UrlHelper.getDealMsgList, this, params, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                DealListMsgResponse dealListMsgResponse = (DealListMsgResponse) parseStringToBean(response.body().toString(), DealListMsgResponse.class);
                if (null != dealListMsgResponse) {
                    //LogUtils.loge(TimeUtils.dealEosTime(dealListMsgResponse.getActions().get(0).getBlock_time()));
                    List<Float> yData = new ArrayList<>(7);

                    for (int i = 0; i < 7; i++) {
                        boolean isAdd = false;
                        for (DealListMsgResponse.ActionsBean actionsBean : dealListMsgResponse.getActions()) {
                            if (TimeUtils.getOldDate(i - 6, "yyyy-MM-dd HH:mm:ss").equals(TimeUtils.dealEosTime(actionsBean.getBlock_time()))) {
                                yData.add((float) dealListMsgResponse.getActions().get(i).getBlock_num());
                                isAdd = true;
                                continue;
                            }
                        }
                        if (!isAdd) {
                            yData.add(0f);
                        }
                    }
                    ChartUtil.setChartData(chart, yData);


                }
            }
        });
    }


    private void initChart() {

        // 不显示数据描述
        chart.getDescription().setEnabled(false);
        // 没有数据的时候，显示“暂无数据”
        chart.setNoDataText("暂无数据");
        // 不显示表格颜色
        chart.setDrawGridBackground(false);
        // 不可以缩放
        chart.setScaleEnabled(false);
        // 不显示y轴右边的值
        chart.getAxisRight().setEnabled(false);
        // 不显示图例
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        // 向左偏移15dp，抵消y轴向右偏移的30dp
        chart.setExtraLeftOffset(-15);

        XAxis xAxis = chart.getXAxis();
        // 不显示x轴
        xAxis.setDrawAxisLine(true);
        // 设置x轴数据的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.parseColor("#CECECE"));
        xAxis.setTextSize(12);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisLineColor(Color.parseColor("#90CCFD"));
        // 设置x轴数据偏移量
        //xAxis.setYOffset(-12);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 6) {
                data.add(TimeUtils.getOldDate(i - 6, "MM/dd"));
            } else {
                data.add(TimeUtils.getOldDate(i - 6, "dd"));
            }
        }
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return data.get((int) value);
            }
        });


        YAxis yAxis = chart.getAxisLeft();
        // 不显示y轴
        yAxis.setDrawAxisLine(false);
//        // 设置y轴数据的位置
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//        // 不从y轴发出横向直线
        yAxis.setDrawGridLines(true);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setGridColor(Color.parseColor("#f8f8f9"));
//        yAxis.setTextSize(12);
//        // 设置y轴数据偏移量
//        yAxis.setXOffset(30);
//        yAxis.setYOffset(-3);
//        yAxis.setAxisMinimum(0);

        //Matrix matrix = new Matrix();
        // x轴缩放1.5倍
        //matrix.postScale(1.5f, 1f);
        // 在图表动画显示之前进行缩放
        //chart.getViewPortHandler().refresh(matrix, chart, false);
        // x轴执行动画
        //chart.animateX(2000);
        chart.invalidate();
    }

    private void setChartData() {

        LineDataSet lineDataSet;
        List<Entry> values = new ArrayList<>();
        values.add(new Entry(0, 10));
        values.add(new Entry(1, 20));
        values.add(new Entry(2, 30));
        values.add(new Entry(3, 40));
        values.add(new Entry(4, 50));
        values.add(new Entry(5, 30));
        values.add(new Entry(6, 40));


        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {

            lineDataSet = new LineDataSet(values, "");
            lineDataSet.setLineWidth(5);
            // 设置曲线颜色
            lineDataSet.setColor(Color.parseColor("#00CE9F"));
            // 设置平滑曲线
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(true);
            lineDataSet.setCircleRadius(5);
            lineDataSet.setCircleHoleRadius(3);
            lineDataSet.setCircleHoleColor(Color.WHITE);
            lineDataSet.setCircleColor(Color.parseColor("#DDE1EB"));
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(true);
            // 不显示定位线
            lineDataSet.setHighlightEnabled(false);

            LineData data = new LineData(lineDataSet);
            chart.setData(data);
            chart.invalidate();
        }
    }

}
