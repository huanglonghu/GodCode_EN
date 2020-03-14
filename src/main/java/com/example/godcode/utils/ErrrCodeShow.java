package com.example.godcode.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ErrrCodeShow {
    public static void showToast(int errorCode, Context context,String body) {
        String content = "";
        switch (errorCode) {
            case 0:
                if(body.contains("Login failed!")){
                    content="登录失败";
                }else {
                    content = "网络访问失败";//多种情况导致0
                }
                break;
            case 2000:
                content = "User Not Found";
                break;
            case 2001:
                content = "Balance is not enough";
                break;
            case 2002:
                content = "This number has been registered";
                break;
            case 2003:
                content = "Invalid card number";
                break;
            case 2004:
                content = "Invalid phone number";
                break;
            case 2005:
                content = "Invalid currency type";
                break;
            case 2006:
                content = "Balance status error";
                break;
            case 2007:
                content = "Payment password has not been set";
                break;
            case 2008:
                content = "Invalid password";
                break;
            case 2009:
                content = "Payment order does not exist";
                break;
            case 2010:
                content = "This payment order does not belong to this user";
                break;
            case 2011:
                content = "当前用户余额不足！";
                break;
            case 2012:
                content = "Refund order timeout";
                break;
            case 2013:
                content = "Username already exist";
                break;
            case 2014:
                content = "Invalid password length(at least six letters)";
                break;
            case 2015:
                content = "Balance must be greater than 0";
                break;
            case 2016:
                content="Invalid parameter transmitted";
                break;
            case 2018:
                content="Refund failed";
                break;
            case 2019:
                content="No available withdraw balance";
                break;
            case 2020:
                content = "Balance error, binding failed";
                break;
            case 2021:
                content="This card already been used";
                break;
            case 2022:
                content="Verification code timeout/error";
                break;
            case 2023:
                content="Transaction not exist";
                break;
            case 3000:
                content = "Product type does not exist";
                break;
            case 3001:
                content = "Product already exist";
                break;
            case 3002:
                content = "This product does not exist";
                break;
            case 3003:
                content = "This product does not belong to the current user";
                break;
            case 3004:
                content = "Invalid setup";
                break;
            case 3005:
                content = "Product price already configured";
                break;
            case 3006:
                content = "Current product has not been bind to a host";
                break;
            case 3007:
                content = "Refund success, please do not repeat";
                break;
            case 3008:
                break;
            case 3009:
                content = "此设备已被绑定";
                break;
            case 3010:
                content = "分成用户已存在！";
                break;
            case 3011:
                content="此类别下已存在产品，不能删除！";
                break;
            case 3012:
                content="请先删除子级类别！";
                break;
            case 3014:
                content="设备不在线，请稍后重试！";
                break;
            case 3015:
                content="设备应答超时，请稍后重试！";
                break;
            case 4000:
                content = "好友不存在";
                break;
            case 4001:
                content = "好友已存在";
                break;
            case 4003:
                content = "不能添加自己为好友！";
                break;
            case 4004:
                content = "用户已登录";
                break;
            case 4005:
                content="用户未登录！";
                break;
            case 4006:
                content="异地登录";
                break;
            case 6002:
                content="数据校验错误";
                break;
            case 6006:
                content="不符合申请条件";
                break;
        }
        if (!TextUtils.isEmpty(content)) {
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
        }
    }


}
