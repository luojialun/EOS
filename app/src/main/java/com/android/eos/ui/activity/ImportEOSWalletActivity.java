package com.android.eos.ui.activity;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.utils.ToastUtils;

import org.consenlabs.tokencore.wallet.Wallet;
import org.consenlabs.tokencore.wallet.WalletManager;
import org.consenlabs.tokencore.wallet.model.ChainType;
import org.consenlabs.tokencore.wallet.model.Metadata;
import org.consenlabs.tokencore.wallet.model.Network;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 导入EOS钱包页
 */
public class ImportEOSWalletActivity extends BaseActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tip_ll)
    LinearLayout tipLl;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.private_key_et)
    EditText privateKeyEt;
    @BindView(R.id.password_hint_et)
    EditText passwordHintEt;

    private String privateKey;
    private String password;
    private String passwordHint;


    @Override
    public int setViewId() {
        return R.layout.activity_import_eoswallet;
    }

    @Override
    public void initView() {
        initTitle();
        passwordEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tipLl.setVisibility(View.INVISIBLE);
                return false;
            }
        });

    }

    private void initTitle() {
        titleTv.setText(R.string.import_eos_wallet);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back_iv, R.id.create_btn, R.id.password_et})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.create_btn:
                privateKey = privateKeyEt.getText().toString();
                password = passwordEt.getText().toString();
                passwordHint = passwordHintEt.getText().toString();
                if (TextUtils.isEmpty(privateKey)) {
                    ToastUtils.showToast(R.string.please_enter_private_key);
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    ToastUtils.showToast(R.string.please_enter_password);
                    return;
                }
                importWallet(privateKey, password);
                break;
        }
    }

    public void importWallet(String privateKey, String password) {
        Metadata metadata = new Metadata();
        metadata.setChainType(ChainType.EOS);
        metadata.setNetwork(Network.MAINNET);
        Wallet eosWallet = WalletManager.importWalletFromPrivateKey(metadata, privateKey, password, true);
        String publicKey = eosWallet.exportPrivateKeys(password).get(0).getPublicKey();

    }

}
