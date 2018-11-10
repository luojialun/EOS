package com.android.eos.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
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
 * 管理dialog
 */
public class ManageDialog extends Dialog implements View.OnClickListener {

    private Context context;

    public ManageDialog(@NonNull Context context) {
        super(context, R.style.ShareDialog);
        this.context = context;
        setDialogView();
    }

    private void setDialogView() {
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_manage, null);
        contentView.findViewById(R.id.root_fl).setOnClickListener(this);
        contentView.findViewById(R.id.close_iv).setOnClickListener(this);
        RecyclerView contentRv = contentView.findViewById(R.id.content_rv);
        contentRv.setLayoutManager(new LinearLayoutManager(context));
        List<ManageBean> dataList = new ArrayList<>();
        dataList.add(new ManageBean(R.mipmap.manage_1, "隐藏无余额资产"));
        dataList.add(new ManageBean(R.mipmap.manage_2, "按余额排序"));
        dataList.add(new ManageBean(R.mipmap.manage_3, "按字母排序"));
        ManageAdapter adapter = new ManageAdapter(dataList);
        contentRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 1:
                        dismiss();
                        break;
                    case 2:
                        dismiss();
                        break;
                    case 3:
                        dismiss();
                        break;
                }
            }
        });


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
            case R.id.root_fl:
                dismiss();
                break;
            case R.id.close_iv:
                dismiss();
                break;

        }

    }


}
