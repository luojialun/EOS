package com.android.eos.ui.fragment;


import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.activity.CollectionCodeActivity;

import butterknife.OnClick;

/**
 * 我的页面
 */
public class MineFragment extends BaseFragment {

    @Override
    public int setViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.collectionCode_ll})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.collectionCode_ll:
                readyGo(CollectionCodeActivity.class);
                break;
        }
    }
}
