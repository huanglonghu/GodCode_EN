package com.example.godcode_en.bean;

import java.util.List;

public class BatchSettingBody {


    /**
     * fK_ProductID : 0
     * fK_PresentID : 0
     * commodityRoadNumberList : [0]
     * commodityName : string
     * isEnable : 0
     * presentName : string
     * presentImgUrl : string
     * gamePrice : 0
     * sellPrice : 0
     * costPrice : 0
     * probability : 0
     * stock : 0
     */

    private int fK_ProductID;
    private String fK_PresentID;
    private String commodityName;
    private String isEnable;
    private String presentName;
    private String presentImgUrl;
    private String gamePrice;
    private String sellPrice;
    private String costPrice;
    private String probability;
    private String stock;
    private List<Integer> commodityRoadNumberList;

    public int getFK_ProductID() {
        return fK_ProductID;
    }

    public void setFK_ProductID(int fK_ProductID) {
        this.fK_ProductID = fK_ProductID;
    }

    public String getFK_PresentID() {
        return fK_PresentID;
    }

    public void setFK_PresentID(String fK_PresentID) {
        this.fK_PresentID = fK_PresentID;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getPresentName() {
        return presentName;
    }

    public void setPresentName(String presentName) {
        this.presentName = presentName;
    }

    public String getPresentImgUrl() {
        return presentImgUrl;
    }

    public void setPresentImgUrl(String presentImgUrl) {
        this.presentImgUrl = presentImgUrl;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(String gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public List<Integer> getCommodityRoadNumberList() {
        return commodityRoadNumberList;
    }

    public void setCommodityRoadNumberList(List<Integer> commodityRoadNumberList) {
        this.commodityRoadNumberList = commodityRoadNumberList;
    }
}
