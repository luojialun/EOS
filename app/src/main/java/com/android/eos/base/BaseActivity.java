package com.android.eos.base;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.eos.R;
import com.android.eos.utils.SystemBarHelper;
import com.android.eos.utils.ToastUtils;
import com.android.eos.widget.dialog.ShowDialog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luojialun on 2017/8/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unBinder;
    private boolean eventBusState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemBarHelper.immersiveStatusBar(this, 0);//沉浸式状态栏
        setContentView(setViewId());
        if (eventBusState) {
            EventBus.getDefault().register(this);
        }
        unBinder = ButterKnife.bind(this);
        initView();
        initData();


    }

    public void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    public void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * /**
     * 设置布局
     *
     * @return 布局ID
     */
    public abstract int setViewId();

    public abstract void initView();

    public abstract void initData();

    public void bindEventBus(boolean eventBusState) {
        this.eventBusState = eventBusState;
    }

    public void showProgress() {
        ShowDialog.showDialog(this, "", true, null);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (eventBusState) {
            EventBus.getDefault().unregister(this);
        }
        unBinder.unbind();
    }
}
