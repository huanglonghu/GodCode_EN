package com.example.godcode.bean;

public class ResetPwdBean {


    /**
     * userID : 0
     * phoneNumberOrEmail : string
     * newPayPassword : string
     * verificationCode : string
     */

    private int userID;
    private int verificationCodeType;
    private String newPayPassword;
    private String verificationCode;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getVerificationCodeType() {
        return verificationCodeType;
    }

    public void setVerificationCodeType(int verificationCodeType) {
        this.verificationCodeType = verificationCodeType;
    }

    public String getNewPayPassword() {
        return newPayPassword;
    }

    public void setNewPayPassword(String newPayPassword) {
        this.newPayPassword = newPayPassword;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
