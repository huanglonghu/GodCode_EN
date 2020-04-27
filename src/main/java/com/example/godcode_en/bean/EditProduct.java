package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/8/24.
 */

public class EditProduct {

    /**
     * product : {"id":0,"productNumber":"string","productName":"string","fK_ProductCategoryID":0,"isValid":true,"thumbnailImgPath":"string","description":"string","machineAddress":"string"}
     */

    private ProductBean product;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {
        /**
         * id : 0
         * productNumber : string
         * productName : string
         * fK_ProductCategoryID : 0
         * isValid : true
         * thumbnailImgPath : string
         * description : string
         * machineAddress : string
         */

        private int id;
        private String productNumber;
        private String productName;
        private int fK_ProductCategoryID;
        private boolean isValid;
        private String thumbnailImgPath;
        private String description;
        private String machineAddress;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMachineAddress() {
            return machineAddress;
        }

        public void setMachineAddress(String machineAddress) {
            this.machineAddress = machineAddress;
        }
    }
}
