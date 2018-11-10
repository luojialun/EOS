package com.android.eos.ui.activity;

import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.OnClick;

/**
 * 钱包信息页面
 */
public class WalletMessageActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_wallet_message;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.resource_rl, R.id.checkout_key_rl, R.id.delete_wallet_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.resource_rl:
                readyGo(ResourceManageActivity.class);
                break;
            case R.id.checkout_key_rl:
                readyGo(CheckoutPrivateKeyActivity.class);
                break;
            case R.id.delete_wallet_btn:
                finish();
                break;
        }
    }
}
