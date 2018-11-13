package com.android.eos.net;

/**
 * Url管理类
 */

public class UrlHelper {

    public final static String apiUrl = "http://api.gwchain.io/";
    public final static String nodeUrl = "https://nodes.get-scatter.com/v1/";

    //创建EOS账户
    public final static String createEOS = apiUrl + "v1/create";
    //查询账户信息（资源信息）
    public final static String getAccount = nodeUrl + "chain/get_account";



}
