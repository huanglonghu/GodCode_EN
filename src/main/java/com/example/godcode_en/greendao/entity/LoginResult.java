package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class LoginResult {
    private String uniquenessToken;
    private String payUrl;
    private int userId;
    @Generated(hash = 948762732)
    public LoginResult(String uniquenessToken, String payUrl, int userId) {
        this.uniquenessToken = uniquenessToken;
        this.payUrl = payUrl;
        this.userId = userId;
    }
    @Generated(hash = 203142327)
    public LoginResult() {
    }
    public String getUniquenessToken() {
        return this.uniquenessToken;
    }
    public void setUniquenessToken(String uniquenessToken) {
        this.uniquenessToken = uniquenessToken;
    }
    public String getPayUrl() {
        return this.payUrl;
    }
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
