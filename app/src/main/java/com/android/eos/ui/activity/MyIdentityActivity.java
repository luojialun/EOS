package com.android.eos.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的身份页面
 */
public class MyIdentityActivity extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_my_identity;
    }

    @Override
    public void initView() {
        initTitle();
    }

    private void initTitle() {
        titleTv.setText(R.string.my_identity);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }
}
