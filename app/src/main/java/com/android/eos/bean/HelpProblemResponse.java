package com.android.eos.bean;

import java.util.List;

/**
 * Created by luojialun on 2018/11/17.
 */

public class HelpProblemResponse {

    private List<CommonBean> common;
    private List<TypesBean> types;

    public List<CommonBean> getCommon() {
        return common;
    }

    public void setCommon(List<CommonBean> common) {
        this.common = common;
    }

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class CommonBean {
        /**
         * title : 如果修改钱包密码？
         * url : http://api.gwchain.io/help/problem.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class TypesBean {
        /**
         * title : 基本操作
         * detail : 身份/钱包/交易
         * url : http://api.gwchain.io/help/problem.html
         */

        private String title;
        private String detail;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
