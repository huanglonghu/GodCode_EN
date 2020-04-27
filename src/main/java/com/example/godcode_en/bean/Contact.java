package com.example.godcode_en.bean;


import java.io.Serializable;

public class Contact implements Serializable{


    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int mType;
    private int Id;
    private String adress;

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    private boolean isFriend;



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Contact() {

    }




}
