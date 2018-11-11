package com.android.eos.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.net.HttpUtils;
import com.android.eos.utils.LogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;

import org.consenlabs.tokencore.wallet.Identity;
import org.consenlabs.tokencore.wallet.KeystoreStorage;
import org.consenlabs.tokencore.wallet.Wallet;
import org.consenlabs.tokencore.wallet.WalletManager;
import org.consenlabs.tokencore.wallet.model.ChainType;
import org.consenlabs.tokencore.wallet.model.Metadata;
import org.consenlabs.tokencore.wallet.model.Network;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 免费创建
 */
public class CreatedIdentityFreeActivity extends BaseActivity implements KeystoreStorage {

    @BindView(R.id.title_tv)
    TextView titleTv;

    @Override
    public int setViewId() {
        return R.layout.activity_created_identity_free;
    }

    @Override
    public void initView() {
        initTitle();

    }

    private void initTitle() {
        titleTv.setText(R.string.create_free);
    }

    @Override
    public void initData() {
        WalletManager.storage = this;
        WalletManager.scanWallets();

    }

    @OnClick({R.id.back_iv, R.id.create_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.create_btn:
                createAccount("luojialun225","ljl56390225","passwordHit");
                //MainActivity.readGoMain(CreatedIdentityFreeActivity.this);
                break;

        }
    }

    private void createAccount(String name,String password,String passwordHit) {
        Identity identity = Identity.createIdentity(name, password, passwordHit, Network.MAINNET, Metadata.FROM_NEW_IDENTITY);
        List<String> chainTypeList = new ArrayList<>();
        chainTypeList.add(ChainType.EOS);
        Wallet eosWallet = identity.deriveWallets(chainTypeList, password).get(0);
        LogUtils.loge("private key-->" + eosWallet.exportPrivateKeys(password).get(0).getPrivateKey());
        LogUtils.loge("public key-->" + eosWallet.exportPrivateKeys(password).get(0).getPublicKey());

    }


    @Override
    public File getKeystoreDir() {
        return this.getFilesDir();
    }
}
