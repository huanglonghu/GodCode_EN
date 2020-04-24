package com.example.godcode.bean;

public class ProductSetting {


    /**
     * result : {"id":249,"fK_ProductID":450,"volume":0,"award":0,"coinPlay":0,"productSettingType":0,"isFreePlay":1,"businessType":0,"isBuy":0,"isMulti":0,"isGameModel":0,"gameType":0,"isAttempt":0,"isMaking":0,"buyLimit":0}
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
         * id : 249
         * fK_ProductID : 450
         * volume : 0
         * award : 0
         * coinPlay : 0
         * productSettingType : 0
         * isFreePlay : 1
         * businessType : 0
         * isBuy : 0
         * isMulti : 0
         * isGameModel : 0
         * gameType : 0
         * isAttempt : 0
         * isMaking : 0
         * buyLimit : 0
         */

        private Integer id;
        private int fK_ProductID;
        private int volume;
        private int award;
        private int coinPlay;
        private int productSettingType;
        private int freePlayType;
        private int businessType;
        private int isBuy;
        private int isMulti;
        private int isGameModel;
        private int gameType;
        private int isAttempt;
        private int isMaking;
        private int buyLimit;
        private double publicNoPrice;
        private Integer freePlayCount;


        public Integer getFreePlayCount() {
            return freePlayCount;
        }

        public void setFreePlayCount(Integer freePlayCount) {
            this.freePlayCount = freePlayCount;
        }

        public double getPublicNoPrice() {
            return publicNoPrice;
        }

        public void setPublicNoPrice(double publicNoPrice) {
            this.publicNoPrice = publicNoPrice;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public int getFK_ProductID() {
            return fK_ProductID;
        }

        public void setFK_ProductID(int fK_ProductID) {
            this.fK_ProductID = fK_ProductID;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getAward() {
            return award;
        }

        public void setAward(int award) {
            this.award = award;
        }

        public int getCoinPlay() {
            return coinPlay;
        }

        public void setCoinPlay(int coinPlay) {
            this.coinPlay = coinPlay;
        }

        public int getProductSettingType() {
            return productSettingType;
        }

        public void setProductSettingType(int productSettingType) {
            this.productSettingType = productSettingType;
        }

        public int getFreePlayType() {
            return freePlayType;
        }

        public void setFreePlayType(int freePlayType) {
            this.freePlayType = freePlayType;
        }

        public int getBusinessType() {
            return businessType;
        }

        public void setBusinessType(int businessType) {
            this.businessType = businessType;
        }

        public int getIsBuy() {
            return isBuy;
        }

        public void setIsBuy(int isBuy) {
            this.isBuy = isBuy;
        }

        public int getIsMulti() {
            return isMulti;
        }

        public void setIsMulti(int isMulti) {
            this.isMulti = isMulti;
        }

        public int getIsGameModel() {
            return isGameModel;
        }

        public void setIsGameModel(int isGameModel) {
            this.isGameModel = isGameModel;
        }

        public int getGameType() {
            return gameType;
        }

        public void setGameType(int gameType) {
            this.gameType = gameType;
        }

        public int getIsAttempt() {
            return isAttempt;
        }

        public void setIsAttempt(int isAttempt) {
            this.isAttempt = isAttempt;
        }

        public int getIsMaking() {
            return isMaking;
        }

        public void setIsMaking(int isMaking) {
            this.isMaking = isMaking;
        }

        public int getBuyLimit() {
            return buyLimit;
        }

        public void setBuyLimit(int buyLimit) {
            this.buyLimit = buyLimit;
        }
    }
}
