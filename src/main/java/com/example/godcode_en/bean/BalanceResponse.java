package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/6/26.
 */

public class BalanceResponse {

    /**
     * result : {"balances":499,"fK_UserID":6,"feeType":"CNY","withdrawRate":0.007,"id":10}
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
         * balances : 499.0
         * fK_UserID : 6
         * feeType : CNY
         * withdrawRate : 0.007
         * id : 10
         */

        private double balances;
        private int fK_UserID;
        private String feeType;
        private double withdrawRate;
        private int id;

        public double getBalances() {
            return balances;
        }

        public void setBalances(double balances) {
            this.balances = balances;
        }

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public double getWithdrawRate() {
            return withdrawRate;
        }

        public void setWithdrawRate(double withdrawRate) {
            this.withdrawRate = withdrawRate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
