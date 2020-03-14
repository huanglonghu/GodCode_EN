package com.example.godcode.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.example.godcode.R;
import com.example.godcode.databinding.LayoutProductSetting2Binding;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.presenter.Presenter;

public class ProductSettingDialog2 extends Dialog {
    private LayoutProductSetting2Binding binding;
    private Context context;
    private String[] data;

    public ProductSettingDialog2(Context context, String title, ClickSureListener clickSureListener, String[] data) {
        super(context);
        this.context = context;
        this.data = data;
        initView(title);
        initListener();
    }


    public void show() {
        super.show();
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = Presenter.getInstance().getWindowWidth() * 8 / 10;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.6f;
        getWindow().setAttributes(layoutParams);
    }

    private void initView(String title) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_product_setting2, null, false);
        setContentView(binding.getRoot());
        binding.setTitle(title);
    }

    private void initListener() {
        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        binding.sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
