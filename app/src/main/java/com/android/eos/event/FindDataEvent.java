package com.android.eos.event;

/**
 * Created by luojialun on 2018/11/17.
 */

public class FindDataEvent {

    private boolean status;//数据请求是否成功

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public FindDataEvent(boolean status) {
        this.status = status;
    }
}
