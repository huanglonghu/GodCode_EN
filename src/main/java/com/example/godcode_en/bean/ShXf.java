package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/8/17.
 */

public class ShXf {

    /**
     * result : {"id":30423,"orderNumber":"T5B770314B2463","fK_ProduceID":20020,"produceName":"薯条","feeType":"CNY","sumOrder":1,"payDate":"2018-08-17T17:17:12.4862562","userName":"sy1534524668","fK_UserID":20077,"paymentMode":2,"paymentGenre":0}
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
         * id : 30423
         * orderNumber : T5B770314B2463
         * fK_ProduceID : 20020
         * produceName : 薯条
         * feeType : CNY
         * sumOrder : 1.0
         * payDate : 2018-08-17T17:17:12.4862562
         * userName : sy1534524668
         * fK_UserID : 20077
         * paymentMode : 2
         * paymentGenre : 0
         */

        private int id;
        private String orderNumber;
        private int fK_ProduceID;
        private String produceName;
        private String feeType;
        private double sumOrder;
        private String payDate;
        private String userName;
        private int fK_UserID;
        private int paymentMode;
        private int paymentGenre;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public int getFK_ProduceID() {
            return fK_ProduceID;
        }

        public void setFK_ProduceID(int fK_ProduceID) {
            this.fK_ProduceID = fK_ProduceID;
        }

        public String getProduceName() {
            return produceName;
        }

        public void setProduceName(String produceName) {
            this.produceName = produceName;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public double getSumOrder() {
            return sumOrder;
        }

        public void setSumOrder(double sumOrder) {
            this.sumOrder = sumOrder;
        }

        public String getPayDate() {
            return payDate;
        }

        public void setPayDate(String payDate) {
            this.payDate = payDate;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public int getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(int paymentMode) {
            this.paymentMode = paymentMode;
        }

        public int getPaymentGenre() {
            return paymentGenre;
        }

        public void setPaymentGenre(int paymentGenre) {
            this.paymentGenre = paymentGenre;
        }
    }
}
