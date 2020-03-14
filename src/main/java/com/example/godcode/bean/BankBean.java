package com.example.godcode.bean;

public class BankBean {

    private String lastfourNum;

    private int bankIconRes;

    private String bankName;

    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastfourNum() {
        return lastfourNum;
    }

    public void setLastfourNum(String lastfourNum) {
        this.lastfourNum = lastfourNum;
    }

    public int getBankIconRes() {
        return bankIconRes;
    }

    public void setBankIconRes(int bankIconRes) {
        this.bankIconRes = bankIconRes;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
