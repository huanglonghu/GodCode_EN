package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class TransationName {
    private String transationName;
    private String transationId;
    @Generated(hash = 15022028)
    public TransationName(String transationName, String transationId) {
        this.transationName = transationName;
        this.transationId = transationId;
    }
    @Generated(hash = 804894396)
    public TransationName() {
    }
    public String getTransationName() {
        return this.transationName;
    }
    public void setTransationName(String transationName) {
        this.transationName = transationName;
    }
    public String getTransationId() {
        return this.transationId;
    }
    public void setTransationId(String transationId) {
        this.transationId = transationId;
    }
}
