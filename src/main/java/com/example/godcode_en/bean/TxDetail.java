package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/26.
 */

public class TxDetail {

    /**
     * result : {"fK_UserID":20084,"userName":"keyd(sy1535124657)","putFactorage":0,"putRate":0,"putTime":null,"recordTime":"2018-08-31T11:46:40.2669151","feeType":"CNY","sumTotal":0.01,"errCodeDes":null,"putStatus":2,"fK_BankCardID":26,"bankNumber":"光大银行(6432)"}
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
         * fK_UserID : 20084
         * userName : keyd(sy1535124657)
         * putFactorage : 0.0
         * putRate : 0.0
         * putTime : null
         * recordTime : 2018-08-31T11:46:40.2669151
         * feeType : CNY
         * sumTotal : 0.01
         * errCodeDes : null
         * putStatus : 2
         * fK_BankCardID : 26
         * bankNumber : 光大银行(6432)
         */

        private int fK_UserID;
        private String userName;
        private double putFactorage;
        private double putRate;
        private Object putTime;
        private String recordTime;
        private String feeType;
        private double sumTotal;
        private Object errCodeDes;
        private int putStatus;
        private int fK_BankCardID;
        private String bankNumber;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public double getPutFactorage() {
            return putFactorage;
        }

        public void setPutFactorage(double putFactorage) {
            this.putFactorage = putFactorage;
        }

        public double getPutRate() {
            return putRate;
        }

        public void setPutRate(double putRate) {
            this.putRate = putRate;
        }

        public Object getPutTime() {
            return putTime;
        }

        public void setPutTime(Object putTime) {
            this.putTime = putTime;
        }

        public String getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(String recordTime) {
            this.recordTime = recordTime;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public double getSumTotal() {
            return sumTotal;
        }

        public void setSumTotal(double sumTotal) {
            this.sumTotal = sumTotal;
        }

        public Object getErrCodeDes() {
            return errCodeDes;
        }

        public void setErrCodeDes(Object errCodeDes) {
            this.errCodeDes = errCodeDes;
        }

        public int getPutStatus() {
            return putStatus;
        }

        public void setPutStatus(int putStatus) {
            this.putStatus = putStatus;
        }

        public int getFK_BankCardID() {
            return fK_BankCardID;
        }

        public void setFK_BankCardID(int fK_BankCardID) {
            this.fK_BankCardID = fK_BankCardID;
        }

        public String getBankNumber() {
            return bankNumber;
        }

        public void setBankNumber(String bankNumber) {
            this.bankNumber = bankNumber;
        }
    }
}
