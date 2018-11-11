package com.android.eos.utils;

import android.util.Log;

import com.android.eos.BuildConfig;

public class LogUtils {

    public static void loge(String msg) {
        if (BuildConfig.LOG_DEBUG) {
            Log.e("TAG", msg);
        }
    }
}
