package com.example.godcode.ui.fragment.newui.assetconfig;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.EditProductSetting;
import com.example.godcode.bean.GroupMsg;
import com.example.godcode.bean.ProductSetting;
import com.example.godcode.databinding.FragmentJbywBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.ToastUtil;

public class Jbyw extends BaseFragment {

    private FragmentJbywBinding binding;
    private int productId;
    private Integer productSettingId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_jbyw, container, false);
        initView();
        initData();
        return binding.getRoot();
    }

    @Override
    public void initView() {
        binding.rulerView.setScope(10, 400, 10);
        binding.rulerView.setCurrentItem("100");
    }

    @Override
    public void initData() {

        Bundle bundle = getArguments();
        productId = bundle.getInt("productId");
        productSettingId = bundle.getInt("productSettingId");

    }

    @Override
    public void initListener() {

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectValue = binding.rulerView.getSelectValue();
                EditProductSetting.ProductSettingBean psb = new EditProductSetting.ProductSettingBean();
                psb.setFK_ProductID(productId);
                psb.setId(productSettingId);
                psb.setProductSettingType(3 + "");
                psb.setCoinPlay(selectValue);
                HttpUtil.getInstance().editProductSetting(psb).subscribe(
                        epsStr -> {
                            ToastUtil.getInstance().showToast("Modify success", 1000, activity);
                        }
                );
            }
        });


    }
}
