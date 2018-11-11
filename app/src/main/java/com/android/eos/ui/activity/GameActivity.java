package com.android.eos.ui.activity;

import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.widget.dialog.TransferDialog;

import butterknife.OnClick;

public class GameActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_game;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.enter_game_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.enter_game_btn:
                TransferDialog transferDialog = new TransferDialog(this);
                transferDialog.show();
                break;
        }
    }
}
