package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/11/3.
 */

public class MobileRechargeRecord {

    /**
     * result : {"addDateTime":"2018-11-02T16:05:18.8494007","description":"广东联通话费1元","paymentAmount":1,"rechargeAmount":1,"rechargeOrderNumber":"T5BDC75BE9B6E2","rechargePhoneNumber":"13076737863","userName":"穷开心(108075)"}
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
         * addDateTime : 2018-11-02T16:05:18.8494007
         * description : 广东联通话费1元
         * paymentAmount : 1.0
         * rechargeAmount : 1.0
         * rechargeOrderNumber : T5BDC75BE9B6E2
         * rechargePhoneNumber : 13076737863
         * userName : 穷开心(108075)
         */

        private String addDateTime;
        private String description;
        private String paymentAmount;
        private String rechargeAmount;
        private String rechargeOrderNumber;
        private String rechargePhoneNumber;
        private String userName;

        public String getAddDateTime() {
            return addDateTime;
        }

        public void setAddDateTime(String addDateTime) {
            this.addDateTime = addDateTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(String paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public String getRechargeAmount() {
            return rechargeAmount;
        }

        public void setRechargeAmount(String rechargeAmount) {
            this.rechargeAmount = rechargeAmount;
        }

        public String getRechargeOrderNumber() {
            return rechargeOrderNumber;
        }

        public void setRechargeOrderNumber(String rechargeOrderNumber) {
            this.rechargeOrderNumber = rechargeOrderNumber;
        }

        public String getRechargePhoneNumber() {
            return rechargePhoneNumber;
        }

        public void setRechargePhoneNumber(String rechargePhoneNumber) {
            this.rechargePhoneNumber = rechargePhoneNumber;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
