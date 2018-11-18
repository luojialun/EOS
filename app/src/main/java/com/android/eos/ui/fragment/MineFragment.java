package com.android.eos.ui.fragment;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseFragment;
import com.android.eos.data.UserInfo;
import com.android.eos.ui.activity.AboutUsActivity;
import com.android.eos.ui.activity.CollectionCodeActivity;
import com.android.eos.ui.activity.CreateIdentityActivity;
import com.android.eos.ui.activity.HelpAndFeedbackActivity;
import com.android.eos.ui.activity.MyIdentityActivity;
import com.android.eos.ui.activity.MyRecommandActivity;
import com.android.eos.ui.activity.UseSettingActivity;
import com.android.eos.ui.activity.UserAgreementActivity;
import com.android.eos.utils.ConstantUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的页面
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.address_tv)
    TextView addressTv;

    @Override
    public int setViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        nameTv.setText(UserInfo.getAccount());
        addressTv.setText(UserInfo.getAccount());
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.collectionCode_ll, R.id.use_setting_rl, R.id.avatar_iv, R.id.help_feedback_rl, R.id.user_agreement_rl, R.id.about_us_rl, R.id.my_recommand_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.collectionCode_ll:
                startActivity(new Intent(getActivity(), CollectionCodeActivity.class).putExtra(ConstantUtils.ACCOUNT, UserInfo.getAccount()));
                break;
            case R.id.use_setting_rl:
                readyGo(UseSettingActivity.class);
                break;
            case R.id.avatar_iv:
                if (TextUtils.isEmpty(UserInfo.getName())) {
                    readyGo(CreateIdentityActivity.class);
                } else {
                    readyGo(MyIdentityActivity.class);
                }
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
