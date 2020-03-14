package com.example.godcode.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Friend {

    @Id(autoincrement = true)
    private Long id;//主键  自增长
    private String userName;
    private int userId;
    private int friendId;
    private String area;
    private String headImageUrl;
    private int id_;
    private String syNum;
    private String firstChar;
    @Generated(hash = 1963090376)
    public Friend(Long id, String userName, int userId, int friendId, String area,
            String headImageUrl, int id_, String syNum, String firstChar) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.friendId = friendId;
        this.area = area;
        this.headImageUrl = headImageUrl;
        this.id_ = id_;
        this.syNum = syNum;
        this.firstChar = firstChar;
    }
    @Generated(hash = 287143722)
    public Friend() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getFriendId() {
        return this.friendId;
    }
    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
    public String getArea() {
        return this.area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getHeadImageUrl() {
        return this.headImageUrl;
    }
    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }
    public int getId_() {
        return this.id_;
    }
    public void setId_(int id_) {
        this.id_ = id_;
    }
    public String getSyNum() {
        return this.syNum;
    }
    public void setSyNum(String syNum) {
        this.syNum = syNum;
    }
    public String getFirstChar() {
        return this.firstChar;
    }
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }


}
