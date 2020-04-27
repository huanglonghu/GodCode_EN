package com.example.godcode_en.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.godcode_en.R;
import com.example.godcode_en.databinding.LayoutUpdateBinding;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.utils.SharepreferenceUtil;

public class UpdateDialog extends Dialog {

    private Context context;
    private LayoutUpdateBinding binding;

    public UpdateDialog(Context context) {
        super(context);
        this.context = context;
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
    }

    @Override
    public void show() {
        super.show();
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_update, null, false);
        setContentView(binding.getRoot());
        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String updateAddress = SharepreferenceUtil.getInstance().getUpdateAddress();
                if(!TextUtils.isEmpty(updateAddress)){
                    Uri content_url = Uri.parse(updateAddress);
                    intent.setData(content_url);
                    context.startActivity(intent);
                }
                dismiss();
            }
        });
        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = Presenter.getInstance().getWindowWidth() * 8 / 10;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.6f;
        getWindow().setAttributes(layoutParams);
    }


    public void setDescibe(String descibe, String versionCode) {
        if (!TextUtils.isEmpty(descibe)) {
            String replace = descibe.replace("|", "\n");
            binding.des.setText(replace);
            binding.setVersionCode(versionCode);
        }
    }


}
