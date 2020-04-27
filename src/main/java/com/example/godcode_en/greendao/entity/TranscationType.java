package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/7/30.
 */
@Entity
public class TranscationType {
    private String transationName;
    private String transationId;
    @Generated(hash = 1103454047)
    public TranscationType(String transationName, String transationId) {
        this.transationName = transationName;
        this.transationId = transationId;
    }
    @Generated(hash = 1432559582)
    public TranscationType() {
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
