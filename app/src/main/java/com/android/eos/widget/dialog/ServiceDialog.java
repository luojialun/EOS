package com.android.eos.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.android.eos.R;

/**
 * 服务条款dialog
 */
public class ServiceDialog extends Dialog implements View.OnClickListener {

    private Context context;

    private ImageView agreeIv;
    private FrameLayout nextFl;
    private OnNextListener onNextListener;

    public ServiceDialog(@NonNull Context context, OnNextListener onNextListener) {
        super(context, R.style.ServiceDialog);
        this.context = context;
        this.onNextListener = onNextListener;
        setDialogView();
    }

    private void setDialogView() {
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_service, null);
        contentView.findViewById(R.id.close_iv).setOnClickListener(this);
        contentView.findViewById(R.id.agree_ll).setOnClickListener(this);
        agreeIv = contentView.findViewById(R.id.agree_iv);
        agreeIv.setSelected(true);
        nextFl = contentView.findViewById(R.id.next_fl);
        nextFl.setOnClickListener(this);

        setContentView(contentView);
        setSize();
    }

    private void setSize() {
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = display.getWidth(); //设置宽度
        lp.height = display.getHeight(); //设置宽度
        this.getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_iv:
                dismiss();
                break;
            case R.id.agree_ll:
                agreeIv.setSelected(!agreeIv.isSelected());
                if (agreeIv.isSelected()) {
                    nextFl.setBackgroundResource(R.drawable.rectangle_bottom10_green);
                } else {
                    nextFl.setBackgroundResource(R.drawable.rectangle_bottom10_green);
                }
                break;
            case R.id.next_fl:
                if (agreeIv.isSelected()) {
                    onNextListener.next();
                }
                dismiss();
                break;
        }

    }

    public interface OnNextListener {
        void next();
    }
}
