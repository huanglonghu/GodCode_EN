package com.example.godcode.bean;

public class SystemSetting {


    /**
     * result : {"systenWithdrawRate":0.006,"updateTime":"2018-09-17T18:29:17.5414516","juHeNoticeMoblie":"13091949999","juHeNoticeAmount":"230","updateUserID":2,"isPutMoneySms":true,"rechargeMaxAmount":10000,"publicNoPrice":0,"id":1}
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
         * systenWithdrawRate : 0.006
         * updateTime : 2018-09-17T18:29:17.5414516
         * juHeNoticeMoblie : 13091949999
         * juHeNoticeAmount : 230
         * updateUserID : 2
         * isPutMoneySms : true
         * rechargeMaxAmount : 10000.0
         * publicNoPrice : 0.0
         * id : 1
         */

        private double systenWithdrawRate;
        private String updateTime;
        private String juHeNoticeMoblie;
        private String juHeNoticeAmount;
        private int updateUserID;
        private boolean isPutMoneySms;
        private double rechargeMaxAmount;
        private double publicNoPrice;
        private int id;

        public double getSystenWithdrawRate() {
            return systenWithdrawRate;
        }

        public void setSystenWithdrawRate(double systenWithdrawRate) {
            this.systenWithdrawRate = systenWithdrawRate;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getJuHeNoticeMoblie() {
            return juHeNoticeMoblie;
        }

        public void setJuHeNoticeMoblie(String juHeNoticeMoblie) {
            this.juHeNoticeMoblie = juHeNoticeMoblie;
        }

        public String getJuHeNoticeAmount() {
            return juHeNoticeAmount;
        }

        public void setJuHeNoticeAmount(String juHeNoticeAmount) {
            this.juHeNoticeAmount = juHeNoticeAmount;
        }

        public int getUpdateUserID() {
            return updateUserID;
        }

        public void setUpdateUserID(int updateUserID) {
            this.updateUserID = updateUserID;
        }

        public boolean isIsPutMoneySms() {
            return isPutMoneySms;
        }

        public void setIsPutMoneySms(boolean isPutMoneySms) {
            this.isPutMoneySms = isPutMoneySms;
        }

        public double getRechargeMaxAmount() {
            return rechargeMaxAmount;
        }

        public void setRechargeMaxAmount(double rechargeMaxAmount) {
            this.rechargeMaxAmount = rechargeMaxAmount;
        }

        public double getPublicNoPrice() {
            return publicNoPrice;
        }

        public void setPublicNoPrice(double publicNoPrice) {
            this.publicNoPrice = publicNoPrice;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
