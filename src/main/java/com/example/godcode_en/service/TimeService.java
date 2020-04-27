package com.example.godcode_en.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.godcode_en.utils.LogUtil;


public class TimeService extends Service {

    private Thread refreshThread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       LogUtil.log("=======intent====="+intent);
//        Bundle bundle = intent.getExtras();
//
//        if (bundle != null) {
//            int expired = intent.getExtras().getInt("expired");
//            int inteverTime = (expired - 180) * 1000;
//            LogUtil.log(inteverTime + "==============" + expired);
//            if (refreshThread == null && inteverTime > 0) {
//                refreshThread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        while (true) {
//                            try {
//                                Intent refreshIntent = new Intent("ELITOR_CLOCK");
//                                sendBroadcast(refreshIntent);
//                                Thread.sleep(inteverTime);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                });
//                refreshThread.start();
//            }
//        }
        return super.onStartCommand(intent, flags, startId);
    }
}
