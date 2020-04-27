package com.example.godcode_en.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.godcode_en.ui.base.GodCodeApplication;

/**
 * Created by Administrator on 2018/7/30.
 */

public class SharepreferenceUtil {

    private void SharepreferenceUtil() {
    }

    private static SharepreferenceUtil sharepreferenceUtil;

    public static SharepreferenceUtil getInstance() {
        SharepreferenceUtil spUtil = sharepreferenceUtil;
        if (sharepreferenceUtil == null) {
            synchronized (SharepreferenceUtil.class) {
                if (sharepreferenceUtil == null) {
                    spUtil = new SharepreferenceUtil();
                }
            }
        }
        return spUtil;
    }


    public void saveAccessToken(String accseeToken, String loginToken, long time) {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        sp.edit().putString("accessToken", accseeToken).putString("loginToken", loginToken).putLong("tokenTime", time).commit();
    }

    public String getAccessToken() {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        String accessToken = sp.getString("accessToken", "");
        return accessToken;
    }

    public String getLoginToken() {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        String loginToken = sp.getString("loginToken", "");
        return loginToken;
    }

    public long getTokenTime() {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        long tokenTime = sp.getLong("tokenTime", 0);
        return tokenTime;
    }

    public void setUpdateAddress(String updateAddress) {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        sp.edit().putString("updateAddress", updateAddress).commit();
    }

    public String getUpdateAddress() {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        String updateAddress = sp.getString("updateAddress", "");
        return updateAddress;
    }


    public void setLanuageIsChinese(boolean isChinese) {
        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        sp.edit().putBoolean("isChinese", isChinese).commit();
    }

    public boolean getLanuageIsChinese() {

        SharedPreferences sp = GodCodeApplication.getInstance().getSharedPreferences("sy", Context.MODE_PRIVATE);
        return sp.getBoolean("isChinese", true);
    }


}
