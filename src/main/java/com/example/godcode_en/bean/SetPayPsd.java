package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/2.
 */

public class SetPayPsd {


    /**
     * fK_UserID : 0
     * payPass : string
     */

    private int fK_UserID;
    private String payPass;

    public int getFK_UserID() {
        return fK_UserID;
    }

    public void setFK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }

    public String getPayPass() {
        return payPass;
    }

    public void setPayPass(String payPass) {
        this.payPass = payPass;
    }
}
