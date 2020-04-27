package com.example.godcode_en.bean;


public class DivideIncome {


    /**
     * result : {"toDayMoney":0,"yesterDayMoney":0,"balances":3.05,"yesterDayCoinMoney":0,"toDayCoinMoney":0,"coinBalances":0}
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
         * toDayMoney : 0.0
         * yesterDayMoney : 0.0
         * balances : 3.05
         * yesterDayCoinMoney : 0.0
         * toDayCoinMoney : 0.0
         * coinBalances : 0.0
         */

        private double toDayMoney;
        private double yesterDayMoney;
        private double balances;
        private double yesterDayCoinMoney;
        private double toDayCoinMoney;
        private double coinBalances;

        public double getToDayMoney() {
            return toDayMoney;
        }

        public void setToDayMoney(double toDayMoney) {
            this.toDayMoney = toDayMoney;
        }

        public double getYesterDayMoney() {
            return yesterDayMoney;
        }

        public void setYesterDayMoney(double yesterDayMoney) {
            this.yesterDayMoney = yesterDayMoney;
        }

        public double getBalances() {
            return balances;
        }

        public void setBalances(double balances) {
            this.balances = balances;
        }

        public double getYesterDayCoinMoney() {
            return yesterDayCoinMoney;
        }

        public void setYesterDayCoinMoney(double yesterDayCoinMoney) {
            this.yesterDayCoinMoney = yesterDayCoinMoney;
        }

        public double getToDayCoinMoney() {
            return toDayCoinMoney;
        }

        public void setToDayCoinMoney(double toDayCoinMoney) {
            this.toDayCoinMoney = toDayCoinMoney;
        }

        public double getCoinBalances() {
            return coinBalances;
        }

        public void setCoinBalances(double coinBalances) {
            this.coinBalances = coinBalances;
        }
    }
}
