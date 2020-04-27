package com.example.godcode_en.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/17.
 */

public class OrderDetail implements Serializable {

    /**
     * result : {"id":29,"fK_ProductID":20,"orderNumber":"T5B4DF781D856A","feeType":"CNY","orderDate":"2018-07-17T14:04:49.1220054+08:00","sumOrder":18}
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
         * id : 29
         * fK_ProductID : 20
         * orderNumber : T5B4DF781D856A
         * feeType : CNY
         * orderDate : 2018-07-17T14:04:49.1220054+08:00
         * sumOrder : 18.0
         */

        private int id;
        private int fK_ProductID;
        private String orderNumber;
        private String feeType;
        private String orderDate;
        private double sumOrder;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFK_ProductID() {
            return fK_ProductID;
        }

        public void setFK_ProductID(int fK_ProductID) {
            this.fK_ProductID = fK_ProductID;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public double getSumOrder() {
            return sumOrder;
        }

        public void setSumOrder(double sumOrder) {
            this.sumOrder = sumOrder;
        }
    }
}
