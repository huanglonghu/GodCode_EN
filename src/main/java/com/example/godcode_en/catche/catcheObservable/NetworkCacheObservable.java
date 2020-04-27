package com.example.godcode_en.catche.catcheObservable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.godcode_en.bean.ImageBean;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import okhttp3.ResponseBody;

public class NetworkCacheObservable extends CacheObservable {
    @Override
    public ImageBean getDataFromCache(String url) {
        Bitmap bitmap = downloadImage(url);
        return new ImageBean(bitmap, url);
    }


    @Override
    public void putDataToCache(ImageBean image) {
    }

    /**
     * 下载文件
     * @param url
     * @return
     */
    public Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {
            URL imageUrl = new URL(url);
            URLConnection urlConnection = (HttpURLConnection) imageUrl.openConnection();
            inputStream = urlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    public Bitmap downloadImage(ResponseBody body){
        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {
            inputStream= body.byteStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }
}
