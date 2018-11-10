package com.android.eos.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class TransferActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.right_iv)
    ImageView rightIv;

    @Override
    public int setViewId() {
        return R.layout.activity_transfer;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.transfer_1);
        rightIv.setImageResource(R.mipmap.property_1);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.next_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.next_btn:

                break;
        }
    }
}
