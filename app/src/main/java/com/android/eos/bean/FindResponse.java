package com.android.eos.bean;

import java.util.List;

/**
 * Created by luojialun on 2018/11/17.
 */

public class FindResponse {


    /**
     * game : {"banner":[{"icon":"http://api.gwchain.io/public/icon/banner.png","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/banner.png","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/banner.png","url":"http://www.baidu.com"}],"week":[{"icon":"http://api.gwchain.io/public/icon/icon1.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/icon2.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"}],"hots":[{"icon":"http://api.gwchain.io/public/icon/icon1.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/icon2.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/icon1.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"}]}
     * dapp : {"banner":[{"icon":"http://api.gwchain.io/public/icon/banner.png","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/banner.png","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/banner.png","url":"http://www.baidu.com"}],"week":[{"icon":"http://api.gwchain.io/public/icon/icon1.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/icon2.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"}],"recommend":[{"icon":"http://api.gwchain.io/public/icon/icon1.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/icon2.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"},{"icon":"http://api.gwchain.io/public/icon/icon1.png","name":"疯狂动物园","detail":"荣获2016全国大奖","url":"http://www.baidu.com"}]}
     */

    private GameBean game;
    private DappBean dapp;

    public GameBean getGame() {
        return game;
    }

    public void setGame(GameBean game) {
        this.game = game;
    }

    public DappBean getDapp() {
        return dapp;
    }

    public void setDapp(DappBean dapp) {
        this.dapp = dapp;
    }

    public static class GameBean {
        private List<BannerBean> banner;
        private List<WeekBean> week;
        private List<HotsBean> hots;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<WeekBean> getWeek() {
            return week;
        }

        public void setWeek(List<WeekBean> week) {
            this.week = week;
        }

        public List<HotsBean> getHots() {
            return hots;
        }

        public void setHots(List<HotsBean> hots) {
            this.hots = hots;
        }


    }

    public static class DappBean {
        private List<BannerBean> banner;
        private List<WeekBean> week;
        private List<RecommendBean> recommend;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<WeekBean> getWeek() {
            return week;
        }

        public void setWeek(List<WeekBean> week) {
            this.week = week;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

    }

    public static class BannerBean {
        /**
         * icon : http://api.gwchain.io/public/icon/banner.png
         * url : http://www.baidu.com
         */

        private String icon;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WeekBean {
        /**
         * icon : http://api.gwchain.io/public/icon/icon1.png
         * name : 疯狂动物园
         * detail : 荣获2016全国大奖
         * url : http://www.baidu.com
         */

        private String icon;
        private String name;
        private String detail;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class HotsBean {
        /**
         * icon : http://api.gwchain.io/public/icon/icon1.png
         * name : 疯狂动物园
         * detail : 荣获2016全国大奖
         * url : http://www.baidu.com
         */

        private String icon;
        private String name;
        private String detail;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class RecommendBean {
        /**
         * icon : http://api.gwchain.io/public/icon/icon1.png
         * name : 疯狂动物园
         * detail : 荣获2016全国大奖
         * url : http://www.baidu.com
         */

        private String icon;
        private String name;
        private String detail;
        private String url;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
