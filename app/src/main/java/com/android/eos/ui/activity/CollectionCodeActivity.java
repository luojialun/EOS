package com.android.eos.ui.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.data.UserInfo;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.ToastUtils;
import com.android.eos.widget.dialog.ShareDialog;
import com.mylhyl.zxing.scanner.encode.QREncode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收款码页
 */
public class CollectionCodeActivity extends BaseActivity {

    @BindView(R.id.address_tv)
    TextView addressTv;
    @BindView(R.id.code_iv)
    ImageView codeIv;

    private String account = "";

    @Override
    public int setViewId() {
        return R.layout.activity_collection_code;
    }

    @Override
    public void initView() {
        initParams();
    }

    @Override
    public void initData() {

    }

    private void initParams() {
        account = getIntent().getStringExtra(ConstantUtils.ACCOUNT);
        if (!TextUtils.isEmpty(account)) {
            addressTv.setText(account);
            //文本类型
            Bitmap bitmap = new QREncode.Builder(this)
                    .setColor(getResources().getColor(R.color.black))//二维码颜色
                    //.setParsedResultType(ParsedResultType.TEXT)//默认是TEXT类型
                    .setContents(account)//二维码内容
//                .setLogoBitmap(logoBitmap)//二维码中间logo
                    .build().encodeAsBitmap();
            codeIv.setImageBitmap(bitmap);
        }
    }

    @OnClick({R.id.back_iv, R.id.share_iv, R.id.copy_fl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.share_iv:
                ShareDialog shareDialog = new ShareDialog(this);
                shareDialog.show();
                break;
            case R.id.copy_fl:
                copy();
                break;
        }
    }

    public void copy() {
        // 从API11开始android推荐使用android.content.ClipboardManager
        // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        // 将文本内容放到系统剪贴板里。
        cm.setText(account);
        ToastUtils.showToast(R.string.copy_success);
    }
}
