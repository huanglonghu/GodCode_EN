package com.example.godcode_en.ui.view.customview;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditText1 extends EditText {
    public EditText1(Context context) {
        super(context);
    }

    public EditText1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditText1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindingAdapter("android:text")
    public static void setText(EditText1 view, String text) {
        view.setText(text);
    }
}
