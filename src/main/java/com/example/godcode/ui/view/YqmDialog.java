package com.example.godcode.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.example.godcode.R;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.LayoutQrcodeBinding;
import com.example.godcode.utils.BitmapUtil;
import com.google.zxing.encoding.EncodingHandler;

public class YqmDialog extends Dialog {

    public YqmDialog(Context context, int id) {
        super(context);
        LayoutQrcodeBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_qrcode, null, false);
        //  http://localhost:5000/WithdrawMoneyProxy?id=1
        String str = Constant.baseUrl + "/WithdrawMoneyProxy?id=" + id;
        Bitmap logo = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo);
        Bitmap assetBitmap = EncodingHandler.createQRCode(str, 1000, 1000, null);
        binding.ivAssetCode.setBackground(new BitmapDrawable(context.getResources(), assetBitmap));
        binding.icon.setImageBitmap(logo);
        binding.saveCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapUtil.getInstance().saveBitmap(assetBitmap, "邀请码二维码", context);
            }
        });
        setContentView(binding.getRoot());
        setCancelable(true);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.5f;
        getWindow().setAttributes(layoutParams);
    }
}
