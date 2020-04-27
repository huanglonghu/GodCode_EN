package com.example.godcode_en.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/9.
 */

public class DateUtil {

    private DateUtil() {
    }

    private static DateUtil defaultInstance;

    public static DateUtil getInstance() {
        DateUtil dateUtil = defaultInstance;
        if (defaultInstance == null) {
            synchronized (DateUtil.class) {
                if (defaultInstance == null) {
                    dateUtil = new DateUtil();
                }
            }
        }
        return dateUtil;
    }

    public long getStringToDate(String dateString, String pattern) {
        ////"yyyy-MM-dd'T'HH:mm:ss.SSSSSSS"
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }


    public String formatDate(String date){
        String[] split = date.split("\\.");
        System.out.println(split.length);
        long stringToDate = DateUtil.getInstance().getStringToDate(split[0], "yyyy-MM-dd'T'HH:mm:ss");
        String s1 = DateUtil.getInstance().formatTime(stringToDate);
        return s1;
    }


    public String formatTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(new Date(time));
        return formatTime;
    }


    public String getToday() {
        long l = System.currentTimeMillis();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        String format = sp.format(l);
        return format;
    }


    public String getYesterDaty() {
        long l = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        String format = sp.format(l);
        return format;
    }

    public String getMonth() {
        long l = System.currentTimeMillis();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-01");
        String format = sp.format(l);
        return format;
    }


}
