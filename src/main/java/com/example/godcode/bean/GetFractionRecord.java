package com.example.godcode.bean;

import java.util.List;

public class GetFractionRecord {


    /**
     * result : [{"fK_UserID":116,"money":0,"fraction":10,"giveUserID":11,"type":2,"addDateTime":"2019-06-28T11:12:31.1210007","id":16}]
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * fK_UserID : 116
         * money : 0.0
         * fraction : 10.0
         * giveUserID : 11
         * type : 2
         * addDateTime : 2019-06-28T11:12:31.1210007
         * id : 16
         */

        private int fK_UserID;
        private double money;
        private int fraction;
        private int giveUserID;
        private int type;
        private String addDateTime;
        private int id;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public int getFraction() {
            return fraction;
        }

        public void setFraction(int fraction) {
            this.fraction = fraction;
        }

        public int getGiveUserID() {
            return giveUserID;
        }

        public void setGiveUserID(int giveUserID) {
            this.giveUserID = giveUserID;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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
