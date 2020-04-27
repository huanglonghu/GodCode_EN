package com.example.godcode_en.bean;

public class PayOrder {
    private int fK_ProductID;
    private String feeType;
    private String orderDate;
    private int sumOrder;
    private int fK_UserID;

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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(int sumOrder) {
        this.sumOrder = sumOrder;
    }

    public int getFK_UserID() {
        return fK_UserID;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }
}
