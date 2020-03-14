package com.example.godcode.ui.fragment.bindproduct;

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
import com.example.godcode.bean.PackageItem;
import com.example.godcode.bean.ProductCategory;
import com.example.godcode.bean.ProductPackageSettingBean;
import com.example.godcode.databinding.FragmentBindproduct1Binding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.SelectPakageStrategy;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.view.TypeSelect;
import com.example.godcode.ui.view.widget.PackageDialog;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.ToastUtil;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindProduct1Fragment extends BaseFragment implements TypeSelect.SelectResponse {
    private FragmentBindproduct1Binding binding;
    private View view;
    private BindProduct bindProductBody;
    private String[] productTypeArray;
    private BindProductFragment parentFragment;
    private HashMap<String, Integer> categryMap = new HashMap<>();
    private Map<Integer, String> packageStrMap;
    private Map<Integer, ProductPackageSettingBean> packageSettingBeanMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bindproduct1, container, false);
        binding.setFrgament(this);
        parentFragment = (BindProductFragment) getParentFragment();
        view = binding.getRoot();
        initListener();
        getProductCategorys();
        packageStrMap=new HashMap<>();
        packageSettingBeanMap=new HashMap<>();
        return binding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
        bindProductBody = new BindProduct();
        binding.setBody(bindProductBody);
        binding.productPackage.setText("");
        binding.productType.setText("");
        bindProductBody.setProductNumber(parentFragment.getProductNumber());
    }

    private void initListener() {
        binding.productType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productTypeArray != null && productTypeArray.length > 0) {
                    TypeSelect bankTypeSelect = new TypeSelect(activity, productTypeArray);
                    bankTypeSelect.setSelectResponse(BindProduct1Fragment.this);
                    bankTypeSelect.show();
                }
            }
        });

        String xzlx = getContext().getResources().getString(R.string.xzlx);
        binding.productPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bindProductBody.getFK_ProductCategoryID() == 0) {
                    ToastUtil.getInstance().showToast(xzlx, 1500, getContext());
                    return;
                }
                LogUtil.log("===========categoryId============="+bindProductBody.getFK_ProductCategoryID());
                PackageDialog.Builder builder = new PackageDialog.Builder();
                PackageDialog packageDialog = builder.way(2).context(getContext()).packageSettingBeanMap(packageSettingBeanMap).productCategoryID(bindProductBody.getFK_ProductCategoryID()).etStrategy(new Bind1FragmentStrategy()).build();
                packageDialog.show();
            }
        });
    }



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
                            setPackageStr();
                            binding.productType.setText("");
                            parentFragment.back();
                        } else {
                            Toast.makeText(activity, "Binding failure", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }
    }

    private boolean checkData(BindProduct body) {
        if (TextUtils.isEmpty(body.getProductNumber())) {
            Toast.makeText(activity, "Please enter the product number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(body.getPrice())) {
            Toast.makeText(activity, "Please enter the product price", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(body.getMachineAddress())) {
            Toast.makeText(activity, "Please enter the product address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(body.getProductName())) {
            Toast.makeText(activity, "Please enter the product name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(binding.productType.getText().toString())) {
            Toast.makeText(activity, "Please select product type", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void lazyLoad() {
    }



    @Override
    public void select(int pos) {
        String productType = productTypeArray[pos];
        int productCategoryId = categryMap.get(productType);
        bindProductBody.setFK_ProductCategoryID(productCategoryId);
        packageStrMap.clear();
        packageStrMap.clear();
        setPackageStr();
        binding.productType.setText(productType);
    }


    public class Bind1FragmentStrategy extends SelectPakageStrategy {
        @Override
        public void bind(ProductPackageSettingBean productPackageSettingBean, Integer price, Integer coinCount) {
            if (packageSettingBeanMap.size() >= 3) {
                ToastUtil.getInstance().showToast("最多只能添加3个套餐", 1500, getContext());
            } else {
                packageSettingBeanMap.put(productPackageSettingBean.getFK_PackageID(), productPackageSettingBean);
                String packageStr = price + "元=" + coinCount + "次";
                packageStrMap.put(productPackageSettingBean.getFK_PackageID(), packageStr);
                setPackageStr();
            }
        }

        @Override
        public void delete(int packageId) {
            packageSettingBeanMap.remove(packageId);
            packageStrMap.remove(packageId);
            setPackageStr();
        }

        @Override
        public void change(PackageItem packageItem) {
            Integer id = packageItem.getId();
            String packageStr = packageItem.getPrice() + "元=" + packageItem.getCoinCount() + "次";
            packageStrMap.put(id, packageStr);
            setPackageStr();
        }
    }

    private void setPackageStr() {
        StringBuffer sb = new StringBuffer();
        for (int i : packageStrMap.keySet()) {
            String s = packageStrMap.get(i);
            if (sb.length() == 0) {
                sb.append(s);
            } else {
                sb.append("," + s);
            }
        }
        binding.productPackage.setText(sb.toString());
    }
}
