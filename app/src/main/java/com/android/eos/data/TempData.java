package com.android.eos.data;

import com.android.eos.bean.AccountResponse;
import com.android.eos.bean.DealListMsgResponse;
import com.android.eos.bean.FindResponse;

import java.util.List;

/**
 * Created by luojialun on 2018/11/17.
 */

public class TempData {

    public static FindResponse findResponse;  //发现页数据

    public static FindResponse getFindResponse() {
        return findResponse;
    }

    public static void setFindResponse(FindResponse findResponse) {
        TempData.findResponse = findResponse;
    }

    public static List<DealListMsgResponse.ActionsBean> actionsBeanList;  //交易信息列表

    public static List<DealListMsgResponse.ActionsBean> getActionsBeanList() {
        return actionsBeanList;
    }

    public static void setActionsBeanList(List<DealListMsgResponse.ActionsBean> actionsBeanList) {
        TempData.actionsBeanList = actionsBeanList;
    }

    public static AccountResponse accountResponse;

    public static AccountResponse getAccountResponse() {
        return accountResponse;
    }

    public static void setAccountResponse(AccountResponse accountResponse) {
        TempData.accountResponse = accountResponse;
    }
}
