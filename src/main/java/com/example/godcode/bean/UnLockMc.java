package com.example.godcode.bean;

public class UnLockMc {


    /**
     * userID : 0
     * mcProductNumber : string
     * currentProfit : string
     * verifyCode : string
     * runTime : string
     * isUnlock : string
     */

    private int userID;
    private String mcProductNumber;
    private String currentProfit;
    private String verifyCode;
    private String runTime;
    private String isUnlock;
    private String GameGrade;
    private String CurrencyValue;


    public String getCurrencyValue() {
        return CurrencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        CurrencyValue = currencyValue;
    }

    public String getGameGrade() {
        return GameGrade;
    }

    public void setGameGrade(String gameGrade) {
        GameGrade = gameGrade;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMcProductNumber() {
        return mcProductNumber;
    }

    public void setMcProductNumber(String mcProductNumber) {
        this.mcProductNumber = mcProductNumber;
    }

    public String getCurrentProfit() {
        return currentProfit;
    }

    public void setCurrentProfit(String currentProfit) {
        this.currentProfit = currentProfit;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getIsUnlock() {
        return isUnlock;
    }

    public void setIsUnlock(String isUnlock) {
        this.isUnlock = isUnlock;
    }
}
