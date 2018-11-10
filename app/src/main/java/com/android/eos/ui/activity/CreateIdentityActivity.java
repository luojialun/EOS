package com.android.eos.ui.activity;

import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.widget.dialog.ServiceDialog;

import butterknife.OnClick;

/**
 * 创建身份页
 */
public class CreateIdentityActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_create_identity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.create_id_free_btn, R.id.created_id_pay_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_id_free_btn:  //免费创建
                ServiceDialog serviceDialog = new ServiceDialog(this, new ServiceDialog.OnNextListener() {
                    @Override
                    public void next() {
                        readyGo(CreatedIdentityFreeActivity.class);
                    }
                });
                serviceDialog.show();
                break;
            case R.id.created_id_pay_btn:  //付费创建
                ServiceDialog serviceDialog1 = new ServiceDialog(this, new ServiceDialog.OnNextListener() {
                    @Override
                    public void next() {
                        readyGo(CreatedIdentityPayActivity.class);
                    }
                });
                serviceDialog1.show();
                break;
        }
    }
}
