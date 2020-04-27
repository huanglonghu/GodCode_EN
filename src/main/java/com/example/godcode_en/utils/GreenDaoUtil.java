package com.example.godcode_en.utils;

import android.database.sqlite.SQLiteDatabase;

import com.example.godcode_en.greendao.gen.DaoMaster;
import com.example.godcode_en.greendao.gen.DaoSession;
import com.example.godcode_en.ui.base.GodCodeApplication;

/**
 * Created by Administrator on 2018/8/9.
 */

public class GreenDaoUtil {

    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static class GreenDaoUtilsHolder {
        private static final GreenDaoUtil INSTANCE = new GreenDaoUtil();
    }

    private GreenDaoUtil() {
    }

    public static GreenDaoUtil getSingleton() {
        return GreenDaoUtilsHolder.INSTANCE;
    }

    private void initGreenDao() {
        //临时数据使用
        DBUtil dbUtil = new DBUtil();
        db =dbUtil.openDatabase(GodCodeApplication.getInstance());
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        if (mDaoMaster == null) {
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            initGreenDao();
        }
        return db;
    }
}
