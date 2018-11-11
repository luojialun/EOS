package com.android.eos.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;

import com.android.eos.R;
import com.android.eos.bean.ManageBean;
import com.android.eos.ui.adapter.ManageAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 转账dialog
 */
public class TransferDialog extends Dialog implements View.OnClickListener {

    private Context context;

    public TransferDialog(@NonNull Context context) {
        super(context, R.style.ShareDialog);
        this.context = context;
        setDialogView();
    }

    private void setDialogView() {
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_transfer, null);
        contentView.findViewById(R.id.close_iv).setOnClickListener(this);
        contentView.findViewById(R.id.confirm_btn).setOnClickListener(this);

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
            case R.id.confirm_btn:
                dismiss();
                break;

        }

    }


}
