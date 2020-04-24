package com.example.godcode.ui.view.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.godcode.R;
import com.example.godcode.databinding.LayoutMainPopupBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.GodCodeApplication;
import com.example.godcode.utils.RudenessScreenHelper;

public class MenuWindow extends PopupWindow {
    private View root;

    public MenuWindow(Context context) {
        root = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_main_popup, null, false).getRoot();
        int windowWidth = GodCodeApplication.getInstance().getWindownWidth();
        int w = windowWidth * 380 / 1125;
        setWidth(w);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setContentView(root);
        setFocusable(true);
    }


    public void show(View view) {
        showAsDropDown(view);
    }

    public LayoutMainPopupBinding getBinding1() {
        LayoutMainPopupBinding binding = DataBindingUtil.findBinding(root);
        return binding;
    }


}
