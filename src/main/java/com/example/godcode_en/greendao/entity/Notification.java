package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/8/1.
 */
@Entity
public class Notification {
    @Id
    private Long id;
    private String content;
    private String date;
    private int userId;
    private int transactionType;
    private int relatedKey;
    private int transactionId;
    private int type;
    private String title;
    @Generated(hash = 1528255257)
    public Notification(Long id, String content, String date, int userId,
            int transactionType, int relatedKey, int transactionId, int type,
            String title) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.userId = userId;
        this.transactionType = transactionType;
        this.relatedKey = relatedKey;
        this.transactionId = transactionId;
        this.type = type;
        this.title = title;
    }
    @Generated(hash = 1855225820)
    public Notification() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getTransactionType() {
        return this.transactionType;
    }
    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }
    public int getRelatedKey() {
        return this.relatedKey;
    }
    public void setRelatedKey(int relatedKey) {
        this.relatedKey = relatedKey;
    }
    public int getTransactionId() {
        return this.transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }




}
