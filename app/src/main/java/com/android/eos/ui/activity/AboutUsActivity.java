package com.android.eos.ui.activity;

import android.content.Intent;
import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.UpdateResponse;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.utils.AppUtils;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.ToastUtils;
import com.android.eos.utils.UpdateUtils;
import com.lzy.okgo.model.Response;

import butterknife.OnClick;

/**
 * 关于我们
 */
public class AboutUsActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.back_iv, R.id.uplog_ll, R.id.version_ll})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.uplog_ll:
                startActivity(new Intent(this, H5Activity.class).putExtra(ConstantUtils.H5_TYPE, ConstantUtils.UP_LOG));
                break;
            case R.id.version_ll:
                getVersion();
                break;
        }
    }

    private void getVersion() {
        showProgress();
        HttpUtils.getRequets(UrlHelper.version, this, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                dismissProgress();
                UpdateResponse updateResponse = (UpdateResponse) parseStringToBean(response.body().toString(), UpdateResponse.class);
                if (null != updateResponse && !AppUtils.getAppVersionName().equals(updateResponse.getVersion())) {
                    UpdateUtils.updateApp(AboutUsActivity.this, updateResponse.getApk(), updateResponse.getVersion());
                } else {
                    ToastUtils.showToast(R.string.the_newest_version);
                }
            }
        });
    }
}
