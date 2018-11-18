package com.android.eos.data;

import com.android.eos.bean.FindResponse;

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


}
