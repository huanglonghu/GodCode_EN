package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/8/20.
 */

public class SHSR {

    /**
     * result : {"fK_UserIDIncome":20065,"incomeUserName":"东华(sy1533940554)","feeType":"CNY","incomeAmount":0.16,"incomeGenre":4,"incomeTime":"2018-08-20T12:06:45.2323248"}
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
         * fK_UserIDIncome : 20065
         * incomeUserName : 东华(sy1533940554)
         * feeType : CNY
         * incomeAmount : 0.16
         * incomeGenre : 4
         * incomeTime : 2018-08-20T12:06:45.2323248
         */

        private int fK_UserIDIncome;
        private String incomeUserName;
        private String feeType;
        private double incomeAmount;
        private int incomeGenre;
        private String incomeTime;

        public int getFK_UserIDIncome() {
            return fK_UserIDIncome;
        }

        public void setFK_UserIDIncome(int fK_UserIDIncome) {
            this.fK_UserIDIncome = fK_UserIDIncome;
        }

        public String getIncomeUserName() {
            return incomeUserName;
        }

        public void setIncomeUserName(String incomeUserName) {
            this.incomeUserName = incomeUserName;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public double getIncomeAmount() {
            return incomeAmount;
        }

        public void setIncomeAmount(double incomeAmount) {
            this.incomeAmount = incomeAmount;
        }

        public int getIncomeGenre() {
            return incomeGenre;
        }

        public void setIncomeGenre(int incomeGenre) {
            this.incomeGenre = incomeGenre;
        }

        public String getIncomeTime() {
            return incomeTime;
        }

        public void setIncomeTime(String incomeTime) {
            this.incomeTime = incomeTime;
        }
    }
}
