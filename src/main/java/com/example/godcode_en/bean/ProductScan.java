package com.example.godcode_en.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */

public class ProductScan implements Serializable{


    /**
     * result : {"productNumber":"SY265","productName":"东华测试","isValid":true,"thumbnailImgPath":"/Files/Pictures/ProductType/bb70557b-5306-4159-8e0a-810900171f69.png","money":1,"isBind":true,"errContext":null,"isFreePlay":1,"productPackageList":[{"fK_ProductID":450,"fK_PackageID":36,"price":2,"coinCount":2,"id":38},{"fK_ProductID":450,"fK_PackageID":41,"price":5,"coinCount":5,"id":39},{"fK_ProductID":450,"fK_PackageID":39,"price":6,"coinCount":6,"id":40}],"id":450}
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

    public static class ResultBean implements Serializable {
        /**
         * productNumber : SY265
         * productName : 东华测试
         * isValid : true
         * thumbnailImgPath : /Files/Pictures/ProductType/bb70557b-5306-4159-8e0a-810900171f69.png
         * money : 1.0
         * isBind : true
         * errContext : null
         * isFreePlay : 1
         * productPackageList : [{"fK_ProductID":450,"fK_PackageID":36,"price":2,"coinCount":2,"id":38},{"fK_ProductID":450,"fK_PackageID":41,"price":5,"coinCount":5,"id":39},{"fK_ProductID":450,"fK_PackageID":39,"price":6,"coinCount":6,"id":40}]
         * id : 450
         */

        private String productNumber;
        private String productName;
        private boolean isValid;
        private String thumbnailImgPath;
        private double money;
        private boolean isBind;
        private String errContext;
        private int isFreePlay;
        private int id;
        private List<ProductPackageListBean> productPackageList;

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

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public boolean isIsBind() {
            return isBind;
        }

        public void setIsBind(boolean isBind) {
            this.isBind = isBind;
        }

        public String getErrContext() {
            return errContext;
        }

        public void setErrContext(String errContext) {
            this.errContext = errContext;
        }

        public int getIsFreePlay() {
            return isFreePlay;
        }

        public void setIsFreePlay(int isFreePlay) {
            this.isFreePlay = isFreePlay;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<ProductPackageListBean> getProductPackageList() {
            return productPackageList;
        }

        public void setProductPackageList(List<ProductPackageListBean> productPackageList) {
            this.productPackageList = productPackageList;
        }

        public static class ProductPackageListBean {
            /**
             * fK_ProductID : 450
             * fK_PackageID : 36
             * price : 2.0
             * coinCount : 2
             * id : 38
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
}
