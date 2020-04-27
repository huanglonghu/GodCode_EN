package com.example.godcode_en.bean;

import java.util.List;

public class PresentList {

    /**
     * result : {"totalCount":1,"items":[{"fK_UserID":11,"presentName":"嗨皮","costPrice":1,"presentImgUrl":null,"addDateTime":"0001-01-01T00:00:00","id":1}]}
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
         * totalCount : 1
         * items : [{"fK_UserID":11,"presentName":"嗨皮","costPrice":1,"presentImgUrl":null,"addDateTime":"0001-01-01T00:00:00","id":1}]
         */

        private int totalCount;
        private List<ItemsBean> items;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * fK_UserID : 11
             * presentName : 嗨皮
             * costPrice : 1.0
             * presentImgUrl : null
             * addDateTime : 0001-01-01T00:00:00
             * id : 1
             */

            private int fK_UserID;
            private String presentName;
            private String costPrice;
            private String presentImgUrl;
            private String addDateTime;
            private int id;

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public String getPresentName() {
                return presentName;
            }

            public void setPresentName(String presentName) {
                this.presentName = presentName;
            }

            public String getCostPrice() {
                return costPrice;
            }

            public void setCostPrice(String costPrice) {
                this.costPrice = costPrice;
            }

            public String getPresentImgUrl() {
                return presentImgUrl;
            }

            public void setPresentImgUrl(String presentImgUrl) {
                this.presentImgUrl = presentImgUrl;
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
