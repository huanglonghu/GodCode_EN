package com.example.godcode_en.ui.view.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.godcode_en.R;
import com.example.godcode_en.greendao.option.LoginResultOption;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.activity.LoginActivity;

public class ExitDialog extends AlertDialog {
    private Context context;

    public ExitDialog(Context context) {
        super(context);
        this.context = context;
        setCancelable(false);


    }

    @Override
    public void show() {
        super.show();
        View view = View.inflate(context, R.layout.layout_exit_dialog, null);
        setContentView(view);
        Button sure = (Button) view.findViewById(R.id.sure);
        Button cancle = (Button) view.findViewById(R.id.cancle);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginResultOption.getInstance().exit();
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//new task似乎不总是好使，有兴趣的话，可以尝试下。
                context.startActivity(intent);
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int i = 1 * Presenter.getInstance().getWidowHeight() / 2;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.width = i;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.6f;
        getWindow().setAttributes(layoutParams);

    }


}
