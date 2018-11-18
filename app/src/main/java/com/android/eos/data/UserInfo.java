package com.android.eos.data;

import com.android.eos.utils.SPUtils;

/**
 * 用户个人信息类
 */

public class UserInfo {

    private final static String ID = "id";

    private final static String ADDRESS = "address";

    public final static String OWNER_KEY = "owner_key";

    public final static String ACTIVER_KEY = "activer_key";

    public final static String TID = "tid";

    public final static String PASSWORD = "password";

    public final static String PASSWORD_HIT = "password_hit";

    public final static String ACCOUNT = "account";

    public final static String PRIVATE_KEY = "privateKey";

    public final static String NAME = "name";

    public final static String PASS = "pass";

    public final static String PASS_HINT = "pass_hint";

    public final static String IDCARD = "idcard";

    public final static String IDNAME = "idname";

    public final static String TOKEN = "token";

    public final static String EMAIL = "email";

    public static void setPassHint(String passHint) {
        SPUtils.getInstance().put(PASS_HINT, passHint);
    }

    public static String getPassHint() {
        return SPUtils.getInstance().getString(PASS_HINT);
    }

    public static void setEmail(String email) {
        SPUtils.getInstance().put(EMAIL, email);
    }

    public static String getEmail() {
        return SPUtils.getInstance().getString(EMAIL);
    }

    public static void setToken(String token) {
        SPUtils.getInstance().put(TOKEN, token);
    }

    public static String getToken() {
        return SPUtils.getInstance().getString(TOKEN);
    }

    public static void setIdname(String idname) {
        SPUtils.getInstance().put(IDNAME, idname);
    }

    public static String getIdname() {
        return SPUtils.getInstance().getString(IDNAME);
    }

    public static void setIdcard(String idcard) {
        SPUtils.getInstance().put(IDCARD, idcard);
    }

    public static String getIdcard() {
        return SPUtils.getInstance().getString(IDCARD);
    }

    public static void setPass(String pass) {
        SPUtils.getInstance().put(PASS, pass);
    }

    public static String getPass() {
        return SPUtils.getInstance().getString(PASS);
    }

    public static void setName(String name) {
        SPUtils.getInstance().put(NAME, name);
    }

    public static String getName() {
        return SPUtils.getInstance().getString(NAME);
    }

    public static void setPrivateKey(String privateKey) {
        SPUtils.getInstance().put(PRIVATE_KEY, privateKey);
    }

    public static String getPrivateKey() {
        return SPUtils.getInstance().getString(PRIVATE_KEY);
    }

    public static void setAccount(String account) {
        SPUtils.getInstance().put(ACCOUNT, account);
    }

    public static String getAccount() {
        return SPUtils.getInstance().getString(ACCOUNT);
    }

    public static void setPassword(String password) {
        SPUtils.getInstance().put(PASSWORD, password);
    }

    public static String getPassword() {
        return SPUtils.getInstance().getString(PASSWORD);
    }

    public static void setPasswordHit(String passwordHit) {
        SPUtils.getInstance().put(PASSWORD_HIT, passwordHit);
    }

    public static String getPasswordHit() {
        return SPUtils.getInstance().getString(PASSWORD_HIT);
    }

    public static void setTid(String tid) {
        SPUtils.getInstance().put(TID, tid);
    }

    public static String getTid() {
        return SPUtils.getInstance().getString(TID);
    }

    public static void setId(String id) {
        SPUtils.getInstance().put(ID, id);
    }

    public static String getId() {
        return SPUtils.getInstance().getString(ID);
    }

    public static void setAddress(String address) {
        SPUtils.getInstance().put(ADDRESS, address);
    }

    public static String getAddress() {
        return SPUtils.getInstance().getString(ADDRESS);
    }

    public static void setOwnerKey(String ownerKey) {
        SPUtils.getInstance().put(OWNER_KEY, ownerKey);
    }

    public static String getOwnerKey() {
        return SPUtils.getInstance().getString(OWNER_KEY);
    }

    public static void setActiverKey(String activerKey) {
        SPUtils.getInstance().put(ACTIVER_KEY, activerKey);
    }

    public static String getActiverKey() {
        return SPUtils.getInstance().getString(ACTIVER_KEY);
    }
}
