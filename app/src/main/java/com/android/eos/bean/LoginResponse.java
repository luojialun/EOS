package com.android.eos.bean;

/**
 * Created by luojialun on 2018/11/17.
 */

public class LoginResponse {


    /**
     * ret : true
     * data : {"name":"2C6F4802560263BEE5D44177349799B8","token":"2C6F4802560263BEE5D44177349799B8token","face":"","id_name":"","id_card":"","email":""}
     */

    private boolean ret;
    private DataBean data;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 2C6F4802560263BEE5D44177349799B8
         * token : 2C6F4802560263BEE5D44177349799B8token
         * face :
         * id_name :
         * id_card :
         * email :
         */

        private String name;
        private String token;
        private String face;
        private String id_name;
        private String id_card;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getId_name() {
            return id_name;
        }

        public void setId_name(String id_name) {
            this.id_name = id_name;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
