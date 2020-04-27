package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.Notification;
import com.example.godcode_en.greendao.gen.NotificationDao;
import com.example.godcode_en.ui.base.GodCodeApplication;

import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */

public class NotificationOption {

    private static NotificationOption defaultInstance;
    private NotificationOption(){}

    public static NotificationOption getInstance(){
        NotificationOption notificationOption=defaultInstance;
        if(defaultInstance == null){
            synchronized (NotificationOption.class){
                if(defaultInstance == null){
                    notificationOption=new NotificationOption();
                    defaultInstance=notificationOption;
                }
            }
        }
        return notificationOption;
    }


    public List<Notification> getAllNotification(int userId){
        NotificationDao notificationDao = GodCodeApplication.getInstance().getDaoSession().getNotificationDao();
        List<Notification> list = notificationDao.queryBuilder().where(NotificationDao.Properties.UserId.eq(userId)).list();

        return list;
    }

    public void memoryNotification(Notification notification){
        NotificationDao notificationDao = GodCodeApplication.getInstance().getDaoSession().getNotificationDao();
        notificationDao.insert(notification);
    }




}
