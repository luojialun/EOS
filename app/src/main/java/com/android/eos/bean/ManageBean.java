package com.android.eos.bean;

public class ManageBean {
    private int img;
    private String desc;

    public ManageBean(int img, String desc) {
        this.img = img;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
