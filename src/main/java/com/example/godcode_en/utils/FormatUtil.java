package com.example.godcode_en.utils;

import android.text.TextUtils;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2018/8/9.
 */

public class FormatUtil {

    private DecimalFormat decimalFormat;

    private FormatUtil() {
    }

    private static FormatUtil defaultInstance;

    public static FormatUtil getInstance() {
        FormatUtil dateUtil = defaultInstance;
        if (defaultInstance == null) {
            synchronized (DateUtil.class) {
                if (defaultInstance == null) {
                    dateUtil = new FormatUtil();
                }
            }
        }
        return dateUtil;
    }

    public boolean checkPhoneNumber(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            return false;
        }
//        String first = phoneNum.substring(0, 1);
//        if (!first.equals("1")) {
//            return false;
//        }
//        if (phoneNum.length() != 11) {
//            return false;
//        }
        return true;
    }

    public   boolean isBeginWith4G(String productNumber){
        if(!TextUtils.isEmpty(productNumber)){
            if(productNumber.length()>=2){
                String first = productNumber.substring(0, 2);
                if("4g".equals(first)||"4G".equals(first)){
                    return true;
                }
            }

        }
        return false;
    }


    public boolean checkYzm(String yzm) {


        if (TextUtils.isEmpty(yzm)) {
            return false;
        }
        if (yzm.length() != 6) {
            return false;
        }
        return true;
    }


    public String getLast4Num(String bankNumber) {
        String last4Num = bankNumber.substring(bankNumber.length() - 4);
        return last4Num;
    }

    public String get2double(double num) {
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0.00");
        }
        String format = decimalFormat.format(num);

        return format;
    }


}
