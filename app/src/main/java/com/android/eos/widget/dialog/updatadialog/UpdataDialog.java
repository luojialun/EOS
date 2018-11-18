package com.android.eos.widget.dialog.updatadialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.utils.AppUtils;
import com.android.eos.utils.ScreenUtils;


/**
 * 版本更新弹窗
 */

public class UpdataDialog extends Dialog implements View.OnClickListener {

    UpdataCallback callback;
    private TextView sureBtn;
    private TextView cancleBtn;
    private String versionName;
    private Context context;
    private TextView versionNameTv;

    public UpdataDialog(Context context, String versionName, UpdataCallback callback) {
        super(context, R.style.ServiceDialog);
        this.callback = callback;
        this.context = context;
        this.versionName = versionName;
        setCustomDialog();
    }

    private void setCustomDialog() {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_updata_app, null);
        sureBtn = mView.findViewById(R.id.dialog_confirm_sure);
        cancleBtn = mView.findViewById(R.id.dialog_confirm_cancle);
        versionNameTv = mView.findViewById(R.id.version_name_tv);
        versionNameTv.setText(AppUtils.getAppName() + " " + versionName);
        sureBtn.setOnClickListener(this);
        cancleBtn.setOnClickListener(this);
        super.setContentView(mView);
        setSize();
    }

    private void setSize() {
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenUtils.getScreenWidth() * 0.78);
        lp.y = 0;//设置Dialog距离底部的距离
        dialogWindow.setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_confirm_cancle:
                this.cancel();
                break;

            case R.id.dialog_confirm_sure:
                callback.goData();
                this.cancel();
                break;
        }
    }

}
