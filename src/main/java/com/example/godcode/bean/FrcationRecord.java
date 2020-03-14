package com.example.godcode.bean;

import android.text.TextUtils;

import com.example.godcode.utils.DateUtil;

public class FrcationRecord {


    /**
     * result : {"addDateTime":"2019-06-25T18:37:11.743","fraction":10000,"money":1}
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
         * addDateTime : 2019-06-25T18:37:11.743
         * fraction : 10000.0
         * money : 1.0
         */

        private String addDateTime;
        private double fraction;
        private double money;

        public String getAddDateTime() {
            if(!TextUtils.isEmpty(addDateTime)){
                addDateTime= DateUtil.getInstance().formatDate(addDateTime);
            }
            return addDateTime;
        }

        public void setAddDateTime(String addDateTime) {
            this.addDateTime = addDateTime;
        }

        public double getFraction() {
            return fraction;
        }

        public void setFraction(double fraction) {
            this.fraction = fraction;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }
    }
}
