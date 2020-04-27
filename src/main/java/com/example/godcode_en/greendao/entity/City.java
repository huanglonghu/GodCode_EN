package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/8/9.
 */

@Entity(nameInDb = "T_City", createInDb = false)
public class City {
    @Property(nameInDb = "CitySort")
    @Id(autoincrement = true)
    private long citySort;
    @Property(nameInDb = "ProID")
    private int proId;
    @Property(nameInDb = "CityName")
    private String cityName;
    @Generated(hash = 1900800873)
    public City(long citySort, int proId, String cityName) {
        this.citySort = citySort;
        this.proId = proId;
        this.cityName = cityName;
    }
    @Generated(hash = 750791287)
    public City() {
    }
    public long getCitySort() {
        return this.citySort;
    }
    public void setCitySort(long citySort) {
        this.citySort = citySort;
    }
    public int getProId() {
        return this.proId;
    }
    public void setProId(int proId) {
        this.proId = proId;
    }
    public String getCityName() {
        return this.cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}