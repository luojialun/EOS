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
import com.android.eos.data.UserInfo;
import com.android.eos.utils.ToastUtils;
import com.android.eos.widget.dialog.ShowDialog;

import org.bitcoinj.core.ECKey;
import org.consenlabs.tokencore.wallet.Identity;
import org.consenlabs.tokencore.wallet.KeystoreStorage;
import org.consenlabs.tokencore.wallet.Wallet;
import org.consenlabs.tokencore.wallet.WalletManager;
import org.consenlabs.tokencore.wallet.keystore.EOSKeystore;
import org.consenlabs.tokencore.wallet.model.ChainType;
import org.consenlabs.tokencore.wallet.model.KeyPair;
import org.consenlabs.tokencore.wallet.model.Metadata;
import org.consenlabs.tokencore.wallet.model.Network;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 导入EOS钱包页
 */
public class ImportEOSWalletActivity extends BaseActivity implements KeystoreStorage {

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
        WalletManager.storage = this;
        WalletManager.scanWallets();
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
                showProgress();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            importWallet(privateKey, password);
                        }catch (Exception e){
                            ToastUtils.showToast(R.string.import_wallet_error);
                        }
                    }
                }).start();
                break;
        }
    }

    public void importWallet(String privateKey, String password) {
//        Metadata metadata = new Metadata();
//        metadata.setChainType(ChainType.EOS);
//        metadata.setNetwork(Network.MAINNET);
        Identity identity = Identity.createIdentity("user", password, passwordHint, Network.MAINNET, Metadata.FROM_NEW_IDENTITY);
        List<String> chainTypeList = new ArrayList<>();
        chainTypeList.add(ChainType.EOS);
        Wallet eosWallet = identity.deriveWallets(chainTypeList, password).get(0);
//        List<String> prvKeys = new ArrayList<>();
//        prvKeys.add(privateKey);
//        List<EOSKeystore.PermissionObject> permissionObjects = new ArrayList<>();
//        eosWallet = WalletManager.importWalletFromPrivateKeys(metadata, "account", prvKeys, permissionObjects, password, true);
//        String publicKey = eosWallet.getKeyPathPrivates().get(0).getPublicKey();

        Wallet wallet = WalletManager.importWalletFromPrivateKey(new Metadata(ChainType.EOS, Network.MAINNET, "name", passwordHint),"", privateKey, password, true);
        String publicKey = wallet.exportPrivateKeys(password).get(0).getPublicKey();

        UserInfo.setPrivateKey(privateKey);
        UserInfo.setOwnerKey(publicKey);
        UserInfo.setActiverKey(publicKey);
        UserInfo.setPassword(password);
        UserInfo.setPasswordHit(passwordHint);
        UserInfo.setId(wallet.getId());
        ShowDialog.dissmiss();
        MainActivity.readGoMain(ImportEOSWalletActivity.this);
    }

    @Override
    public File getKeystoreDir() {
        return this.getFilesDir();
    }
}
