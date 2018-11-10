package com.android.eos.ui.activity;

import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;

/**
 * 导出私钥
 */
public class CheckoutPrivateKeyActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_checkout_private_key;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.wallet_message_2);
    }

    @Override
    public void initData() {

    }
}
