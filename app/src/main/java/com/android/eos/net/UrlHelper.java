package com.android.eos.net;

/**
 * Url管理类
 */

public class UrlHelper {

    public final static String apiUrl = "http://api.gwchain.io/";
    //    public final static String nodeUrl = "https://nodes.get-scatter.com/";
    public final static String nodeUrl = "http://180.76.108.100:8081/";


    //创建EOS账户  post
    public final static String createEOS = apiUrl + "v1/create";
    //查询账户信息（资源信息）
    public final static String getAccount = nodeUrl + "v1/chain/get_account";
    //代币列表  get
    public final static String getCurrencyList = apiUrl + "currency.json";
    //获取代币价格  get
    public final static String getPrice = apiUrl + "v1/token/price";
    //公钥查账号  post
    public final static String getKeyAccounts = nodeUrl + "v1/history/get_key_accounts";
    //查询代币余额  post
    public final static String getCurrencyBalance = nodeUrl + "v1/chain/get_currency_balance";



}
