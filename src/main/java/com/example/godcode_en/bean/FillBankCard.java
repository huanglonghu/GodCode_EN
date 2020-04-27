package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/6.
 */

public class FillBankCard {

    /**
     * fK_UserID : 0
     * bankID : 0
     * bankName : string
     * bankNumber : 0
     * mobile : string
     * bankCardNumber : string
     */

    private int fK_UserID;
    private int bankID;
    private String bankName;
    private int bankNumber;
    private String mobile;
    private String bankCardNumber;

    public int getFK_UserID() {
        return fK_UserID;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
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
}
