package com.example.godcode.ui.fragment.newui.assetconfig;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.databinding.FragmentProductPriceBinding;
import com.example.godcode.ui.base.BaseFragment;

public class ProductPrice extends BaseFragment {

    private FragmentProductPriceBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_price, container, false);
        initView();
        initListener();
        return binding.getRoot();
    }


    @Override
    public void initView() {



    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
