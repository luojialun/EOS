package com.android.eos.bean;

/**
 * Created by luojialun on 2018/11/17.
 */

public class UpdateResponse {
    private String version;
    private String apk;
    private String ios;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApk() {
        return apk;
    }

    public void setApk(String apk) {
        this.apk = apk;
    }

    public String getIos() {
        return ios;
    }

    public void setIos(String ios) {
        this.ios = ios;
    }
}
