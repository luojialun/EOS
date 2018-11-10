package com.android.eos.ui.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 导入EOS钱包页
 */
public class ImportEOSWalletActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tip_ll)
    LinearLayout tipLl;
    @BindView(R.id.password_et)
    EditText passwordEt;

    @Override
    public int setViewId() {
        return R.layout.activity_import_eoswallet;
    }

    @Override
    public void initView() {
        initTitle();
        passwordEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tipLl.setVisibility(View.INVISIBLE);
                return false;
            }
        });

    }

    private void initTitle() {
        titleTv.setText(R.string.import_eos_wallet);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.create_btn, R.id.password_et})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.create_btn:
                MainActivity.readGoMain(ImportEOSWalletActivity.this);
                break;
            case R.id.password_et:

                break;
        }
    }

}
