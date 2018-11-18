package com.android.eos.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.eos.MainActivity;
import com.android.eos.R;
import com.android.eos.base.BaseActivity;
import com.android.eos.bean.CreateEOSResponse;
import com.android.eos.data.UserInfo;
import com.android.eos.net.HttpUtils;
import com.android.eos.net.UrlHelper;
import com.android.eos.net.callbck.JsonCallback;
import com.android.eos.utils.ConstantUtils;
import com.android.eos.utils.LogUtils;
import com.android.eos.utils.ToastUtils;
import com.android.eos.widget.dialog.ShowDialog;
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
 * 付费创建
 */
public class CreatedIdentityPayActivity extends BaseActivity implements KeystoreStorage {

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
    private Wallet eosWallet;
    private String ownerKey;
    private String activerKey;
    private String privateKey;


    @Override
    public int setViewId() {
        return R.layout.activity_created_identity_pay;
    }

    @Override
    public void initView() {
        initParams();
        initTitle();

    }

    private void initParams() {
        password = getIntent().getStringExtra(ConstantUtils.PASSWORD);
        passwordHint = getIntent().getStringExtra(ConstantUtils.PASSWORD_HINT);

    }

    private void initTitle() {
        titleTv.setText(R.string.create_pay_2);
    }

    @Override
    public void initData() {
        WalletManager.storage = this;
        WalletManager.scanWallets();

        showProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                createWallet(password, passwordHint);
            }
        }).start();
    }

    /**
     * 创建钱包
     *
     * @param password
     * @param passwordHint
     */
    private void createWallet(String password, String passwordHint) {
        Identity identity = Identity.createIdentity("user", password, passwordHint, Network.MAINNET, Metadata.FROM_NEW_IDENTITY);
        List<String> chainTypeList = new ArrayList<>();
        chainTypeList.add(ChainType.EOS);
        eosWallet = identity.deriveWallets(chainTypeList, password).get(0);
        ownerKey = eosWallet.exportPrivateKeys(password).get(0).getPublicKey();
        activerKey = eosWallet.exportPrivateKeys(password).get(0).getPublicKey();
        privateKey = eosWallet.exportPrivateKey(password);
        LogUtils.loge("owner key-->" + ownerKey);
        LogUtils.loge("acitver key-->" + activerKey);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ShowDialog.dissmiss();
                ownerKeyEt.setText(ownerKey);
                activerKeyet.setText(activerKey);
            }
        });

    }

    @OnClick({R.id.back_iv, R.id.collection_code_ll, R.id.create_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.collection_code_ll:
                if (!TextUtils.isEmpty(accountEt.getText().toString())) {
                    startActivity(new Intent(this, CollectionCodeActivity.class).putExtra(ConstantUtils.ACCOUNT, accountEt.getText().toString()));
                } else {
                    ToastUtils.showToast(R.string.please_enter_account);
                }
                break;
            case R.id.create_btn:
                createEOS();
                break;
        }
    }

    /**
     * 创建EOS账号
     */
    private void createEOS() {
        showProgress();
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("account", accountEt.getText().toString());
        paramsMap.put("owner", ownerKeyEt.getText().toString());
        paramsMap.put("active", activerKeyet.getText().toString());
        HttpUtils.getRequets(UrlHelper.createEOS, this, paramsMap, new JsonCallback<String>() {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                dismissProgress();
                CreateEOSResponse createEOSResponse = (CreateEOSResponse) parseStringToBean(response.body().toString(), CreateEOSResponse.class);
                if (createEOSResponse.isRet()) {
                    UserInfo.setTid(createEOSResponse.getTid());
                    UserInfo.setAccount(accountEt.getText().toString());
                    UserInfo.setOwnerKey(ownerKey);
                    UserInfo.setActiverKey(activerKey);
                    UserInfo.setId(eosWallet.getId());
                    UserInfo.setAddress(eosWallet.getAddress());
                    UserInfo.setPassword(password);
                    UserInfo.setPasswordHit(passwordHint);
                    UserInfo.setPrivateKey(privateKey);
                    MainActivity.readGoMain(CreatedIdentityPayActivity.this);
                } else {
                    ToastUtils.showToast(getResources().getString(R.string.create_error));
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtils.showToast(getResources().getString(R.string.create_error));
            }
        });

    }


    @Override
    public File getKeystoreDir() {
        return getFilesDir();
    }
}
