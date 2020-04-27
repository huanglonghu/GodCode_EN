package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/10/31.
 */
@Entity
public class VersionMsg {
    private String versionCode;
    private String versionDes;
    @Generated(hash = 157486909)
    public VersionMsg(String versionCode, String versionDes) {
        this.versionCode = versionCode;
        this.versionDes = versionDes;
    }
    @Generated(hash = 674742834)
    public VersionMsg() {
    }
    public String getVersionCode() {
        return this.versionCode;
    }
    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
    public String getVersionDes() {
        return this.versionDes;
    }
    public void setVersionDes(String versionDes) {
        this.versionDes = versionDes;
    }

    
}
