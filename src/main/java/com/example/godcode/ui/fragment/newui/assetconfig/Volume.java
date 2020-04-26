package com.example.godcode.ui.fragment.newui.assetconfig;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.R;
import com.example.godcode.bean.EditProductSetting;
import com.example.godcode.databinding.FragmentVolumeBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.ToastUtil;

public class Volume extends BaseFragment {

    private FragmentVolumeBinding binding;
    private int volume;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_volume, container, false);
        initData();
        initListener();
        return binding.getRoot();
    }

    @Override
    public void initView() {

    }


    private int productId;

    private Integer productSettingId;

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        productId = bundle.getInt("productId");
        productSettingId = bundle.getInt("productSettingId");
        volume = bundle.getInt("volume");
        binding.seek.setProgress(volume);
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
                int value = binding.seek.getProgress();
                EditProductSetting.ProductSettingBean psb = new EditProductSetting.ProductSettingBean();
                psb.setFK_ProductID(productId);
                psb.setId(productSettingId);
                psb.setProductSettingType("1");
                psb.setVolume(value + "");
                HttpUtil.getInstance().editProductSetting(psb).subscribe(
                        epsStr -> {
                            ToastUtil.getInstance().showToast("Modify the success", 1000, activity);
                        }
                );

            }
        });

    }
}
