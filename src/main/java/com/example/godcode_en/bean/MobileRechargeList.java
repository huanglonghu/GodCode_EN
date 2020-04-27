package com.example.godcode_en.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/11/2.
 */

public class MobileRechargeList {

    /**
     * result : [{"rechargeAmount":1,"sellAmount":1,"operateUserID":0,"operateUserName":null,"isEnable":false,"operateDateTime":"0001-01-01T00:00:00","id":4},{"rechargeAmount":30,"sellAmount":29.82,"operateUserID":0,"operateUserName":null,"isEnable":false,"operateDateTime":"0001-01-01T00:00:00","id":2}]
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
         * rechargeAmount : 1.0
         * sellAmount : 1.0
         * operateUserID : 0
         * operateUserName : null
         * isEnable : false
         * operateDateTime : 0001-01-01T00:00:00
         * id : 4
         */

        private double rechargeAmount;
        private double sellAmount;
        private int operateUserID;
        private Object operateUserName;
        private boolean isEnable;
        private String operateDateTime;
        private int id;

        public double getRechargeAmount() {
            return rechargeAmount;
        }

        public void setRechargeAmount(double rechargeAmount) {
            this.rechargeAmount = rechargeAmount;
        }

        public double getSellAmount() {
            return sellAmount;
        }

        public void setSellAmount(double sellAmount) {
            this.sellAmount = sellAmount;
        }

        public int getOperateUserID() {
            return operateUserID;
        }

        public void setOperateUserID(int operateUserID) {
            this.operateUserID = operateUserID;
        }

        public Object getOperateUserName() {
            return operateUserName;
        }

        public void setOperateUserName(Object operateUserName) {
            this.operateUserName = operateUserName;
        }

        public boolean isIsEnable() {
            return isEnable;
        }

        public void setIsEnable(boolean isEnable) {
            this.isEnable = isEnable;
        }

        public String getOperateDateTime() {
            return operateDateTime;
        }

        public void setOperateDateTime(String operateDateTime) {
            this.operateDateTime = operateDateTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
