package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/10/8.
 */

public class ChangePsd {
    private int fK_UserID;
    private String payPass;
    private String OriginalPayPass;

    public int getfK_UserID() {
        return fK_UserID;
    }

    public void setfK_UserID(int fK_UserID) {
        this.fK_UserID = fK_UserID;
    }

    public String getPayPass() {
        return payPass;
    }

    public void setPayPass(String payPass) {
        this.payPass = payPass;
    }

    public String getOriginalPayPass() {
        return OriginalPayPass;
    }

    public void setOriginalPayPass(String originalPayPass) {
        OriginalPayPass = originalPayPass;
    }
}
