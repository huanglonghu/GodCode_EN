package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/8/30.
 */

public class QRPay {


    /**
     * result : {"fK_UserIDDisburs":20087,"disbursUserName":"ifelse(sy1535125855)","feeType":"cny","paymentAmount":0.01,"paymentGenre":4,"paymentTime":"2018-08-30T15:14:29.4615841","paymentMode":2}
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
         * fK_UserIDDisburs : 20087
         * disbursUserName : ifelse(sy1535125855)
         * feeType : cny
         * paymentAmount : 0.01
         * paymentGenre : 4
         * paymentTime : 2018-08-30T15:14:29.4615841
         * paymentMode : 2
         */

        private int fK_UserIDDisburs;
        private String disbursUserName;
        private String feeType;
        private double paymentAmount;
        private int paymentGenre;
        private String paymentTime;
        private int paymentMode;

        public int getFK_UserIDDisburs() {
            return fK_UserIDDisburs;
        }

        public void setFK_UserIDDisburs(int fK_UserIDDisburs) {
            this.fK_UserIDDisburs = fK_UserIDDisburs;
        }

        public String getDisbursUserName() {
            return disbursUserName;
        }

        public void setDisbursUserName(String disbursUserName) {
            this.disbursUserName = disbursUserName;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public double getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public int getPaymentGenre() {
            return paymentGenre;
        }

        public void setPaymentGenre(int paymentGenre) {
            this.paymentGenre = paymentGenre;
        }

        public String getPaymentTime() {
            return paymentTime;
        }

        public void setPaymentTime(String paymentTime) {
            this.paymentTime = paymentTime;
        }

        public int getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(int paymentMode) {
            this.paymentMode = paymentMode;
        }
    }
}
