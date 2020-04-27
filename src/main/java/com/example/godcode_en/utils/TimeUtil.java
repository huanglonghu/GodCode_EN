package com.example.godcode_en.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static String getStringToDate(String dateString) {
        //"yyyy-MM-dd'T'HH:mm:ss"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStr = formatTime(date.getTime());
        return dateStr;
    }

    public static String getStringToDate2(String dateString) {
        //"yyyy-MM-dd'T'HH:mm:ss"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStr = formatTime4(date.getTime());
        return dateStr;
    }

    public static String getStringToDate3(String dateString) {
        //"yyyy-MM-dd'T'HH:mm:ss"
        String t = dateString.replaceAll("T", " ");
        if (t.contains(".")) {
            String[] split = t.split("\\.");
            t = split[0];
        }
        return t;
    }

    public static String formatTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatTime = sdf.format(new Date(time));
        return formatTime;
    }

    public static String formatTime2(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String formatTime = sdf.format(new Date(time));
        return formatTime;
    }

    public static String formatTime3(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formatTime = sdf.format(new Date(time));
        return formatTime;
    }

    public static String formatTime4(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatTime = sdf.format(new Date(time));
        return formatTime;
    }


    public static String[] getDate1(int amount) {
        String[] dates = new String[2];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        dates[0] = simpleDateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        dates[1] = simpleDateFormat.format(calendar.getTime());
        return dates;
    }


    public static String[] getDate2(int amount) {
        String[] dates = new String[2];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        dates[0] = getMonthFirst(year, month);
        dates[1] = getMonthEnd(year, month);
        return dates;
    }


    public static String getMonthFirst(int year, int monthOfYear) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        // 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, monthOfYear);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();
        String str = simpleDateFormat.format(firstDate);
        return str;
    }


    public static String getMonthEnd(int year, int monthOfYear) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        // 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, monthOfYear);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = cal.getTime();
        String str = simpleDateFormat.format(lastDate);
        return str;
    }


    public static String getNewsDate(String time) {
        //刚刚，5分钟前，10分钟前，30分钟前，1小时前，3小时前，1天前，2天前，然后以后的都显示具体时间
        if (time.contains(".")) {
            String[] split = time.split("\\.");
            time = split[0];
        }
        //   2019-10-17T07:07:00
        long m2 = Calendar.getInstance().getTimeInMillis();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = dateFormat.parse(time);
            long m1 = date.getTime();
            int d = (int) ((m2 - m1) / (1000 * 60));
            if (d <= 0) {
                return "刚刚";
            } else if (d > 0 && d < 5) {
                return d + "分钟前";
            } else if (d >= 5 && d < 10) {
                return "5分钟前";
            } else if (d >= 10 && d < 30) {
                return "10分钟前";
            } else if (d >= 30 && d < 60) {
                return "30分钟前";
            } else if (d >= 60 && d < 180) {
                return "1小时前";
            } else if (d >= 180 && d < 1440) {
                return "3小时前";
            } else if (d >= 1440 && d < 2880) {
                return "1天前";
            } else if (d >= 2880 && d < 4320) {
                return "2天前";
            } else {
                return time.replaceAll("T", " ");
            }

        } catch (Exception e) {

        }

        return time.replaceAll("T", " ");

    }


}
