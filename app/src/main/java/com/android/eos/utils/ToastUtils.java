package com.android.eos.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.eos.R;
import com.android.eos.base.BaseApp;

public class ToastUtils {
    private static Toast toast = null; //Toast的对象！

    public static void showToast(Context mContext, String content) {
        if (toast == null) {
            toast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    public static void showToast(String content) {
        if (null != BaseApp.getContext()) {
            Toast.makeText(BaseApp.getContext(), content, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showToast(int contentId) {
        if (null != BaseApp.getContext()) {
            Toast.makeText(BaseApp.getContext(), BaseApp.getContext().getResources().getString(contentId), Toast.LENGTH_SHORT).show();
        }
    }

  /*  public static void showViewToast(Context context, String content) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_view, null);
        TextView contentTv = (TextView) view.findViewById(R.id.content_tv);
        contentTv.setText(content);
        toast.setView(view);
        toast.show();
    }*/
}
