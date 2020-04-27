package com.example.godcode_en.bean;

public class PackageItem {
    /**
     * id : 0
     * fK_UserID : 0
     * fK_ProductCategoryID : 0
     * price : 0
     * coinCount : 0
     */

    private Integer id;
    private int fK_UserID;
    private int fK_ProductCategoryID;
    private Integer price;
    private Integer coinCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFK_UserID() {
        return fK_UserID;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }

    public int getFK_ProductCategoryID() {
        return fK_ProductCategoryID;
    }

    public void setFK_ProductCategoryID(int fK_ProductCategoryID) {
        this.fK_ProductCategoryID = fK_ProductCategoryID;
    }

    public Integer getPrice() {
        if (price == null) {
            return 0;
        }
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCoinCount() {
        if (coinCount == null) {
            return 0;
        }
        return coinCount;
    }

    public void setCoinCount(Integer coinCount) {
        this.coinCount = coinCount;
    }
}
