package com.example.godcode.bean;

public class PriceScale {


    /**
     * result : {"fK_UserID":11,"fK_User":null,"price":1,"fraction":10000,"addDateTime":"2019-06-25T10:23:22.8342005","id":2}
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private ResultBean result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }

    public void set__abp(boolean __abp) {
        this.__abp = __abp;
    }

    public static class ResultBean {
        /**
         * fK_UserID : 11
         * fK_User : null
         * price : 1
         * fraction : 10000
         * addDateTime : 2019-06-25T10:23:22.8342005
         * id : 2
         */

        private int fK_UserID;
        private Object fK_User;
        private int price;
        private int fraction;
        private String addDateTime;
        private int id;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public Object getFK_User() {
            return fK_User;
        }

        public void setFK_User(Object fK_User) {
            this.fK_User = fK_User;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getFraction() {
            return fraction;
        }

        public void setFraction(int fraction) {
            this.fraction = fraction;
        }

        public String getAddDateTime() {
            return addDateTime;
        }

        public void setAddDateTime(String addDateTime) {
            this.addDateTime = addDateTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
