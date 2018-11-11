package com.android.eos.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.utils.ConstantUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class NodeSettingActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_node_setting;
    }

    @Override
    public void initView() {
        initTitle();
    }

    private void initTitle() {
        titleTv.setText(R.string.node_setting);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.eth_rl, R.id.bit_rl, R.id.eos_rl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.eth_rl:
                Intent ethIntent = new Intent(this, NodeSettingDetailsActivity.class);
                ethIntent.putExtra(ConstantUtils.TITLE, "ETHEREUM" + getResources().getString(R.string.node_setting));
                startActivity(ethIntent);
                break;
            case R.id.bit_rl:
                Intent bitIntent = new Intent(this, NodeSettingDetailsActivity.class);
                bitIntent.putExtra(ConstantUtils.TITLE, "BITCOIN" + getResources().getString(R.string.node_setting));
                startActivity(bitIntent);
                break;
            case R.id.eos_rl:
                Intent eosIntent = new Intent(this, NodeSettingDetailsActivity.class);
                eosIntent.putExtra(ConstantUtils.TITLE, "EOS" + getResources().getString(R.string.node_setting));
                startActivity(eosIntent);
                break;
        }
    }

}
