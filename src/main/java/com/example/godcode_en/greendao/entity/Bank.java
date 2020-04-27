package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bank {
    @Id
    private int id;
    private String bankNumber;
    private String bankName;
    private int bankType;
    private int userId;
    @Generated(hash = 423926733)
    public Bank(int id, String bankNumber, String bankName, int bankType,
            int userId) {
        this.id = id;
        this.bankNumber = bankNumber;
        this.bankName = bankName;
        this.bankType = bankType;
        this.userId = userId;
    }
    @Generated(hash = 1130656975)
    public Bank() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBankNumber() {
        return this.bankNumber;
    }
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }
    public String getBankName() {
        return this.bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public int getBankType() {
        return this.bankType;
    }
    public void setBankType(int bankType) {
        this.bankType = bankType;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
