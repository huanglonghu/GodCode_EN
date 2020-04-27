package com.example.godcode_en.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class RevenueDivide {

    /**
     * result : {"items":[{"fK_ProductID":2,"fK_UserIDOwner":12,"fK_UserIDDivide":12,"divideUserName":"123456","createTime":"2018-06-26T15:12:46.2358077","divideRate":100,"isValid":true,"remark":null,"lastModifyTime":"0001-01-01T00:00:00","lastModifyID":0,"id":8}]}
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
        private List<ItemsBean> items;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * fK_ProductID : 2
             * fK_UserIDOwner : 12
             * fK_UserIDDivide : 12
             * divideUserName : 123456
             * createTime : 2018-06-26T15:12:46.2358077
             * divideRate : 100
             * isValid : true
             * remark : null
             * lastModifyTime : 0001-01-01T00:00:00
             * lastModifyID : 0
             * id : 8
             */

            private int fK_ProductID;
            private int fK_UserIDOwner;
            private int fK_UserIDDivide;
            private String divideUserName;
            private String createTime;
            private int divideRate;
            private boolean isValid;
            private String remark;
            private String lastModifyTime;
            private int lastModifyID;
            private int id;

            public int getFK_ProductID() {
                return fK_ProductID;
            }

            public void setFK_ProductID(int fK_ProductID) {
                this.fK_ProductID = fK_ProductID;
            }

            public int getFK_UserIDOwner() {
                return fK_UserIDOwner;
            }

            public void setFK_UserIDOwner(int fK_UserIDOwner) {
                this.fK_UserIDOwner = fK_UserIDOwner;
            }

            public int getFK_UserIDDivide() {
                return fK_UserIDDivide;
            }

            public void setFK_UserIDDivide(int fK_UserIDDivide) {
                this.fK_UserIDDivide = fK_UserIDDivide;
            }

            public String getDivideUserName() {
                return divideUserName;
            }

            public void setDivideUserName(String divideUserName) {
                this.divideUserName = divideUserName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getDivideRate() {
                return divideRate;
            }

            public void setDivideRate(int divideRate) {
                this.divideRate = divideRate;
            }

            public boolean isIsValid() {
                return isValid;
            }

            public void setIsValid(boolean isValid) {
                this.isValid = isValid;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public int getLastModifyID() {
                return lastModifyID;
            }

            public void setLastModifyID(int lastModifyID) {
                this.lastModifyID = lastModifyID;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
