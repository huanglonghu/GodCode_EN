package com.example.godcode.ui.fragment.newui.assetconfig;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.EditProductPrice;
import com.example.godcode.bean.GroupMsg;
import com.example.godcode.bean.MyAssetList;
import com.example.godcode.databinding.FragmentProductPriceBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.LogUtil;

public class ProductPrice extends BaseFragment {

    private FragmentProductPriceBinding binding;
    private int productId;
    private int priceId;
    private int userId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_price, container, false);
        initView();
        initData();
        initListener();
        return binding.getRoot();
    }


    @Override
    public void initView() {
        binding.rulerView.setScope(1, 20, 1);
    }

    private MyAssetList.ResultBean.DataBean bean;

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        bean = (MyAssetList.ResultBean.DataBean) bundle.getSerializable("bean");
        productId = bean.getFK_ProductID();
        priceId = bean.getFK_PriceID();
        userId = bean.getFK_UserID();
        double price = bean.getPrice();
        binding.rulerView.setCurrentItem((int) price + "");
    }

    @Override
    public void initListener() {

        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectValue = binding.rulerView.getSelectValue();
                int price = Integer.parseInt(selectValue);
                EditProductPrice editProductPrice = new EditProductPrice();
                EditProductPrice.ProductPriceBean productPriceBean = new EditProductPrice.ProductPriceBean();
                productPriceBean.setPrice(price);
                productPriceBean.setFK_ProductID(productId);
                productPriceBean.setFK_UserID(userId);
                productPriceBean.setId(priceId);
                productPriceBean.setIsValid(true);
                editProductPrice.setProductPrice(productPriceBean);
                HttpUtil.getInstance().editProductPrice(editProductPrice).subscribe(
                        editPriceStr -> {
                            if (editPriceStr.contains("\"success\":true")) {
                                bean.setPrice(price);
                                Toast.makeText(activity, "Modified success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(activity, "Modified failure", Toast.LENGTH_SHORT).show();
                            }
                        }
                );


            }
        });


    }
}
