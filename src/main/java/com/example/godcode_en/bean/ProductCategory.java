package com.example.godcode_en.bean;

import java.util.List;

public class ProductCategory {

    /**
     * result : {"items":[{"productType":"摇摆机","parentID":"0","imgPath":"/Files/Pictures/ProductType/22e80b57-b443-47c7-a09e-f10ccb80fdd7.jpg","fullID":"1","fullName":"摇摆机","categorySort":0,"updateTime":"2018-10-15T11:20:33.6370004","purview":1,"id":2},{"productType":"咖啡机","parentID":"0","imgPath":"/Files/Pictures/ProductType/ff09e6a0-671d-4efd-9ab7-37a9208eb996.jpg","fullID":"1","fullName":"咖啡机","categorySort":0,"updateTime":"2018-10-15T11:09:37.3850004","purview":0,"id":4},{"productType":"儿童摇椅","parentID":"0","imgPath":"/Files/Pictures/ProductType/fcbe7273-da1a-410d-9377-fd510911649f.jpg","fullID":"1","fullName":"儿童摇椅","categorySort":0,"updateTime":"2018-09-26T10:34:16.6486007","purview":0,"id":9},{"productType":"娃娃机","parentID":"0","imgPath":"/Files/Pictures/ProductType/7aa38355-c175-455b-b899-0dc5461c00ad.jpg","fullID":"1","fullName":"娃娃机","categorySort":0,"updateTime":"2018-09-26T11:43:44.7176808","purview":0,"id":10},{"productType":"按摩椅","parentID":"0","imgPath":null,"fullID":"1","fullName":"按摩椅","categorySort":0,"updateTime":"2018-09-26T10:52:28.4483164","purview":0,"id":11},{"productType":"扭蛋机","parentID":"0","imgPath":null,"fullID":"1","fullName":"扭蛋机","categorySort":0,"updateTime":"2018-09-26T10:52:37.918934","purview":0,"id":12}]}
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
             * productType : 摇摆机
             * parentID : 0
             * imgPath : /Files/Pictures/ProductType/22e80b57-b443-47c7-a09e-f10ccb80fdd7.jpg
             * fullID : 1
             * fullName : 摇摆机
             * categorySort : 0
             * updateTime : 2018-10-15T11:20:33.6370004
             * purview : 1
             * id : 2
             */

            private String productType;
            private String parentID;
            private String imgPath;
            private String fullID;
            private String fullName;
            private int categorySort;
            private String updateTime;
            private int purview;
            private int id;

            public String getProductType() {
                return productType;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public String getParentID() {
                return parentID;
            }

            public void setParentID(String parentID) {
                this.parentID = parentID;
            }

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public String getFullID() {
                return fullID;
            }

            public void setFullID(String fullID) {
                this.fullID = fullID;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }

            public int getCategorySort() {
                return categorySort;
            }

            public void setCategorySort(int categorySort) {
                this.categorySort = categorySort;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getPurview() {
                return purview;
            }

            public void setPurview(int purview) {
                this.purview = purview;
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
