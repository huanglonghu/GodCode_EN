package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/17.
 */

public class PayByBalance {

    /**
     * payOrderID : 0
     * userID : 0
     * password : string
     */

    private int payOrderID;
    private int userID;
    private String password;

    public int getPayOrderID() {
        return payOrderID;
    }

    public void setPayOrderID(int payOrderID) {
        this.payOrderID = payOrderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
