package com.example.godcode_en.bean;

import java.util.List;

public class PackageSettingList {


    /**
     * result : [{"fK_ProductID":347,"fK_PackageID":2,"price":3,"coinCount":3,"id":1}]
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
         * fK_ProductID : 347
         * fK_PackageID : 2
         * price : 3.0
         * coinCount : 3.0
         * id : 1
         */

        private int fK_ProductID;
        private int fK_PackageID;
        private int price;
        private int coinCount;
        private int id;

        public int getFK_ProductID() {
            return fK_ProductID;
        }

        public void setFK_ProductID(int fK_ProductID) {
            this.fK_ProductID = fK_ProductID;
        }

        public int getFK_PackageID() {
            return fK_PackageID;
        }

        public void setFK_PackageID(int fK_PackageID) {
            this.fK_PackageID = fK_PackageID;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(int coinCount) {
            this.coinCount = coinCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
