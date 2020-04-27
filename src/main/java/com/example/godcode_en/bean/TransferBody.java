package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/3.
 */

public class TransferBody {

    /**
     * userID : 12
     * encryptStr : string
     */

    private int userID;
    private String encryptStr;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEncryptStr() {
        return encryptStr;
    }

    public void setEncryptStr(String encryptStr) {
        this.encryptStr = encryptStr;
    }
}
