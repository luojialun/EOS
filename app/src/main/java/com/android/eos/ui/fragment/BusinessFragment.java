package com.android.eos.ui.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;

import butterknife.BindView;

/**
 * 交易压面
 */
public class BusinessFragment extends BaseFragment {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.back_iv)
    ImageView backIv;

    @Override
    public int setViewId() {
        return R.layout.fragment_business;
    }

    @Override
    public void initView() {
        initTitle();
    }

    private void initTitle() {
        titleTv.setText(R.string.business);
        backIv.setVisibility(View.GONE);
    }

    @Override
    public void initData() {

    }


}
