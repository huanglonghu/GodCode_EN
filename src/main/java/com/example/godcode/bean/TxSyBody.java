package com.example.godcode.bean;

public class TxSyBody {


    /**
     * stratTime : 2019-09-19T08:51:55.968Z
     * endTime : 2019-09-19T08:51:55.968Z
     * userID : 0
     * page : 0
     * limit : 0
     */

    private String stratTime;
    private String endTime;
    private int userID;
    private int page;
    private int limit;

    public String getStratTime() {
        return stratTime;
    }

    public void setStratTime(String stratTime) {
        this.stratTime = stratTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
