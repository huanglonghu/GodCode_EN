package com.example.godcode_en.bean;

import java.util.List;

public class SellGoodsOrder {


    /**
     * result : [{"fK_OrderID":13808,"position":2,"count":1,"sumMoney":0,"payType":0,"addDateTime":"0001-01-01T00:00:00","id":81}]
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
         * fK_OrderID : 13808
         * position : 2
         * count : 1
         * sumMoney : 0
         * payType : 0
         * addDateTime : 0001-01-01T00:00:00
         * id : 81
         */

        private int fK_OrderID;
        private int position;
        private int count;
        private int sumMoney;
        private int payType;
        private String addDateTime;
        private int id;

        public int getFK_OrderID() {
            return fK_OrderID;
        }

        public void setFK_OrderID(int fK_OrderID) {
            this.fK_OrderID = fK_OrderID;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getSumMoney() {
            return sumMoney;
        }

        public void setSumMoney(int sumMoney) {
            this.sumMoney = sumMoney;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
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



