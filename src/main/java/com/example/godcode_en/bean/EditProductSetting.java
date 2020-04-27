package com.example.godcode_en.bean;

public class EditProductSetting {


    /**
     * productSetting : {"id":0,"fK_ProductID":0,"volume":"string","award":"string","coinPlay":"string","productSettingType":"string","businessType":0,"isBuy":0,"isMulti":0,"isGameModel":0,"gameType":0,"isAttempt":0,"isMaking":0,"buyLimit":0}
     */

    private ProductSettingBean productSetting;

    public ProductSettingBean getProductSetting() {
        return productSetting;
    }

    public void setProductSetting(ProductSettingBean productSetting) {
        this.productSetting = productSetting;
    }

    public static class ProductSettingBean {
        /**
         * id : 0
         * fK_ProductID : 0
         * volume : string
         * award : string
         * coinPlay : string
         * productSettingType : string
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
        private String volume;
        private String award;
        private String coinPlay;
        private String productSettingType;
        private Integer businessType;
        private Integer isBuy;
        private Integer isMulti;
        private Integer isGameModel;
        private Integer gameType;
        private Integer isAttempt;
        private Integer isMaking;
        private Integer buyLimit;
        private Integer freePlayType;
        private Integer freePlayCount;


        public Integer getFreePlayCount() {
            return freePlayCount;
        }

        public void setFreePlayCount(Integer freePlayCount) {
            this.freePlayCount = freePlayCount;
        }

        public Integer getFreePlayType() {
            return freePlayType;
        }

        public void setFreePlayType(Integer freePlayType) {
            this.freePlayType = freePlayType;
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

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getAward() {
            return award;
        }

        public void setAward(String award) {
            this.award = award;
        }

        public String getCoinPlay() {
            return coinPlay;
        }

        public void setCoinPlay(String coinPlay) {
            this.coinPlay = coinPlay;
        }

        public String getProductSettingType() {
            return productSettingType;
        }

        public void setProductSettingType(String productSettingType) {
            this.productSettingType = productSettingType;
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
