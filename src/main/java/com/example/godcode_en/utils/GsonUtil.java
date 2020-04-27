package com.example.godcode_en.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/7/17.
 */

public class GsonUtil {



    private GsonUtil() {

    }

    private static GsonUtil defaultInstance;

    public static GsonUtil getInstance() {
        GsonUtil gsonUtil = defaultInstance;
        if (defaultInstance == null) {
            synchronized (GsonUtil.class) {
                gsonUtil = new GsonUtil();
                defaultInstance = gsonUtil;
            }
        }

        return gsonUtil;
    }


    private static Gson gson = new GsonBuilder().create();

    public static String toJson(Object value) {
        return gson.toJson(value);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonParseException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonParseException {
        return (T) gson.fromJson(json, typeOfT);
    }


}
