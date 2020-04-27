package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/8/17.
 */

public class Refound {

    /**
     * result : {"id":518,"orderNumber":"T5B9F81CC8EB52","fK_ProduceID":22,"produceName":"31薯条","productNumber":"SY31","feeType":"CNY","sumOrder":1,"payDate":"2018-09-17T10:28:31.7756289","userName":"sy1535976916","fK_UserID":3,"refundTime":"2018-09-17T10:28:56.4910725","refundRecvAccout":"退回支付用户零钱","resultCode":"退款成功"}
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
         * id : 518
         * orderNumber : T5B9F81CC8EB52
         * fK_ProduceID : 22
         * produceName : 31薯条
         * productNumber : SY31
         * feeType : CNY
         * sumOrder : 1.0
         * payDate : 2018-09-17T10:28:31.7756289
         * userName : sy1535976916
         * fK_UserID : 3
         * refundTime : 2018-09-17T10:28:56.4910725
         * refundRecvAccout : 退回支付用户零钱
         * resultCode : 退款成功
         */

        private int id;
        private String orderNumber;
        private int fK_ProduceID;
        private String produceName;
        private String productNumber;
        private String feeType;
        private double sumOrder;
        private String payDate;
        private String userName;
        private int fK_UserID;
        private String refundTime;
        private String refundRecvAccout;
        private String resultCode;

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

        public String getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
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

        public String getRefundTime() {
            return refundTime;
        }

        public void setRefundTime(String refundTime) {
            this.refundTime = refundTime;
        }

        public String getRefundRecvAccout() {
            return refundRecvAccout;
        }

        public void setRefundRecvAccout(String refundRecvAccout) {
            this.refundRecvAccout = refundRecvAccout;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }
    }
}
