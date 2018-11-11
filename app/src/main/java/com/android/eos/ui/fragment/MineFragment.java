package com.android.eos.ui.fragment;


import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.ui.activity.AboutUsActivity;
import com.android.eos.ui.activity.CollectionCodeActivity;
import com.android.eos.ui.activity.CreateIdentityActivity;
import com.android.eos.ui.activity.HelpAndFeedbackActivity;
import com.android.eos.ui.activity.MyRecommandActivity;
import com.android.eos.ui.activity.UseSettingActivity;
import com.android.eos.ui.activity.UserAgreementActivity;

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


    @OnClick({R.id.collectionCode_ll, R.id.use_setting_rl, R.id.avatar_iv, R.id.help_feedback_rl, R.id.user_agreement_rl, R.id.about_us_rl, R.id.my_recommand_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.collectionCode_ll:
                readyGo(CollectionCodeActivity.class);
                break;
            case R.id.use_setting_rl:
                readyGo(UseSettingActivity.class);
                break;
            case R.id.avatar_iv:
                readyGo(CreateIdentityActivity.class);
                break;
            case R.id.help_feedback_rl:
                readyGo(HelpAndFeedbackActivity.class);
                break;
            case R.id.user_agreement_rl:
                readyGo(UserAgreementActivity.class);
                break;
            case R.id.about_us_rl:
                readyGo(AboutUsActivity.class);
                break;
            case R.id.my_recommand_btn:
                readyGo(MyRecommandActivity.class);
                break;
        }
    }
}
