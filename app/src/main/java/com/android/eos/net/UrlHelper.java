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
    //查询交易信息  psot
    public final static String getDealMsgList = apiUrl + "v1/history/get_actions";
    //更新日志 get
    public final static String upLog = apiUrl + "up_log.html";
    //版本检测 get
    public static final String version = apiUrl + "version.json";
    //帮助与反馈数据 get
    public static final String help_feedback = apiUrl + "help/problem.json";
    //帮助与反馈搜索 get
    public static final String help_search = apiUrl + "help/search.html?w=";
    //发现页数据  get
    public static final String find = apiUrl + "find.json";
    //创建身份 get
    public static final String register = apiUrl + "v1/register";
    //登录身份  get
    public static final String login = apiUrl + "v1/login";
    //更新数据  get
    public static final String update_identity = apiUrl + "v1/update";


}
