package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/8/9.
 */
@Entity(nameInDb = "T_Province", createInDb = false)
public class Province {
    @Property(nameInDb = "ProSort")
    private int proSort;
    @Property(nameInDb = "ProName")
    private String proName;

    @Property(nameInDb = "ProRemark")
    private String proRemark;

    @Generated(hash = 890005525)
    public Province(int proSort, String proName, String proRemark) {
        this.proSort = proSort;
        this.proName = proName;
        this.proRemark = proRemark;
    }

    @Generated(hash = 1309009906)
    public Province() {
    }

    public int getProSort() {
        return this.proSort;
    }

    public void setProSort(int proSort) {
        this.proSort = proSort;
    }

    public String getProName() {
        return this.proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProRemark() {
        return this.proRemark;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark;
    }



}
