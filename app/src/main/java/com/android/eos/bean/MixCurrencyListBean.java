package com.android.eos.bean;

/**
 * Created by luojialun on 2018/11/15.
 */

public class MixCurrencyListBean {

    private CurrencyListResponse.EOSBean eosBean;

    private PriceResponse.PriceBean priceBean;

    private String count;

    public CurrencyListResponse.EOSBean getEosBean() {
        return eosBean;
    }

    public void setEosBean(CurrencyListResponse.EOSBean eosBean) {
        this.eosBean = eosBean;
    }

    public PriceResponse.PriceBean getPriceBean() {
        return priceBean;
    }

    public void setPriceBean(PriceResponse.PriceBean priceBean) {
        this.priceBean = priceBean;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
