package com.example.godcode_en.ui.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.BindingAdapter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.godcode_en.R;
import com.example.godcode_en.utils.LogUtil;


public class PartTextView extends View {

    private float textPadding;

    public PartTextView(Context context) {
        this(context, null);
    }

    public PartTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PartTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PartTextView);
        part1Text = typedArray.getString(R.styleable.PartTextView_part1Text);
        part2Text = typedArray.getString(R.styleable.PartTextView_part2Text);
        part1Color = typedArray.getColor(R.styleable.PartTextView_part1Color, Color.WHITE);
        part2Color = typedArray.getColor(R.styleable.PartTextView_part2Color, Color.WHITE);
        part1Size = typedArray.getDimension(R.styleable.PartTextView_part1Size, 30);
        part2Size = typedArray.getDimension(R.styleable.PartTextView_part2Size, 10);
        textPadding = typedArray.getDimension(R.styleable.PartTextView_textPadding, 5);
        typedArray.recycle();
        initPaint(context);
    }

    private String part1Text;
    private String part2Text;
    private int part1Color;
    private int part2Color;
    private Paint paint2;
    private Paint paint1;
    private float part1Size;
    private float part2Size;

    private void initPaint(Context context) {
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setTextSize(part1Size);
        paint1.setColor(part1Color);
        paint2 = new Paint();
        paint2.setTextSize(part2Size);
        paint2.setAntiAlias(true);
        paint2.setColor(part2Color);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        LogUtil.log(part1Text + "---------parttext-------" + part2Text);
        if (!TextUtils.isEmpty(part1Text)) {
            float x1 = paint1.measureText(part1Text);
            canvas.drawText(part1Text, width/2-x1/2, height-5, paint1);
            if (!TextUtils.isEmpty(part2Text)) {
                canvas.drawText(part2Text, width/2+x1/2, height-5, paint2);
            }
        }


    }

    @BindingAdapter(value = {"part2Text"})
    public static void setValue(PartTextView partTextView, String part2Text) {
        partTextView.setPart2Text(part2Text);
    }


    @BindingAdapter(value = {"part1Text"})
    public static void setValue2(PartTextView partTextView, String part1Text) {
        partTextView.setPart1Text(part1Text);
    }

    public String getPart2Text() {
        return part2Text;
    }

    public void setPart2Text(String part2Text) {
        this.part2Text = part2Text;
        invalidate();
    }

    public String getPart1Text() {
        return part1Text;
    }

    public void setPart1Text(String part1Text) {
        this.part1Text = part1Text;
        invalidate();
    }
}