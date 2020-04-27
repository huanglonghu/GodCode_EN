package com.example.godcode_en.bean;

import java.util.List;


public class ProductList {

    /**
     * code : 0
     * msg : string
     * count : 0
     * data : [{"productNumber":"string","productName":"string","fK_ProductCategoryID":0,"productCategoryName":"string","isValid":true,"thumbnailImgPath":"string","publishTime":"2018-06-22T01:58:31.038Z","description":"string","createTime":"2018-06-22T01:58:31.038Z","createUserID":0,"updateTime":"2018-06-22T01:58:31.038Z","updateUserID":0,"id":0}]
     */

    private int code;
    private String msg;
    private int count;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
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
         * productNumber : string
         * productName : string
         * fK_ProductCategoryID : 0
         * productCategoryName : string
         * isValid : true
         * thumbnailImgPath : string
         * publishTime : 2018-06-22T01:58:31.038Z
         * description : string
         * createTime : 2018-06-22T01:58:31.038Z
         * createUserID : 0
         * updateTime : 2018-06-22T01:58:31.038Z
         * updateUserID : 0
         * id : 0
         */

        private String productNumber;
        private String productName;
        private int fK_ProductCategoryID;
        private String productCategoryName;
        private boolean isValid;
        private String thumbnailImgPath;
        private String publishTime;
        private String description;
        private String createTime;
        private int createUserID;
        private String updateTime;
        private int updateUserID;
        private int id;

        public String getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getFK_ProductCategoryID() {
            return fK_ProductCategoryID;
        }

        public void setFK_ProductCategoryID(int fK_ProductCategoryID) {
            this.fK_ProductCategoryID = fK_ProductCategoryID;
        }

        public String getProductCategoryName() {
            return productCategoryName;
        }

        public void setProductCategoryName(String productCategoryName) {
            this.productCategoryName = productCategoryName;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }

        public String getThumbnailImgPath() {
            return thumbnailImgPath;
        }

        public void setThumbnailImgPath(String thumbnailImgPath) {
            this.thumbnailImgPath = thumbnailImgPath;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getCreateUserID() {
            return createUserID;
        }

        public void setCreateUserID(int createUserID) {
            this.createUserID = createUserID;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getUpdateUserID() {
            return updateUserID;
        }

        public void setUpdateUserID(int updateUserID) {
            this.updateUserID = updateUserID;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
