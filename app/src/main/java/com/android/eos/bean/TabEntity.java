package com.android.eos.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by luojialun on 2018/11/4.
 */

public class TabEntity implements CustomTabEntity {
    private int selectedIcon;
    private int unSelectedIcon;
    public String title;

    public TabEntity(int selectedIcon, int unSelectedIcon, String title) {
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
