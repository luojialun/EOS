package com.android.eos.bean;

/**
 * Created by luojialun on 2018/11/13.
 */

public class CreateEOSResponse {
    private boolean ret;
    private String tid;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
