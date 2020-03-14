package com.example.godcode.bean;


import com.example.godcode.utils.FormatUtil;
import com.umeng.commonsdk.debug.D;

import java.io.Serializable;
import java.util.List;

public class MyAssetList {

    /**
     * result : {"normalCount":0,"errorCount":2,"dividedMoney":0,"coinCount":0,"count":2,"data":[{"fK_UserID":40,"userName":"122828","nickName":"ifelse","friendNickName":null,"fK_ProductID":64,"productCategoryID":2,"productCategory":"摇摆机","productName":"c","machineAddress":"cc","isValid":false,"productImgUrl":"/Files/Pictures/ProductType/a6dfd0dc-9e8d-4515-8d84-fc5c9d2c94cd.jpg","isBind":true,"bindTime":"2018-10-15T15:45:28.0612662","bindOutTime":null,"lastStopTime":null,"fK_UserIDOperation":11,"productNumber":"jq","price":1,"fK_PriceID":64,"scanCodeIncome":0,"divideIncome":0,"todayCoin":0,"todayBanknote":0,"divideRate":90,"primaevalUserID":11,"parentID":"11","id":66},{"fK_UserID":11,"userName":"108075","nickName":"穷开心","friendNickName":null,"fK_ProductID":68,"productCategoryID":4,"productCategory":"咖啡机","productName":"cd","machineAddress":"CCB","isValid":false,"productImgUrl":"/Files/Pictures/ProductType/ff09e6a0-671d-4efd-9ab7-37a9208eb996.jpg","isBind":true,"bindTime":"2018-10-16T10:44:51.3824005","bindOutTime":null,"lastStopTime":null,"fK_UserIDOperation":11,"productNumber":"jz","price":1,"fK_PriceID":68,"scanCodeIncome":0,"divideIncome":0,"todayCoin":0,"todayBanknote":0,"divideRate":93,"primaevalUserID":11,"parentID":null,"id":70}]}
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
         * normalCount : 0
         * errorCount : 2
         * dividedMoney : 0.0
         * coinCount : 0.0
         * count : 2
         * data : [{"fK_UserID":40,"userName":"122828","nickName":"ifelse","friendNickName":null,"fK_ProductID":64,"productCategoryID":2,"productCategory":"摇摆机","productName":"c","machineAddress":"cc","isValid":false,"productImgUrl":"/Files/Pictures/ProductType/a6dfd0dc-9e8d-4515-8d84-fc5c9d2c94cd.jpg","isBind":true,"bindTime":"2018-10-15T15:45:28.0612662","bindOutTime":null,"lastStopTime":null,"fK_UserIDOperation":11,"productNumber":"jq","price":1,"fK_PriceID":64,"scanCodeIncome":0,"divideIncome":0,"todayCoin":0,"todayBanknote":0,"divideRate":90,"primaevalUserID":11,"parentID":"11","id":66},{"fK_UserID":11,"userName":"108075","nickName":"穷开心","friendNickName":null,"fK_ProductID":68,"productCategoryID":4,"productCategory":"咖啡机","productName":"cd","machineAddress":"CCB","isValid":false,"productImgUrl":"/Files/Pictures/ProductType/ff09e6a0-671d-4efd-9ab7-37a9208eb996.jpg","isBind":true,"bindTime":"2018-10-16T10:44:51.3824005","bindOutTime":null,"lastStopTime":null,"fK_UserIDOperation":11,"productNumber":"jz","price":1,"fK_PriceID":68,"scanCodeIncome":0,"divideIncome":0,"todayCoin":0,"todayBanknote":0,"divideRate":93,"primaevalUserID":11,"parentID":null,"id":70}]
         */

        private int normalCount;
        private int errorCount;
        private double dividedMoney;
        private int coinCount;
        private int count;
        private int sumAwardCount;
        private double paperCoinCount;
        private double coinDividedMoney;
        private List<DataBean> data;

        public double getPaperCoinCount() {
            return paperCoinCount;
        }

        public void setPaperCoinCount(double paperCoinCount) {
            this.paperCoinCount = paperCoinCount;
        }

        public double getCoinDividedMoney() {
            return coinDividedMoney;
        }

        public void setCoinDividedMoney(double coinDividedMoney) {
            this.coinDividedMoney = coinDividedMoney;
        }

        public int getSumAwardCount() {
            return sumAwardCount;
        }

        public void setSumAwardCount(int sumAwardCount) {
            this.sumAwardCount = sumAwardCount;
        }

        public int getNormalCount() {
            return normalCount;
        }

        public void setNormalCount(int normalCount) {
            this.normalCount = normalCount;
        }

        public int getErrorCount() {
            return errorCount;
        }

        public void setErrorCount(int errorCount) {
            this.errorCount = errorCount;
        }

        public double getDividedMoney() {
            return dividedMoney;
        }

        public void setDividedMoney(double dividedMoney) {
            this.dividedMoney = dividedMoney;
        }

        public int getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(int coinCount) {
            this.coinCount = coinCount;
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

        public static class DataBean implements Serializable {
            /**
             * fK_UserID : 40
             * userName : 122828
             * nickName : ifelse
             * friendNickName : null
             * fK_ProductID : 64
             * productCategoryID : 2
             * productCategory : 摇摆机
             * productName : c
             * machineAddress : cc
             * isValid : false
             * productImgUrl : /Files/Pictures/ProductType/a6dfd0dc-9e8d-4515-8d84-fc5c9d2c94cd.jpg
             * isBind : true
             * bindTime : 2018-10-15T15:45:28.0612662
             * bindOutTime : null
             * lastStopTime : null
             * fK_UserIDOperation : 11
             * productNumber : jq
             * price : 1.0
             * fK_PriceID : 64
             * scanCodeIncome : 0.0
             * divideIncome : 0.0
             * todayCoin : 0.0
             * todayBanknote : 0.0
             * divideRate : 90
             * primaevalUserID : 11
             * parentID : 11
             * id : 66
             */

            private int fK_UserID;
            private String userName;
            private String nickName;
            private Object friendNickName;
            private int fK_ProductID;
            private int productCategoryID;
            private String productCategory;
            private String productName;
            private String machineAddress;
            private boolean isValid;
            private String productImgUrl;
            private boolean isBind;
            private String bindTime;
            private Object bindOutTime;
            private Object lastStopTime;
            private int fK_UserIDOperation;
            private String productNumber;
            private double price;
            private int fK_PriceID;
            private Double scanCodeIncome;
            private Double divideIncome;
            private Integer todayCoin;
            private Integer todayBanknote;
            private Integer todayAwardCount;
            private int divideRate;
            private int primaevalUserID;
            private String parentID;
            private boolean isPenetrate;
            private int id;
            private int commodityRoadCount;
            private int currentStock;
            private int sumStock;
            private double coinDivideIncome;

            public double getCoinDivideIncome() {
                return coinDivideIncome;
            }

            public void setCoinDivideIncome(double coinDivideIncome) {
                this.coinDivideIncome = coinDivideIncome;
            }

            public int getCurrentStock() {
                return currentStock;
            }

            public void setCurrentStock(int currentStock) {
                this.currentStock = currentStock;
            }

            public int getSumStock() {
                return sumStock;
            }

            public void setSumStock(int sumStock) {
                this.sumStock = sumStock;
            }

            public int getCommodityRoadCount() {
                return commodityRoadCount;
            }

            public void setCommodityRoadCount(int commodityRoadCount) {
                this.commodityRoadCount = commodityRoadCount;
            }

            public boolean isPenetrate() {
                return isPenetrate;
            }

            public void setPenetrate(boolean penetrate) {
                isPenetrate = penetrate;
            }

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public Object getFriendNickName() {
                return friendNickName;
            }

            public void setFriendNickName(Object friendNickName) {
                this.friendNickName = friendNickName;
            }


            public Integer getTodayAwardCount() {
                return todayAwardCount;
            }

            public void setTodayAwardCount(Integer todayAwardCount) {
                this.todayAwardCount = todayAwardCount;
            }

            public int getFK_ProductID() {
                return fK_ProductID;
            }

            public void setFK_ProductID(int fK_ProductID) {
                this.fK_ProductID = fK_ProductID;
            }

            public int getProductCategoryID() {
                return productCategoryID;
            }

            public void setProductCategoryID(int productCategoryID) {
                this.productCategoryID = productCategoryID;
            }

            public String getProductCategory() {
                return productCategory;
            }

            public void setProductCategory(String productCategory) {
                this.productCategory = productCategory;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getMachineAddress() {
                return machineAddress;
            }

            public void setMachineAddress(String machineAddress) {
                this.machineAddress = machineAddress;
            }

            public boolean isIsValid() {
                return isValid;
            }

            public void setIsValid(boolean isValid) {
                this.isValid = isValid;
            }

            public String getProductImgUrl() {
                return productImgUrl;
            }

            public void setProductImgUrl(String productImgUrl) {
                this.productImgUrl = productImgUrl;
            }

            public boolean isIsBind() {
                return isBind;
            }

            public void setIsBind(boolean isBind) {
                this.isBind = isBind;
            }

            public String getBindTime() {
                return bindTime;
            }

            public void setBindTime(String bindTime) {
                this.bindTime = bindTime;
            }

            public Object getBindOutTime() {
                return bindOutTime;
            }

            public void setBindOutTime(Object bindOutTime) {
                this.bindOutTime = bindOutTime;
            }

            public Object getLastStopTime() {
                return lastStopTime;
            }

            public void setLastStopTime(Object lastStopTime) {
                this.lastStopTime = lastStopTime;
            }

            public int getFK_UserIDOperation() {
                return fK_UserIDOperation;
            }

            public void setFK_UserIDOperation(int fK_UserIDOperation) {
                this.fK_UserIDOperation = fK_UserIDOperation;
            }

            public String getProductNumber() {
                return productNumber;
            }

            public void setProductNumber(String productNumber) {
                this.productNumber = productNumber;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getFK_PriceID() {
                return fK_PriceID;
            }

            public void setFK_PriceID(int fK_PriceID) {
                this.fK_PriceID = fK_PriceID;
            }

            public String getScanCodeIncome() {
                String aDouble = null;
                if (scanCodeIncome != null) {
                    aDouble = FormatUtil.getInstance().get2double(scanCodeIncome);
                }
                return aDouble;
            }

            public void setScanCodeIncome(Double scanCodeIncome) {
                this.scanCodeIncome = scanCodeIncome;
            }

            public String getDivideIncome() {
                String aDouble = null;
                if (divideIncome != null) {
                    aDouble = FormatUtil.getInstance().get2double(divideIncome);
                }
                return aDouble;
            }

            private double adIncome;

            public String getAdIncome() {
                String aDouble = FormatUtil.getInstance().get2double(adIncome);
                return aDouble;
            }

            public void setAdIncome(double adIncome) {
                this.adIncome = adIncome;
            }

            public void setDivideIncome(Double divideIncome) {
                this.divideIncome = divideIncome;
            }

            public Integer getTodayCoin() {
                return todayCoin;
            }

            public void setTodayCoin(Integer todayCoin) {
                this.todayCoin = todayCoin;
            }

            public Integer getTodayBanknote() {
                return todayBanknote;
            }

            public void setTodayBanknote(Integer todayBanknote) {
                this.todayBanknote = todayBanknote;
            }

            public int getDivideRate() {
                return divideRate;
            }

            public void setDivideRate(int divideRate) {
                this.divideRate = divideRate;
            }

            public int getPrimaevalUserID() {
                return primaevalUserID;
            }

            public void setPrimaevalUserID(int primaevalUserID) {
                this.primaevalUserID = primaevalUserID;
            }

            public String getParentID() {
                return parentID;
            }

            public void setParentID(String parentID) {
                this.parentID = parentID;
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
