package com.example.godcode_en.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtil {


    private BitmapUtil() {
    }

    private static BitmapUtil defauleInstance;

    public static BitmapUtil getInstance() {
        BitmapUtil bitmapUtil = defauleInstance;
        if (defauleInstance == null) {
            synchronized (BitmapUtil.class) {
                bitmapUtil = new BitmapUtil();
                defauleInstance = bitmapUtil;
            }
        }
        return bitmapUtil;
    }


    public void saveBitmap(Bitmap bitmap, String bitName, Context context) {
        String fileName;
        File file;
        fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/" + bitName;
        file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            // 格式为 JPEG，照相机拍出的图片为JPEG格式的，PNG格式的不能显示在相册中
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)) {
                out.flush();
                out.close();
                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), bitName, null);
            }
            Toast.makeText(context, "The qr code has been saved in the phone album", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        // 发送广播，通知刷新图库的显示
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + fileName)));
    }


    public Bitmap drawTextToBitmap(Bitmap bit, String mText) {
        try {
            Bitmap bitmap = bit;
            Bitmap.Config bitmapConfig = bitmap.getConfig();
            if (bitmapConfig == null) {
                bitmapConfig = Bitmap.Config.ARGB_8888;
            }
            bitmap = bitmap.copy(bitmapConfig, true);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//消除锯齿
            paint.setDither(true); //获取跟清晰的图像采样
            paint.setFilterBitmap(true);//过滤一些
            paint.setColor(Color.BLACK);
            paint.setTextSize(40);
            paint.setShadowLayer(1f, 0f, 1f, Color.DKGRAY);//阴影制作半径，x偏移量，y偏移量，阴影颜色
            float textWidth = paint.measureText(mText);
            canvas.drawText(mText, bitmap.getWidth() / 2 - textWidth / 2, bitmap.getHeight() - 30, paint);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }


}
