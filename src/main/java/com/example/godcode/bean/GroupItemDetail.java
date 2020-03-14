package com.example.godcode.bean;

import java.util.List;

public class GroupItemDetail {
    /**
     * result : {"count":2,"data":[{"mcProductID":11,"mcProductNumber":"4","mcProductName":"4","unlockFraction":0,"unlockCount":0,"id":6},{"mcProductID":12,"mcProductNumber":"5","mcProductName":"5","unlockFraction":0,"unlockCount":0,"id":7}]}
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
         * count : 2
         * data : [{"mcProductID":11,"mcProductNumber":"4","mcProductName":"4","unlockFraction":0,"unlockCount":0,"id":6},{"mcProductID":12,"mcProductNumber":"5","mcProductName":"5","unlockFraction":0,"unlockCount":0,"id":7}]
         */

        private int count;
        private List<DataBean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * mcProductID : 11
             * mcProductNumber : 4
             * mcProductName : 4
             * unlockFraction : 0
             * unlockCount : 0
             * id : 6
             */

            private int mcProductID;
            private String mcProductNumber;
            private String mcProductName;
            private int unlockFraction;
            private int unlockCount;
            private int id;

            public int getMcProductID() {
                return mcProductID;
            }

            public void setMcProductID(int mcProductID) {
                this.mcProductID = mcProductID;
            }

            public String getMcProductNumber() {
                return mcProductNumber;
            }

            public void setMcProductNumber(String mcProductNumber) {
                this.mcProductNumber = mcProductNumber;
            }

            public String getMcProductName() {
                return mcProductName;
            }

            public void setMcProductName(String mcProductName) {
                this.mcProductName = mcProductName;
            }

            public int getUnlockFraction() {
                return unlockFraction;
            }

            public void setUnlockFraction(int unlockFraction) {
                this.unlockFraction = unlockFraction;
            }

            public int getUnlockCount() {
                return unlockCount;
            }

            public void setUnlockCount(int unlockCount) {
                this.unlockCount = unlockCount;
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
