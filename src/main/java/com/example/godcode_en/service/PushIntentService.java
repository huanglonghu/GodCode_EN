package com.example.godcode_en.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.example.godcode_en.R;
import com.example.godcode_en.bean.Notice2;
import com.example.godcode_en.ui.activity.MainActivity;
import com.example.godcode_en.utils.GsonUtil;
import com.example.godcode_en.utils.LogUtil;
import com.umeng.message.UmengMessageService;
import com.umeng.message.entity.UMessage;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;
import java.util.Map;

public class PushIntentService extends UmengMessageService {
    private static final String TAG = PushIntentService.class.getName();
    private BroadcastReceiver receiver;

    @Override
    public void onMessage(Context context, Intent intent) {
        try {
            //可以通过MESSAGE_BODY取得消息体
            String message = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
//            String str=message.replaceAll("\\\\", "");//将URL中的反斜杠替换为空  加上之后收不到消息
            UMessage msg = new UMessage(new JSONObject(message));
            LogUtil.log("message=" + message);    //消息体
            LogUtil.log("custom=" + msg.custom);    //自定义消息的内容
            LogUtil.log("title=" + msg.title);    //通知标题
            LogUtil.log("text=" + msg.text);    //通知内容
            //消息处理
            int type = 0;
            switch (msg.title) {
                case "最新资讯":
                    type = 0;
                    Intent in1 = new Intent();
                    in1.setAction("com.example.godcode_en.service.noticeUpdate");
                    sendBroadcast(in1);
                    break;
                case "提现通知"://已测试
                    type = 1;
                    break;
                case "好友请求通知"://已测试
                    type = 2;
                    break;
                case "异常登陆通知"://已测试
                    type = 3;
                    break;
                case "好友同意通知":
                    type = 4;
                    Intent in = new Intent();
                    in.setAction("com.example.godcode_en.service.friendUpdate");
                    sendBroadcast(in);
                    break;
                case "退款通知":
                    type = 5;
                    break;
                case "收入通知":
                    type = 6;
                    break;
                case "盈利分成到账通知":
                    type = 7;
                    break;
            }
            showNotification(this, msg, type, message);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

//    message={"display_type":"notification","extra":{"obj":{"TransactionType":5,"RelatedKey":10520,"id":40469}},"msg_id":"uutvsx1153449646597300","body":
//        {"after_open":"go_app","ticker":"充值成功通知","text":"您的充值已成功，请点击查看!","title":"充值成功通知"},"random_min":0}


    public void showNotification(Context context, UMessage msg, int type, String message) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification mNotification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            showChannel1Notification(context, manager);
            Notification.Builder builder = new Notification.Builder(context, "1"); //与channelId对应
            builder.setSmallIcon(R.drawable.logo)
                    .setContentTitle(msg.title)
                    .setContentText(msg.text);
            mNotification = builder.build();
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setAutoCancel(true);
            NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat
                    .Builder(this)
                    .setSmallIcon(R.drawable.logo)
                    .setContentTitle(msg.title)
                    .setContentText(msg.text);
            mNotification = mBuilder.build();
        }
        Intent intent = new Intent(context, MainActivity.class);//代表fragment所绑定的activity，这个需要写全路径
        intent.putExtra("message", type);
        if (message.contains("TransactionType")) {
            Map<String, String> extra = msg.extra;
            String json = extra.get("obj");
            Notice2 notice2 = GsonUtil.getInstance().fromJson(json, Notice2.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", notice2.getId());
            bundle.putInt("relatedKey", notice2.getRelatedKey());
            bundle.putInt("transactionType", notice2.getTransactionType());
            intent.putExtras(bundle);
        } else if (message.contains("NoticeId")) {
            Map<String, String> extra = msg.extra;
            Bundle bundle = new Bundle();
            bundle.putString("noticeId", extra.get("NoticeId"));
            intent.putExtras(bundle);
        }
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mNotification.flags = Notification.FLAG_AUTO_CANCEL;
        //使用自定义下拉视图时，不需要再调用setLatestEventInfo()方法，但是必须定义contentIntent
        mNotification.contentIntent = pIntent;
        manager.notify(103, mNotification);
    }

    @TargetApi(26)
    public static void showChannel1Notification(Context context, NotificationManager manager) {
        NotificationChannel channel = new NotificationChannel("1",
                "Channel1", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setLightColor(Color.GREEN); //小红点颜色
        channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
        manager.createNotificationChannel(channel);
    }

}
