package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/5.
 */

public class AddBankCard {


    /**
     * fK_UserID : 0
     * bankID : 0
     * bankName : string
     * bankNumber : 0
     * mobile : string
     * bankCardNumber : string
     * area : string
     * network : string
     */

    private int fK_UserID;
    private String bankName;
    private String mobile;
    private String bankCardNumber;
    private String area;
    private String network;
    private String AccountName;

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public int getFK_UserID() {
        return fK_UserID;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}
