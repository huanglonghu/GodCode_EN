package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/8/9.
 */

@Entity(nameInDb = "T_Zone", createInDb = false)
public class Zone {
    @Property(nameInDb = "ZoneId")
    @Id(autoincrement = true)
    private long zoneId;
    @Property(nameInDb = "CityID")
    private int CityId;
    @Property(nameInDb = "ZoneName")
    private String zoneName;
    @Generated(hash = 292924447)
    public Zone(long zoneId, int CityId, String zoneName) {
        this.zoneId = zoneId;
        this.CityId = CityId;
        this.zoneName = zoneName;
    }
    @Generated(hash = 1333518924)
    public Zone() {
    }
    public long getZoneId() {
        return this.zoneId;
    }
    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }
    public int getCityId() {
        return this.CityId;
    }
    public void setCityId(int CityId) {
        this.CityId = CityId;
    }
    public String getZoneName() {
        return this.zoneName;
    }
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
