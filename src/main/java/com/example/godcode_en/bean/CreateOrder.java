package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/17.
 */

public class CreateOrder {


    /**
     * fK_ProductID : 20
     * feeType : CNY
     * sumOrder : 20
     * fK_UserID : 12
     */

    private int fK_ProductID;
    private String feeType;
    private double sumOrder;
    private int fK_UserID;
    private Integer coinCount;

    public Integer getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Integer coinCount) {
        this.coinCount = coinCount;
    }

    public int getFK_ProductID() {
        return fK_ProductID;
    }

    public void setFK_ProductID(int fK_ProductID) {
        this.fK_ProductID = fK_ProductID;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public double getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(double sumOrder) {
        this.sumOrder = sumOrder;
    }

    public int getFK_UserID() {
        return fK_UserID;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }
}
