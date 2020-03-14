package com.example.godcode.ui.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.godcode.constant.Constant;
import com.example.godcode.greendao.gen.DaoMaster;
import com.example.godcode.greendao.gen.DaoSession;
import com.example.godcode.service.PushIntentService;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.RemberPsd;
import com.example.godcode.utils.RudenessScreenHelper;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

public class GodCodeApplication extends Application {

    private static GodCodeApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        requestPermission();
        instance = this;
        setDatabase();
        initWindowSize();
        initUmeng();
        CrashReport.initCrashReport(this, "6876c53e79", true);
        int designWidth = 1080;
        new RudenessScreenHelper(this, designWidth).activate();
    }

    private void requestPermission() {
        AndPermission.with(this)
                .runtime()
                .permission(Permission.ACCESS_FINE_LOCATION, Permission.WRITE_EXTERNAL_STORAGE, Permission.CAMERA, Permission.READ_CONTACTS)
                .onGranted(permissions -> {
                    // Storage permission are allowed.
                })
                .onDenied(permissions -> {
                    // Storage permission are not allowed.
                })
                .start();
    }

    private void initUmeng() {
        UMConfigure.init(this, "5b336c2bb27b0a6a4c00005c", "Umeng", UMConfigure.DEVICE_TYPE_PHONE,
                "6ecad4e50e60e9777228adc9d2e4ca91");
        PushAgent mPushAgent = PushAgent.getInstance(this);
        regiser(mPushAgent);
        mPushAgent.setPushIntentServiceClass(PushIntentService.class);
    }

    private void regiser(PushAgent mPushAgent) {
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Constant.diviceToken = deviceToken;
                LogUtil.log("--------dd-----" + deviceToken);
                Constant.diviceToken = deviceToken;
                Intent intent = new Intent();
                intent.setAction("refreshDeviceToken");
                sendBroadcast(intent);
                LogUtil.log("22========refreDeviceToken==========");
            }

            @Override
            public void onFailure(String s, String s1) {
                LogUtil.log(s + "-------faile--------" + s1);
                regiser(mPushAgent);
            }
        });
    }

    public void initWindowSize() {
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager mWindowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.getDefaultDisplay().getMetrics(metric);
        windownWidth = metric.widthPixels;
        windowHeight = metric.heightPixels;
        RemberPsd.getInstance().init(getApplicationContext());
    }

    private int windownWidth;
    private int windowHeight;

    public int getWindownWidth() {
        return windownWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public static GodCodeApplication getInstance() {
        return instance;
    }

    /**
     * 设置greenDao
     */
    private DaoSession mDaoSession;
    private SQLiteDatabase db;

    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);

        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
