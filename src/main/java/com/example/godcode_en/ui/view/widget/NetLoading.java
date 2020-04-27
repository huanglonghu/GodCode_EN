package com.example.godcode_en.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.example.godcode_en.R;

/**
 * Created by Administrator on 2018/7/21.
 */

public class NetLoading extends Dialog {


    public NetLoading(@NonNull Context context) {
        super(context);
        View view = View.inflate(context, R.layout.layout_netloading, null);
        ImageView ivLoad = (ImageView) view.findViewById(R.id.iv_load);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.load);
        ivLoad.setAnimation(animation);
        setContentView(view);
        setCancelable(false);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.6f;
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        getWindow().setAttributes(layoutParams);
    }
}
