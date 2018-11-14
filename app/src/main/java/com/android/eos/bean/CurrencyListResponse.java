package com.android.eos.bean;

import java.util.List;

/**
 * 代币列表返回类
 */

public class CurrencyListResponse {

    private List<EOSBean> eos;

    public List<EOSBean> getEos() {
        return eos;
    }

    public void setEos(List<EOSBean> eos) {
        this.eos = eos;
    }

    public static class EOSBean {
        private String name;
        private String address;
        private String icon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

}
