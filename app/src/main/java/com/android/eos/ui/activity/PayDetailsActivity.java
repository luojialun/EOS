package com.android.eos.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 支付详情页面
 */
public class PayDetailsActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_pay_details;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.pay_details);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.next_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.next_btn:
                readyGo(EnterPasswordActivity.class);
                break;
        }
    }
}
