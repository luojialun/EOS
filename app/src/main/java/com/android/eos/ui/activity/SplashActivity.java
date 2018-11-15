package com.android.eos.ui.activity;

import android.text.TextUtils;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.data.UserInfo;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        TimerTask task = new TimerTask() {
            public void run() {
                if (TextUtils.isEmpty(UserInfo.getId())) {
                    readyGoThenKill(WelcomeActivity.class);
                } else {
                    readyGoThenKill(MainActivity.class);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);

    }
}
