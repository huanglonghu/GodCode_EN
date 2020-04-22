package com.example.godcode.ui.fragment.newui.assetconfig;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.databinding.FragmentCurencyBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;

public class Curency extends BaseFragment {


    private FragmentCurencyBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_curency, container, false);
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

        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
