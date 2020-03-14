package com.example.godcode.ui.fragment.deatailFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.EditProductSetting;
import com.example.godcode.bean.GroupMsg;
import com.example.godcode.bean.ProductSetting;
import com.example.godcode.bean.SystemSetting;
import com.example.godcode.databinding.FragmentFreemodesettingBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.LogUtil;

public class FreeModeSetting extends BaseFragment {

    private FragmentFreemodesettingBinding binding;
    private int productId;
    private String productSettingId;
    private int freePlayType;
    private int freePlayCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_freemodesetting, container, false);
        binding.setPresenter(presenter);
        initData();
        initListen();
        return binding.getRoot();
    }

    private void initListen() {
        productId = getArguments().getInt("productId");
        productSettingId = getArguments().getString("productSettingId");
        freePlayType = getArguments().getInt("freePlayType");
        freePlayCount = getArguments().getInt("freePlayCount");
        binding.count.setText(freePlayCount + "");
        if (freePlayType == 1) {
            binding.cb1.setChecked(true);
        } else if (freePlayType == 2) {
            binding.cb2.setChecked(true);
        }
        binding.cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.log(binding.cb1.isChecked() + "11=========checked===========" + binding.cb2.isChecked());
                if (binding.cb1.isChecked()) {
                    if (binding.cb2.isChecked()) {
                        binding.cb2.setChecked(false);
                    }
                    freeSetting(1, 1, 0);
                } else {
                    freeSetting(0, 1, 0);
                }
            }
        });

        binding.cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.log(binding.cb1.isChecked() + "22=========checked===========" + binding.cb2.isChecked());

                if (binding.cb2.isChecked()) {
                    if (binding.cb1.isChecked()) {
                        binding.cb1.setChecked(false);
                    }
                    freeSetting(2, 1, 0);
                } else {
                    freeSetting(0, 1, 0);
                }

            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.count.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(getContext(), "Please enter frequency", Toast.LENGTH_SHORT).show();
                    return;
                }
                freeSetting(0, 2, Integer.parseInt(s));
            }
        });
    }


    public void freeSetting(int freeType, int type, int count) {
        EditProductSetting.ProductSettingBean productSettingBean = new EditProductSetting.ProductSettingBean();
        productSettingBean.setFK_ProductID(productId);
        if (productSettingId != null) {
            productSettingBean.setId(Integer.parseInt(productSettingId));
        }
        if (type == 1) {
            productSettingBean.setFreePlayType(freeType);
            productSettingBean.setFreePlayCount(freePlayCount);
        } else {
            productSettingBean.setFreePlayCount(count);
            productSettingBean.setFreePlayType(freePlayType);
        }
        HttpUtil.getInstance().editProductSetting(productSettingBean).subscribe(
                str -> {
                    ProductSetting productSetting = GsonUtil.fromJson(str, ProductSetting.class);
                    ProductSetting.ResultBean result = productSetting.getResult();
                    freePlayType = result.getFreePlayType();
                    freePlayCount = result.getFreePlayCount();
                    Toast.makeText(getContext(), "设置成功", Toast.LENGTH_SHORT).show();
                }
        );
    }


    private void initData() {
        HttpUtil.getInstance().getSystemSettings().subscribe(
                str -> {
                    SystemSetting systemSetting = GsonUtil.fromJson(str, SystemSetting.class);
                    SystemSetting.ResultBean result = systemSetting.getResult();
                    if (result != null) {
                        double publicNoPrice = result.getPublicNoPrice();
                        binding.mode2.setText("关注立减" + publicNoPrice + "元");
                    }
                }
        );
    }


    @Override
    protected void lazyLoad() {

    }
}
