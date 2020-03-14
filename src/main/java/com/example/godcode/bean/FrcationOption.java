package com.example.godcode.bean;

public class FrcationOption {


    /**
     * mcFractionRecordID : 0
     * userID : 0
     * changeFraction : 0
     * isConcur : true
     */

    private int mcFractionRecordID;
    private int userID;
    private Integer changeFraction;         //申请积分需要传
    private boolean isConcur;

    public int getMcFractionRecordID() {
        return mcFractionRecordID;
    }

    public void setMcFractionRecordID(int mcFractionRecordID) {
        this.mcFractionRecordID = mcFractionRecordID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getChangeFraction() {
        return changeFraction;
    }

    public void setChangeFraction(int changeFraction) {
        this.changeFraction = changeFraction;
    }

    public boolean isIsConcur() {
        return isConcur;
    }

    public void setIsConcur(boolean isConcur) {
        this.isConcur = isConcur;
    }
}
