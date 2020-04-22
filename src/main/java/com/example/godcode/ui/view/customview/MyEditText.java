package com.example.godcode.ui.view.customview;


import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.godcode.utils.LogUtil;

public class MyEditText extends EditText {

    public MyEditText(Context ctx) {
        this(ctx, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(watcher);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTextChangedListener(watcher);
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String str = s.toString().trim();
            LogUtil.log("-------Str---------"+str);
            if (!TextUtils.isEmpty(str) ){
                char first = str.charAt(0);
                if(first>=48&&first<=57){
                    double value = Double.parseDouble(str);
                    if (value > 0) {
                        moneyValueListener.setEnable(true,value);
                    } else {
                        moneyValueListener.setEnable(false,value);
                    }
                }else {
                    moneyValueListener.setEnable(false,0);
                }
            } else {
                moneyValueListener.setEnable(false,0);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {



        }
    };


    public interface MoneyValueListener {
        void setEnable(boolean enable,double money);
    }

    public void setMoneyValueListener(MoneyValueListener moneyValueListener) {
        this.moneyValueListener = moneyValueListener;
    }

    private MoneyValueListener moneyValueListener;

}