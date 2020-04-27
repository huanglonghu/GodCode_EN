package com.example.godcode_en.bean;


public class RevenueDivideItem {
    public int getDivideRate() {
        return divideRate;
    }

    public void setDivideRate(int divideRate) {
        this.divideRate = divideRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private int divideRate;
    private String name;
    private String id;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;

}
