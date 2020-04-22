package com.example.godcode.ui.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.BindingAdapter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.godcode.R;

public class NewsView extends View {

    private Paint mPaint;
    private Paint circlePaint;
    private int reduis;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String num;

    public NewsView(Context context) {
        this(context, null);
    }

    public NewsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NewsView);
        reduis=typedArray.getDimensionPixelOffset(R.styleable.NewsView_reduis,20);
        num = typedArray.getString(R.styleable.NewsView_numText);
        typedArray.recycle();
        initPaint();

    }

    private void initPaint() {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.parseColor("#ff3e3e"));
        circlePaint.setStyle(Paint.Style.FILL);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(30);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect targetRect = new Rect(0, 0, 2*reduis, 2*reduis);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        canvas.drawCircle(reduis, reduis, reduis, circlePaint);
        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
        int baseline = targetRect.top + (targetRect.bottom - targetRect.top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        if(!TextUtils.isEmpty(num)){
            canvas.drawText(num, targetRect.centerX(), baseline, mPaint);
        }
    }

    @BindingAdapter(value = {"numText"})
    public static void setValue(NewsView newsView, String numText) {
        newsView.setNum(numText);
    }

}
