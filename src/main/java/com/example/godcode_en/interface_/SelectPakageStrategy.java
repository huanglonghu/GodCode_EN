package com.example.godcode_en.interface_;

import com.example.godcode_en.bean.PackageItem;
import com.example.godcode_en.bean.PackageList;
import com.example.godcode_en.bean.ProductPackageSettingBean;

public abstract class SelectPakageStrategy {

    public void delete(int packageId) {}

    public void change(PackageItem packageItem) {}

    public void edit(PackageList.ResultBean.DataBean dataBean, Integer id){}

    public void bind(ProductPackageSettingBean productPackageSettingBean,Integer price,Integer coinCount){}


}
