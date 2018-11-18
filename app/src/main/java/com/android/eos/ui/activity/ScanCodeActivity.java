package com.android.eos.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.QrCodeAccountBean;
import com.android.eos.bean.QrCodeAccountPrivateKeyBean;
import com.android.eos.bean.QrCodeMakeCollectionBean;
import com.android.eos.bean.QrCodeWalletBean;
import com.android.eos.utils.FilesUtils;
import com.android.eos.widget.dialog.ShowDialog;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;
import com.mylhyl.zxing.scanner.decode.QRDecode;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 扫一扫
 */
public class ScanCodeActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.scanner_view)
    ScannerView mScannerView;

    private static final int CHOOSE_PICTURE = 0;

    @Override
    public int setViewId() {
        return R.layout.activity_scan_code;
    }

    @Override
    public void initView() {
        initTitle();
        mScannerView.setMediaResId(R.raw.beep);//设置扫描成功的声音
        mScannerView.setLaserFrameBoundColor(getResources().getColor(R.color.theme_color));
        mScannerView.setLaserColor(getResources().getColor(R.color.theme_color));
    }

    private void initTitle() {
        titleTv.setText(R.string.scan);
    }

    @Override
    public void initData() {
        mScannerView.setOnScannerCompletionListener(new OnScannerCompletionListener() {
            @Override
            public void onScannerCompletion(Result result, ParsedResult parsedResult, Bitmap bitmap) {
                pareCode(parsedResult.toString());
            }

        });
    }

    @Override
    protected void onResume() {
        mScannerView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mScannerView.onPause();
        super.onPause();
    }

    public void pareCode(String data) {
        Bundle bundle = new Bundle();
        //钱包二维码包含:wallet_name:test2&wallet_uid:456
        if (data.toString().contains("wallet_QRCode")) {
            QrCodeWalletBean walletCodeBean = (QrCodeWalletBean) parseStringToBean(data.toString(), QrCodeWalletBean.class);
            bundle.putString("name", walletCodeBean.getWallet_name());
            bundle.putString("friend_type", "1");//属于钱包级别
            bundle.putString("avatar", walletCodeBean.getWallet_img());
            bundle.putString("uid", walletCodeBean.getWallet_uid());
            bundle.putString("from", "code");
            //ActivityUtils.next(ScanCodeActivity.this, FriendsDetailsActivity.class, bundle, true);
        } else if (data.toString().contains("account_QRCode")) {
            QrCodeAccountBean qrCodeAccountBean = (QrCodeAccountBean) parseStringToBean(data.toString(), QrCodeAccountBean.class);
            bundle.putString("name", qrCodeAccountBean.getAccount_name());
            bundle.putString("friend_type", "2");//属于账号级别
            bundle.putString("avatar", qrCodeAccountBean.getAccount_img());
            bundle.putString("uid", "");
            bundle.putString("from", "code");
            //ActivityUtils.next(ScanCodeActivity.this, FriendsDetailsActivity.class, bundle, true);
        } else if (data.toString().contains("account_priviate_key_QRCode")) {
            if (!getIntent().getStringExtra("from").equals("home")) {
                QrCodeAccountPrivateKeyBean qrCodeAccountPrivateKeyBean = (QrCodeAccountPrivateKeyBean) parseStringToBean(data.toString(), QrCodeAccountPrivateKeyBean.class);
                bundle.putString("account_name", qrCodeAccountPrivateKeyBean.getAccount_name());
                bundle.putString("owner_private_key", qrCodeAccountPrivateKeyBean.getOwner_private_key());
                bundle.putString("active_private_key", qrCodeAccountPrivateKeyBean.getActive_private_key());
                //ActivityUtils.goBackWithResult(ScanCodeActivity.this, 200, bundle);
            } else {
                QrCodeAccountPrivateKeyBean qrCodeAccountPrivateKeyBean = (QrCodeAccountPrivateKeyBean) parseStringToBean(data.toString(), QrCodeAccountPrivateKeyBean.class);
                bundle.putString("account_name", qrCodeAccountPrivateKeyBean.getAccount_name());
                bundle.putString("owner_private_key", qrCodeAccountPrivateKeyBean.getOwner_private_key());
                bundle.putString("active_private_key", qrCodeAccountPrivateKeyBean.getActive_private_key());
                //ActivityUtils.next(ScanCodeActivity.this, ImportAccountActivity.class, bundle, true);
            }
        } else if (data.toString().contains("make_collections_QRCode")) {
            if (!getIntent().getStringExtra("from").equals("home")) {
                QrCodeMakeCollectionBean qrCodeMakeCollectionBean = (QrCodeMakeCollectionBean)parseStringToBean(data.toString(), QrCodeMakeCollectionBean.class);
                bundle.putString("account", qrCodeMakeCollectionBean.getAccount_name());
                bundle.putString("money", qrCodeMakeCollectionBean.getMoney());
                bundle.putString("coin", qrCodeMakeCollectionBean.getCoin());
                //ActivityUtils.goBackWithResult(ScanCodeActivity.this, 300, bundle);
            } else {
                QrCodeMakeCollectionBean qrCodeMakeCollectionBean = (QrCodeMakeCollectionBean) parseStringToBean(data.toString(), QrCodeMakeCollectionBean.class);
               // bundle.putString("account", MyApplication.getInstance().getUserBean().getWallet_main_account());
                bundle.putString("coin", "EOS");
                bundle.putParcelable("info", qrCodeMakeCollectionBean);
                bundle.putString("from", "qrcode");
                //ActivityUtils.next(ScanCodeActivity.this, TransferAccountsActivity.class, bundle, true);
            }
        } else {
            //ToastUtils.showToast(R.string.scan_code_notice);
        }
    }

    @OnClick({R.id.back_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ScanCodeActivity.RESULT_OK && requestCode == CHOOSE_PICTURE) {
            //获取uri拿bitmap要做压缩处理，防止oom
            ShowDialog.showDialog(this, "识别中...", true, null);
            Uri originalUri = null;
            File file = null;
            if (null != data) {
                originalUri = data.getData();
                file = FilesUtils.getFileFromMediaUri(ScanCodeActivity.this, originalUri);
            }
            Bitmap photoBmp = null;
            try {
                photoBmp = FilesUtils.getBitmapFormUri(ScanCodeActivity.this, Uri.fromFile(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int degree = FilesUtils.getBitmapDegree(file.getAbsolutePath());
            //把图片旋转为正的方向
            Bitmap newbitmap = FilesUtils.rotateBitmapByDegree(photoBmp, degree);
            QRDecode.decodeQR(newbitmap, new OnScannerCompletionListener() {
                @Override
                public void onScannerCompletion(Result result, ParsedResult parsedResult, Bitmap bitmap) {
                    ShowDialog.dissmiss();
                    if (parsedResult != null) {
                        pareCode(parsedResult.toString());

                    } else {
                        //toast(getString(R.string.scanner_error_toast));
                    }
                }
            });
        }
    }
}
