package com.example.godcode_en.ui.view.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.example.godcode_en.R;

public class AntLineView extends View {

    private Paint mPaint;
    private int color;
    private Paint circlePaint;
    private int type;
    private int reduis;

    public AntLineView(Context context) {
        this(context, null);
    }

    public AntLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AntLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AntLineView);
        color = typedArray.getColor(R.styleable.AntLineView_antLineColor, Color.RED);//"#19ab18"
        type = typedArray.getInt(R.styleable.AntLineView_antLineType, 1);
        reduis=typedArray.getDimensionPixelOffset(R.styleable.AntLineView_circleReduis,20);
        typedArray.recycle();
        initPaint();
    }

    private void initPaint() {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(5);
        circlePaint.setColor(color);
        circlePaint.setStyle(Paint.Style.FILL);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setPathEffect(new DashPathEffect(new float[]{4, 4}, 0));
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        if(type == 1){
            canvas.drawCircle(reduis, reduis, reduis, circlePaint);
            canvas.drawLine(reduis, reduis*2, reduis, getHeight(), mPaint);
        }else if(type == 2){
            canvas.drawLine(reduis,0,reduis,getHeight()-2*reduis,mPaint);
            canvas.drawCircle(reduis,getHeight()-reduis,reduis,circlePaint);
        }


    }
}
