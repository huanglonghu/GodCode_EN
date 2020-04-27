package com.example.godcode_en.bean;

public class ProductPackageSettingBean {
    /**
     * id : 0
     * fK_ProductID : 0
     * fK_PackageID : 0
     */

    private Integer id;
    private Integer fK_ProductID;
    private int fK_PackageID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFK_ProductID() {
        return fK_ProductID;
    }

    public void setFK_ProductID(int fK_ProductID) {
        this.fK_ProductID = fK_ProductID;
    }

    public int getFK_PackageID() {
        return fK_PackageID;
    }

    public void setFK_PackageID(int fK_PackageID) {
        this.fK_PackageID = fK_PackageID;
    }
}
