package com.android.eos.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.android.eos.R;

/**
 * 分享dialog
 */
public class ShareDialog extends Dialog implements View.OnClickListener {

    private Context context;

    public ShareDialog(@NonNull Context context) {
        super(context, R.style.ShareDialog);
        this.context = context;
        setDialogView();
    }

    private void setDialogView() {
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_share, null);
        contentView.findViewById(R.id.close_iv).setOnClickListener(this);
        contentView.findViewById(R.id.wechat_ll).setOnClickListener(this);
        contentView.findViewById(R.id.moment_ll).setOnClickListener(this);
        contentView.findViewById(R.id.sina_ll).setOnClickListener(this);
        contentView.findViewById(R.id.qq_ll).setOnClickListener(this);
        contentView.findViewById(R.id.qzone_ll).setOnClickListener(this);

        setContentView(contentView);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setSize();
    }

    private void setSize() {
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = AbsListView.LayoutParams.MATCH_PARENT;
        lp.y = 0;//设置Dialog距离底部的距离
        dialogWindow.setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.close_iv:
                dismiss();
                break;
            case R.id.wechat_ll:
                dismiss();
                break;
            case R.id.moment_ll:
                dismiss();
                break;
            case R.id.sina_ll:
                dismiss();
                break;
            case R.id.qq_ll:
                dismiss();
                break;
            case R.id.qzone_ll:
                dismiss();
                break;

        }

    }


}
