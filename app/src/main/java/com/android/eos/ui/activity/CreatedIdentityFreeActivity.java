package com.android.eos.ui.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.LogUtils;
import com.android.eos.utils.RegexUtil;
import com.android.eos.utils.ToastUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 免费创建
 */
public class CreatedIdentityFreeActivity extends BaseActivity implements KeystoreStorage {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.ownerkey_et)
    EditText ownerKeyEt;
    @BindView(R.id.activerkey_et)
    EditText activerKeyet;
    @BindView(R.id.account_et)
    EditText accountEt;

    private String password;
    private String passwordHint;

    @Override
    public int setViewId() {
        return R.layout.activity_created_identity_free;
    }

    @Override
    public void initView() {
        initParam();
        initTitle();

    }

    private void initParam() {
        password = getIntent().getStringExtra(ConstantUtils.PASSWORD);
        passwordHint = getIntent().getStringExtra(ConstantUtils.PASSWORD_HINT);
    }

    private void initTitle() {
        titleTv.setText(R.string.create_free);
    }

    @Override
    public void initData() {
        WalletManager.storage = this;
        WalletManager.scanWallets();

        createWallet(password, passwordHint);

    }

    @OnClick({R.id.back_iv, R.id.create_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.create_btn:
                if (TextUtils.isEmpty(accountEt.getText().toString())) {
                    ToastUtils.showToast(getResources().getString(R.string.please_enter_account));
                    return;
                }
                if (TextUtils.isEmpty(ownerKeyEt.getText().toString())) {
                    ToastUtils.showToast(getResources().getString(R.string.please_enter_ownerkey));
                    return;
                }
                if (TextUtils.isEmpty(activerKeyet.getText().toString())) {
                    ToastUtils.showToast(getResources().getString(R.string.please_enter_activerkey));
                    return;
                }
                if (RegexUtil.isEosName(accountEt.getText().toString())) {
                    createEOS();
                }
                break;
        }
    }

    private void createWallet(String password, String passwordHint) {
        Identity identity = Identity.createIdentity("user", password, passwordHint, Network.MAINNET, Metadata.FROM_NEW_IDENTITY);
        List<String> chainTypeList = new ArrayList<>();
        chainTypeList.add(ChainType.EOS);
        Wallet eosWallet = identity.deriveWallets(chainTypeList, password).get(0);
        LogUtils.loge("private key-->" + eosWallet.exportPrivateKeys(password).get(0).getPrivateKey());
        LogUtils.loge("public key-->" + eosWallet.exportPrivateKeys(password).get(0).getPublicKey());
        ownerKeyEt.setText(eosWallet.exportPrivateKeys(password).get(0).getPublicKey());
        activerKeyet.setText(eosWallet.exportPrivateKeys(password).get(0).getPublicKey());
    }

    private void createEOS() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("account", accountEt.getText().toString());
        paramsMap.put("owner", ownerKeyEt.getText().toString());
        paramsMap.put("active", activerKeyet.getText().toString());
        HttpUtils.getRequets(UrlHelper.createEOS, this, paramsMap, new JsonCallback<String>() {

            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                LogUtils.loge(response.body().toString());
                readyGo(MainActivity.class);
            }
        });

    }


    @Override
    public File getKeystoreDir() {
        return this.getFilesDir();
    }
}
