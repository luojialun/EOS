package com.android.eos.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.eos.utils.ToastUtils;
import com.android.eos.widget.dialog.ShowDialog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luojialun on 2017/8/29.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unBinder;
    private boolean eventBusState=false;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(setViewId(), null);
        if (bindEventBus()) {
            EventBus.getDefault().register(this);
        }
        unBinder = ButterKnife.bind(this, contentView);
        initView();
        initData();
        return contentView;
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

    public boolean bindEventBus() {
        return eventBusState;
    }

    public void readyGo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    public void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    public void showProgress() {
        ShowDialog.showDialog(getActivity(), "", true, null);
    }

    public void dissmissProgress() {
        ShowDialog.dissmiss();
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
    public void onDestroy() {
        super.onDestroy();
        if (eventBusState) {
            EventBus.getDefault().unregister(this);
        }
        unBinder.unbind();
    }
}
