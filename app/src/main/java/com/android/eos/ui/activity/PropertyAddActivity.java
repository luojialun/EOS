package com.android.eos.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.ui.adapter.PropertyAddAdapter;
import com.android.eos.widget.dialog.ManageDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加资产
 */
public class PropertyAddActivity extends BaseActivity {

    @BindView(R.id.property_rv)
    RecyclerView propertyRv;

    private PropertyAddAdapter addAdapter;

    @Override
    public int setViewId() {
        return R.layout.activity_property_add;
    }

    @Override
    public void initView() {
        initAdapter();

    }

    private void initAdapter() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        propertyRv.setLayoutManager(new LinearLayoutManager(this));
        addAdapter = new PropertyAddAdapter(dataList);
        propertyRv.setAdapter(addAdapter);
    }


    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.manage_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.manage_tv:
                ManageDialog manageDialog = new ManageDialog(this);
                manageDialog.show();
                break;
        }
    }
}
