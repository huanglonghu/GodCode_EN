package com.example.godcode_en.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/25.
 */

public class BindProduct {

    /**
     * fK_UserID : 0
     * productNumber : string
     * machineAddress : string
     * isBind : true
     * productName : string
     * fK_ProductCategoryID : 0
     * description : string
     * price : 0
     * commodityRoadCount : 0
     * commodityRoad : {"fK_ProductID":0,"commodityRoad":[{"id":0,"commodityRoadNumber":0,"fK_PresentID":0,"sellPrice":0,"gamePrice":0,"probability":0,"currentStocks":0,"capacity":0}]}
     * productPackageSetting : [{"productPackageSetting":{"id":0,"fK_ProductID":0,"fK_PackageID":0}}]
     * isFreePlay : 0
     */

    /**
     * fK_UserID : 0
     * productNumber : string
     * machineAddress : string
     * isBind : true
     * productName : string
     * fK_ProductCategoryID : 0
     * description : string
     * price : 0
     * commodityRoad : {"fK_ProductID":0,"commodityRoad":[{"id":0,"commodityRoadNumber":0,"fK_PresentID":0,"sellPrice":0,"gamePrice":0,"probability":0,"currentStocks":0,"capacity":0}]}
     */

    private int fK_UserID;
    private String productNumber;
    private String machineAddress;
    private boolean isBind;
    private String productName;
    private int fK_ProductCategoryID;
    private String description;
    private String price;
    private Integer commodityRoadCount;
    private CommodityRoadBeanX commodityRoad;

    public int getFK_UserID() {
        return fK_UserID;
    }

    public int getCommodityRoadCount() {
        return commodityRoadCount;
    }

    public void setCommodityRoadCount(int commodityRoadCount) {
        this.commodityRoadCount = commodityRoadCount;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getMachineAddress() {
        return machineAddress;
    }

    public void setMachineAddress(String machineAddress) {
        this.machineAddress = machineAddress;
    }

    public boolean isIsBind() {
        return isBind;
    }

    public void setIsBind(boolean isBind) {
        this.isBind = isBind;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CommodityRoadBeanX getCommodityRoad() {
        return commodityRoad;
    }

    public void setCommodityRoad(CommodityRoadBeanX commodityRoad) {
        this.commodityRoad = commodityRoad;
    }


    public static class CommodityRoadBeanX {
        /**
         * fK_ProductID : 0
         * commodityRoad : [{"id":0,"commodityRoadNumber":0,"fK_PresentID":0,"sellPrice":0,"gamePrice":0,"probability":0,"currentStocks":0,"capacity":0}]
         */
        private String fK_ProductID;
        private List<CommodityRoadBean> commodityRoad;

        public String getFK_ProductID() {
            return fK_ProductID;
        }

        public void setFK_ProductID(String fK_ProductID) {
            this.fK_ProductID = fK_ProductID;
        }

        public List<CommodityRoadBean> getCommodityRoad() {
            return commodityRoad;
        }

        public void setCommodityRoad(List<CommodityRoadBean> commodityRoad) {
            this.commodityRoad = commodityRoad;
        }

        public static class CommodityRoadBean {
            /**
             * id : 0
             * commodityRoadNumber : 0
             * fK_PresentID : 0
             * sellPrice : 0
             * gamePrice : 0
             * probability : 0
             * currentStocks : 0
             * capacity : 0
             */

            private String id;
            private int commodityRoadNumber;
            private int fK_PresentID;
            private String sellPrice;
            private String gamePrice;
            private String probability;
            private String currentStocks;
            private String capacity;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getCommodityRoadNumber() {
                return commodityRoadNumber;
            }

            public void setCommodityRoadNumber(int commodityRoadNumber) {
                this.commodityRoadNumber = commodityRoadNumber;
            }

            public int getFK_PresentID() {
                return fK_PresentID;
            }

            public void setFK_PresentID(int fK_PresentID) {
                this.fK_PresentID = fK_PresentID;
            }

            public String getSellPrice() {
                if (sellPrice == null) {
                    return "";
                }
                return sellPrice;
            }

            public void setSellPrice(String sellPrice) {
                this.sellPrice = sellPrice;
            }

            public String getGamePrice() {
                if (gamePrice == null) {
                    return "";
                }
                return gamePrice;
            }

            public void setGamePrice(String gamePrice) {
                this.gamePrice = gamePrice;
            }

            public String getProbability() {
                if (probability == null) {
                    return "";
                }
                return probability;
            }

            public void setProbability(String probability) {
                this.probability = probability;
            }

            public String getCurrentStocks() {
                if (currentStocks == null) {
                    return "";
                }
                return currentStocks;
            }

            public void setCurrentStocks(String currentStocks) {
                this.currentStocks = currentStocks;
            }

            public String getCapacity() {
                if (capacity == null) {
                    return "";
                }
                return capacity;
            }

            public void setCapacity(String capacity) {
                this.capacity = capacity;
            }
        }
    }


    private Integer isFreePlay;
    private List<ProductPackageSettingBeanX> productPackageSetting;




    public int getIsFreePlay() {
        return isFreePlay;
    }

    public void setIsFreePlay(int isFreePlay) {
        this.isFreePlay = isFreePlay;
    }

    public List<ProductPackageSettingBeanX> getProductPackageSetting() {
        return productPackageSetting;
    }

    public void setProductPackageSetting(List<ProductPackageSettingBeanX> productPackageSetting) {
        this.productPackageSetting = productPackageSetting;
    }



    public static class ProductPackageSettingBeanX {
        /**
         * productPackageSetting : {"id":0,"fK_ProductID":0,"fK_PackageID":0}
         */

        private ProductPackageSettingBean productPackageSetting;

        public ProductPackageSettingBean getProductPackageSetting() {
            return productPackageSetting;
        }

        public void setProductPackageSetting(ProductPackageSettingBean productPackageSetting) {
            this.productPackageSetting = productPackageSetting;
        }

    }
}
