package com.example.godcode_en.ui.fragment.newui.asset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode_en.R;
import com.example.godcode_en.bean.BindProduct;
import com.example.godcode_en.bean.ProductCategory;
import com.example.godcode_en.bean.ProductPackageSettingBean;
import com.example.godcode_en.databinding.FragmentBindproductBinding;
import com.example.godcode_en.greendao.entity.ProductCategoryInfo;
import com.example.godcode_en.greendao.option.ProductCategoryOption;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.interface_.ClickSureListener;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.ui.view.widget.SelectProductType;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindProductFragment extends BaseFragment {
    private FragmentBindproductBinding binding;
    private View view;
    private String[] productTypeArray;
    private Map<Integer, String> packageStrMap;
    private Map<Integer, ProductPackageSettingBean> packageSettingBeanMap;
    private BindProduct bindProductBody;

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
        return view;
    }

    public void initListener() {

        binding.productType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectProductType selectProductType = new SelectProductType(getContext(), productTypeArray, new ClickSureListener() {
                    @Override
                    public void select(String productType) {
                        binding.productType.setText(productType);
                    }
                });
                selectProductType.show();
            }
        });


        binding.bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bind();
            }
        });
    }

    private void getProductCategorys() {
        List<ProductCategoryInfo> productCategoryList = ProductCategoryOption.getInstance().getProductCategoryList();
        if (productCategoryList == null || productCategoryList.size() == 0) {
            HttpUtil.getInstance().getAllProductCategorys().subscribe(
                    productCategory -> {
                        ProductCategory category = new Gson().fromJson(productCategory, ProductCategory.class);
                        List<ProductCategory.ResultBean.ItemsBean> items = category.getResult().getItems();
                        productTypeArray = new String[items.size()];
                        for (int i = 0; i < items.size(); i++) {
                            ProductCategory.ResultBean.ItemsBean itemsBean = items.get(i);
                            String productType = itemsBean.getProductType();
                            productTypeArray[i] = productType;
                            int id = itemsBean.getId();
                            ProductCategoryInfo productCategoryInfo = new ProductCategoryInfo();
                            productCategoryInfo.setProductId(id);
                            productCategoryInfo.setProductType(productType);
                            ProductCategoryOption.getInstance().add(productCategoryInfo);
                        }
                    }
            );
        } else {
            productTypeArray = new String[productCategoryList.size()];
            for (int i = 0; i < productCategoryList.size(); i++) {
                ProductCategoryInfo productCategoryInfo = productCategoryList.get(i);
                productTypeArray[i] = productCategoryInfo.getProductType();
            }
        }

    }


    public void initView() {
    }

    @Override
    public void initData() {

    }

    private void bind() {
        bindProductBody = new BindProduct();
        if (checkData()) {
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

    private boolean checkData() {
        String productId = binding.productId.getText().toString();
        if (TextUtils.isEmpty(productId)) {
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
        bindProductBody.setFK_ProductCategoryID(ProductCategoryOption.getInstance().querryProductId(productType));
        return true;
    }


}
