package com.android.eos.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.android.eos.ui.service.DownLoadServerice;
import com.android.eos.widget.dialog.updatadialog.UpdataCallback;
import com.android.eos.widget.dialog.updatadialog.UpdataDialog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


/**
 * Created by pocketEos on 2018/2/10.
 */

public class UpdateUtils {
    /**
     * 获取apk的版本号 currentVersionCode
     *
     * @param ctx
     * @return
     */
    public static int getAPPLocalVersion(Context ctx) {
        int currentVersionCode = 0;
        PackageManager manager = ctx.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
            String appVersionName = info.versionName; // 版本名
            currentVersionCode = info.versionCode; // 版本号
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return currentVersionCode;
    }


    /**
     * 更新APP
     *
     * @param context
     */
    public static void updateApp(final Context context, String versionUrl, String versionName) {

        UpdataDialog dialog = new UpdataDialog(context, versionName, new UpdataCallback() {
            @Override
            public void goData() {
                Intent intent = new Intent(context, DownLoadServerice.class);
                intent.putExtra("url", versionUrl);
                intent.putExtra("versionName", versionName);
                context.startService(intent);
            }

        });
//        dialog.setContent(versionDetail);
        dialog.setCancelable(false);
        dialog.show();

    }

    /**
     * Parse string to bean object.
     *
     * @param str   the str
     * @param clazz the clazz
     * @return the object
     */
    public static Object parseStringToBean(String str, Class clazz) {
        Object object = null;
        try {
            Gson gson = new Gson();
            object = gson.fromJson(str, clazz);
        } catch (JsonSyntaxException e) {
            ToastUtils.showToast("data parse error");
        }
        return object;
    }

    public interface VersionCallBack {
        void callBack(int versionCode, String apkurl, String versionName, String versionDetail);
    }
}
