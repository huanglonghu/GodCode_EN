package com.example.godcode.bean;

import java.util.List;

public class BatchReturn {

    /**
     * userID : 0
     * mcProductIDList : [0]
     */

    private int userID;
    private List<Integer> mcProductIDList;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<Integer> getMcProductIDList() {
        return mcProductIDList;
    }

    public void setMcProductIDList(List<Integer> mcProductIDList) {
        this.mcProductIDList = mcProductIDList;
    }
}
