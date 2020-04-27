package com.example.godcode_en.ui.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.godcode_en.R;

public class AmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private static final String TAG = "AmountView";

    public int getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        if(!TextUtils.isEmpty(amount)){
            this.amount=Integer.parseInt(amount);
        }
        etAmount.setText(this.amount+"");
    }

    private int amount; //购买数量
    private int goods_storage = 1000; //商品库存

    private OnAmountChangeListener mListener;

    private TextView etAmount;
    private ImageView btnDecrease;
    private ImageView btnIncrease;
    Context context;

    public AmountView(Context context) {
        this(context, null);
    }


    public AmountView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.jiajian, this);
        etAmount = (TextView) findViewById(R.id.etAmount);
        btnDecrease = (ImageView) findViewById(R.id.btnDecrease);
        btnIncrease = (ImageView) findViewById(R.id.btnIncrease);
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        etAmount.addTextChangedListener(this);
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);
        ta.recycle();
    }


    public AmountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        this.mListener = onAmountChangeListener;
    }

    public void setGoods_storage(int goods_storage) {
        this.goods_storage = goods_storage;
    }

    @Override
    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.btnDecrease) {
            if (amount >= 1) {
                amount--;
                etAmount.setText(amount + "");
            }
        } else if (i == R.id.btnIncrease) {
            if (amount < goods_storage) {
                amount++;
                etAmount.setText(amount + "");
            }
        }

        etAmount.clearFocus();

//        if (mListener != null) {
//            mListener.onAmountChange(this, amount);
//        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().isEmpty())
            return;
        amount = Integer.valueOf(s.toString());
        if (amount > goods_storage) {
            etAmount.setText(goods_storage + "");
            return;
        }

        if (mListener != null) {
            mListener.onAmountChange(this, amount);
        }
    }


    public interface OnAmountChangeListener {
        void onAmountChange(View view, int amount);
    }



}
