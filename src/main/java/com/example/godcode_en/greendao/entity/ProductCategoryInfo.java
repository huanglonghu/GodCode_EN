package com.example.godcode_en.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/7/27.
 */
@Entity
public class ProductCategoryInfo {
    @NotNull
    private String ProductType;
    private int productId;

    @Generated(hash = 423552574)
    public ProductCategoryInfo(@NotNull String ProductType, int productId) {
        this.ProductType = ProductType;
        this.productId = productId;
    }
    @Generated(hash = 202487599)
    public ProductCategoryInfo() {
    }
    public String getProductType() {
        return this.ProductType;
    }
    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }
    public int getProductId() {
        return this.productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

}
