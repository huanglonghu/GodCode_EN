package com.example.godcode_en.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ToastUtil {

    private Toast toast;

    private ToastUtil() {
    }

    private static ToastUtil defaultInstance;

    public static ToastUtil getInstance() {
        ToastUtil toastUtil = defaultInstance;
        if (defaultInstance == null) {
            synchronized (ToastUtil.class) {
                toastUtil = new ToastUtil();
                defaultInstance = toastUtil;
            }
        }
        return toastUtil;
    }

    public void showToast(String text, int delayTime, Context context) {
        if (!TextUtils.isEmpty(text)) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            Observable.timer(delayTime, TimeUnit.MILLISECONDS, Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                    time -> {
                        if (this.toast != null) {
                            this.toast.cancel();
                        }
                    }, throwable -> {
                    }
            );
        }
    }

    public void stopToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }


}
