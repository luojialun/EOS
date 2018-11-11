package com.android.eos.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.NodeDetailsAdapter;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 节点设置详情页面
 */
public class NodeSettingDetailsActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.node_rv)
    MyRecyclerView nodeRv;

    @Override
    public int setViewId() {
        return R.layout.activity_node_setting_details;
    }

    @Override
    public void initView() {
        initTitle();
        initAdapter();

    }

    private void initTitle() {
        titleTv.setText(getIntent().getStringExtra(ConstantUtils.TITLE));
    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("11");
        dataList.add("11");
        dataList.add("11");
        NodeDetailsAdapter adapter = new NodeDetailsAdapter(dataList);
        nodeRv.setLayoutManager(new LinearLayoutManager(this));
        nodeRv.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.save_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.save_tv:
                finish();
                break;
        }
    }
}
