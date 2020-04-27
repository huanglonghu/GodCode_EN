package com.example.godcode_en.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.godcode_en.interface_.EtStrategy;


public class NetStateReceiver extends BroadcastReceiver {
    private EtStrategy etStrategy;


    public NetStateReceiver(EtStrategy etStrategy) {
        this.etStrategy = etStrategy;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            etStrategy.netChange(true);
        } else {
            etStrategy.netChange(false);
        }
    }

}
