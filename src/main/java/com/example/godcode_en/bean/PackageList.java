package com.example.godcode_en.bean;

import java.util.List;

public class PackageList {


    /**
     * result : {"code":0,"msg":null,"count":1,"data":[{"fK_UserID":11,"fK_ProductCategoryID":14,"price":3,"coinCount":3,"addDateTime":"0001-01-01T00:00:00","id":1}]}
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
         * code : 0
         * msg : null
         * count : 1
         * data : [{"fK_UserID":11,"fK_ProductCategoryID":14,"price":3,"coinCount":3,"addDateTime":"0001-01-01T00:00:00","id":1}]
         */

        private int code;
        private Object msg;
        private int count;
        private List<DataBean> data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Object getMsg() {
            return msg;
        }

        public void setMsg(Object msg) {
            this.msg = msg;
        }

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
             * fK_UserID : 11
             * fK_ProductCategoryID : 14
             * price : 3.0
             * coinCount : 3
             * addDateTime : 0001-01-01T00:00:00
             * id : 1
             */

            private int fK_UserID;
            private int fK_ProductCategoryID;
            private Integer price;
            private Integer coinCount;
            private String addDateTime;
            private int id;

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public int getFK_ProductCategoryID() {
                return fK_ProductCategoryID;
            }

            public void setFK_ProductCategoryID(int fK_ProductCategoryID) {
                this.fK_ProductCategoryID = fK_ProductCategoryID;
            }

            public Integer getPrice() {
                if (price == null) {
                    return 0;
                }
                return price;
            }

            public void setPrice(Integer price) {
                this.price = price;
            }

            public Integer getCoinCount() {
                if (coinCount == null) {
                    return 0;
                }
                return coinCount;
            }

            public void setCoinCount(Integer coinCount) {
                this.coinCount = coinCount;
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
}
