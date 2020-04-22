package com.example.godcode.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.base.GodCodeApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImagUtil {


    public static String handleUrl(String path) {
        if (!TextUtils.isEmpty(path)) {
            if (!path.contains("http")) {
                path = Constant.baseUrl + "/" + path;
            }
            return path;
        }
        return null;
    }


    public static Drawable circle(Bitmap bitmap) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(GodCodeApplication.getInstance().getResources(), bitmap);
        roundedBitmapDrawable.setCornerRadius(100);
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }


    public static Drawable conner(Bitmap bitmap) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(GodCodeApplication.getInstance().getResources(), bitmap); //创建RoundedBitmapDrawable对象
        roundedBitmapDrawable.setCornerRadius(10); //设置圆角半径（根据实际需求）
        roundedBitmapDrawable.setAntiAlias(true); //设置反走样
        return roundedBitmapDrawable;
    }

    public static Drawable conner2(Bitmap bitmap) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(GodCodeApplication.getInstance().getResources(), bitmap); //创建RoundedBitmapDrawable对象
        roundedBitmapDrawable.setCornerRadius(30); //设置圆角半径（根据实际需求）
        roundedBitmapDrawable.setAntiAlias(true); //设置反走样
        return roundedBitmapDrawable;
    }


    public static Bitmap compressImage(Bitmap image) {
        int bitmapSize = image.getRowBytes() * image.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        while (bitmapSize > (5 * 1024 * 1024)) {
            image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
            bitmapSize = image.getRowBytes() * image.getHeight();
        }
        return image;
    }


    public static Bitmap getViewBitmap(View addViewContent) {
        addViewContent.setDrawingCacheEnabled(true);
        addViewContent.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        addViewContent.layout(0, 0,
                addViewContent.getMeasuredWidth(),
                addViewContent.getMeasuredHeight());
        addViewContent.buildDrawingCache();
        Bitmap cacheBitmap = addViewContent.getDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
        return bitmap;
    }

    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        //获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        //计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        //取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        //得到新的图片
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }


    public static  File compressImage(File oldFile, Bitmap bm) {
        //压缩文件路径 照片路径/
        String targetPath = oldFile.getPath();
        int quality = 50;//压缩比例0-100
        bm = compressImage(bm);
        File outputFile = new File(targetPath);
        try {
            if (!outputFile.exists()) {
                outputFile.getParentFile().mkdirs();
                //outputFile.createNewFile();
            } else {
                outputFile.delete();
            }
            FileOutputStream out = new FileOutputStream(outputFile);
            bm.compress(Bitmap.CompressFormat.JPEG, quality, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return oldFile;
        }
        return outputFile;
    }


}
