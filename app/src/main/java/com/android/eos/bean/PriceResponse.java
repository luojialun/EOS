package com.android.eos.bean;

import java.util.List;

/**
 * Created by luojialun on 2018/11/14.
 */

public class PriceResponse {

    private int code;
    private String message;
    private List<PriceBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PriceBean> getData() {
        return data;
    }

    public void setData(List<PriceBean> data) {
        this.data = data;
    }

    public static class PriceBean{
        private String name;
        private String symbol;
        private String price;
        private String high;
        private String low;
        private String hist_high;
        private String hist_low;
        private String timestamps;
        private String volume;
        private String display_volume;
        private String usd_volume;
        private String change_hourly;
        private String change_daily;
        private String change_weekly;
        private String change_monthly;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getHist_high() {
            return hist_high;
        }

        public void setHist_high(String hist_high) {
            this.hist_high = hist_high;
        }

        public String getHist_low() {
            return hist_low;
        }

        public void setHist_low(String hist_low) {
            this.hist_low = hist_low;
        }

        public String getTimestamps() {
            return timestamps;
        }

        public void setTimestamps(String timestamps) {
            this.timestamps = timestamps;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getDisplay_volume() {
            return display_volume;
        }

        public void setDisplay_volume(String display_volume) {
            this.display_volume = display_volume;
        }

        public String getUsd_volume() {
            return usd_volume;
        }

        public void setUsd_volume(String usd_volume) {
            this.usd_volume = usd_volume;
        }

        public String getChange_hourly() {
            return change_hourly;
        }

        public void setChange_hourly(String change_hourly) {
            this.change_hourly = change_hourly;
        }

        public String getChange_daily() {
            return change_daily;
        }

        public void setChange_daily(String change_daily) {
            this.change_daily = change_daily;
        }

        public String getChange_weekly() {
            return change_weekly;
        }

        public void setChange_weekly(String change_weekly) {
            this.change_weekly = change_weekly;
        }

        public String getChange_monthly() {
            return change_monthly;
        }

        public void setChange_monthly(String change_monthly) {
            this.change_monthly = change_monthly;
        }
    }

}
