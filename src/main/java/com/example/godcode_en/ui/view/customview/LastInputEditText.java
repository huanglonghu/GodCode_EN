package com.example.godcode_en.ui.view.customview;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class LastInputEditText extends AppCompatEditText {

    public LastInputEditText(Context context) {
        super(context);
    }

    public LastInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LastInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (selStart == selEnd) { // 防止不能多选
            setSelection(getText().length()); // 保证光标始终在最后面
        }
    }

    @BindingAdapter("android:text")
    public static void setText(EditText1 view, String text) {
        view.setText(text);
    }

}
