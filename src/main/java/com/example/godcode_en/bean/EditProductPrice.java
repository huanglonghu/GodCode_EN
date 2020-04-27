package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/6/28.
 */

public class EditProductPrice {


    /**
     * productPrice : {"id":0,"fK_UserID":0,"fK_ProductID":0,"price":0,"isValid":true}
     */

    private ProductPriceBean productPrice;

    public ProductPriceBean getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPriceBean productPrice) {
        this.productPrice = productPrice;
    }

    public static class ProductPriceBean {
        /**
         * id : 0
         * fK_UserID : 0
         * fK_ProductID : 0
         * price : 0
         * isValid : true
         */

        private int id;
        private int fK_UserID;
        private int fK_ProductID;
        private int price;
        private boolean isValid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public int getFK_ProductID() {
            return fK_ProductID;
        }

        public void setFK_ProductID(int fK_ProductID) {
            this.fK_ProductID = fK_ProductID;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }
    }
}
