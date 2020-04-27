package com.example.godcode_en.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.example.godcode_en.R;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.databinding.LayoutLangugeConfigBinding;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.utils.NetUtil;
import com.example.godcode_en.utils.SharepreferenceUtil;

import org.greenrobot.eventbus.EventBus;

public class LanguageConfigDialog extends Dialog implements NetUtil.WifiCOnfigResponse {
    private Context context;
    private LayoutLangugeConfigBinding binding;

    public LanguageConfigDialog(Context context) {
        super(context);
        this.context = context;
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
    }


    public void show() {
        super.show();
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_languge_config, null, false);
        binding.setDialog(this);
        boolean lanuageIsChinese = SharepreferenceUtil.getInstance().getLanuageIsChinese();
        binding.setIsChinese(lanuageIsChinese);
        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        binding.sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChinese = binding.getIsChinese();
                SharepreferenceUtil.getInstance().setLanuageIsChinese(isChinese);
                EventBus.getDefault().post(Constant.EVENT_REFRESH_LANGUAGE);
            }
        });
        setContentView(binding.getRoot());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = Presenter.getInstance().getWindowWidth() * 8 / 10;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.6f;
        getWindow().setAttributes(layoutParams);
    }


    @Override
    public void suceess(boolean isSuccess) {
        dismiss();
    }

    public void selectLanguage(int id) {
        switch (id) {
            case 0:
                binding.setIsChinese(true);
                break;
            case 1:
                binding.setIsChinese(false);
                break;
        }
    }
}
