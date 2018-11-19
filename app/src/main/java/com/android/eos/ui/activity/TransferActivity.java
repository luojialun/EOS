package com.android.eos.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.data.TempData;
import com.android.eos.utils.MyTextWatcher;
import com.android.eos.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 转账页面
 */
public class TransferActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.right_iv)
    ImageView rightIv;
    @BindView(R.id.balance_tv)
    TextView balanceTv;
    @BindView(R.id.count_et)
    EditText countEt;

    private float balance;

    @Override
    public int setViewId() {
        return R.layout.activity_transfer;
    }

    @Override
    public void initView() {
        initTitle();

        countEt.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0 && Float.parseFloat(s.toString()) > balance) {
                    ToastUtils.showToast(R.string.over_balance);
                }
            }
        });

    }

    private void initTitle() {
        titleTv.setText(R.string.transfer_1);
        rightIv.setImageResource(R.mipmap.property_1);
    }

    @Override
    public void initData() {
        if (null != TempData.getAccountResponse()) {
            balanceTv.setText(TempData.getAccountResponse().getCore_liquid_balance());
            String[] balances = TempData.getAccountResponse().getCore_liquid_balance().split(" ");
            if (balances.length > 0) {
                try {
                    balance = Float.parseFloat(balances[0]);
                } catch (Exception e) {
                    balance = 0;
                }
            }
        }
    }

    @OnClick({R.id.back_iv, R.id.next_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.next_btn:
                readyGo(PayDetailsActivity.class);
                break;
        }
    }
}
