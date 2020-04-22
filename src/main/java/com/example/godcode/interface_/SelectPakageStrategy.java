package com.example.godcode.interface_;

import com.example.godcode.bean.PackageItem;
import com.example.godcode.bean.PackageList;
import com.example.godcode.bean.ProductPackageSettingBean;

public abstract class SelectPakageStrategy {

    public void delete(int packageId) {}

    public void change(PackageItem packageItem) {}

    public void edit(PackageList.ResultBean.DataBean dataBean, Integer id){}

    public void bind(ProductPackageSettingBean productPackageSettingBean,Integer price,Integer coinCount){}


}
