package com.example.godcode.ui.fragment.newui.asset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.bean.BindProduct;
import com.example.godcode.bean.ProductCategory;
import com.example.godcode.bean.ProductPackageSettingBean;
import com.example.godcode.databinding.FragmentBindproductBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindProductFragment extends BaseFragment {
    private FragmentBindproductBinding binding;
    private View view;
    private BindProduct bindProductBody;
    private String[] productTypeArray;
    private HashMap<String, Integer> categryMap = new HashMap<>();
    private Map<Integer, String> packageStrMap;
    private Map<Integer, ProductPackageSettingBean> packageSettingBeanMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bindproduct, container, false);
        binding.setFrgament(this);
        view = binding.getRoot();
        initListener();
        getProductCategorys();
        packageStrMap = new HashMap<>();
        packageSettingBeanMap = new HashMap<>();
        return binding.getRoot();
    }


    public void initListener() {}


    private void getProductCategorys() {
        HttpUtil.getInstance().getAllProductCategorys().subscribe(
                productCategory -> {
                    ProductCategory category = new Gson().fromJson(productCategory, ProductCategory.class);
                    List<ProductCategory.ResultBean.ItemsBean> items = category.getResult().getItems();
                    productTypeArray = new String[items.size()];
                    for (int i = 0; i < items.size(); i++) {
                        ProductCategory.ResultBean.ItemsBean itemsBean = items.get(i);
                        String productType = itemsBean.getProductType();
                        int id = itemsBean.getId();
                        productTypeArray[i] = productType;
                        categryMap.put(productType, id);
                    }
                }
        );
    }


    public void initView() {
    }

    @Override
    public void initData() {
        bindProductBody = new BindProduct();
        binding.setBody(bindProductBody);
    }

    public void bind() {
        if (checkData(bindProductBody)) {
            bindProductBody.setFK_UserID(Constant.userId);
            bindProductBody.setIsBind(true);
            if (packageSettingBeanMap.size() > 0) {
                ArrayList<BindProduct.ProductPackageSettingBeanX> list = new ArrayList<>();
                for (int key : packageSettingBeanMap.keySet()) {
                    BindProduct.ProductPackageSettingBeanX productPackageSettingBeanX = new BindProduct.ProductPackageSettingBeanX();
                    ProductPackageSettingBean productPackageSettingBean = packageSettingBeanMap.get(key);
                    productPackageSettingBeanX.setProductPackageSetting(productPackageSettingBean);
                    list.add(productPackageSettingBeanX);
                }
                bindProductBody.setProductPackageSetting(list);
            }
            HttpUtil.getInstance().bindProduct(bindProductBody).subscribe(
                    bindProductStr -> {
                        if (bindProductStr.contains("\"success\":true")) {
                            Toast.makeText(activity, "Binding success", Toast.LENGTH_SHORT).show();
                            bindProductBody = new BindProduct();
                            binding.setBody(bindProductBody);
                            packageStrMap.clear();
                            packageSettingBeanMap.clear();
                            Presenter.getInstance().back();
                        } else {
                            Toast.makeText(activity, "Binding failure", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }
    }

    private boolean checkData(BindProduct body) {
        String productId = binding.productId.getText().toString();
        if (TextUtils.isEmpty(body.getProductNumber())) {
            Toast.makeText(activity, "Please enter the product id", Toast.LENGTH_SHORT).show();
            return false;
        }
        bindProductBody.setProductNumber(productId);
        String price = binding.price.getText().toString();
        if (TextUtils.isEmpty(price)) {
            Toast.makeText(activity, "Please enter the product price", Toast.LENGTH_SHORT).show();
            return false;
        }
        bindProductBody.setPrice(price);
        String adress = binding.adress.getText().toString();
        if (TextUtils.isEmpty(adress)) {
            Toast.makeText(activity, "Please enter the product address", Toast.LENGTH_SHORT).show();
            return false;
        }
        bindProductBody.setMachineAddress(adress);
        String productName = binding.productName.getText().toString();
        if (TextUtils.isEmpty(productName)) {
            Toast.makeText(activity, "Please enter the product name", Toast.LENGTH_SHORT).show();
            return false;
        }
        bindProductBody.setProductName(productName);
        String productType = binding.productType.getText().toString();
        if (TextUtils.isEmpty(productType)) {
            Toast.makeText(activity, "Please select product type", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


}
