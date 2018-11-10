package com.android.eos.ui.activity;

import android.view.View;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.widget.dialog.ShareDialog;

import butterknife.OnClick;

/**
 * 收款码页
 */
public class CollectionCodeActivity extends BaseActivity {

    @Override
    public int setViewId() {
        return R.layout.activity_collection_code;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.share_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.share_iv:
                ShareDialog shareDialog = new ShareDialog(this);
                shareDialog.show();
                break;
        }
    }
}
