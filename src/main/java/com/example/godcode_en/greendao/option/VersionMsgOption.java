package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.VersionMsg;
import com.example.godcode_en.greendao.gen.VersionMsgDao;
import com.example.godcode_en.ui.base.GodCodeApplication;

import java.util.List;

/**
 * Created by Administrator on 2018/10/31.
 */

public class VersionMsgOption {
    private VersionMsgOption() {
    }

    private static VersionMsgOption defaultInstance;

    public static VersionMsgOption getInstance() {

        VersionMsgOption userOption = defaultInstance;
        if (defaultInstance == null) {
            synchronized (UserOption.class) {
                if (defaultInstance == null) {
                    userOption = new VersionMsgOption();
                    defaultInstance = userOption;
                }
            }
        }
        return userOption;
    }


    public VersionMsg querryVersion() {
        VersionMsgDao versionMsgDao = GodCodeApplication.getInstance().getDaoSession().getVersionMsgDao();
        List<VersionMsg> versionMsgs = versionMsgDao.loadAll();
        if (versionMsgs.size() > 0) {
            return versionMsgs.get(0);
        } else {
            return null;
        }

    }

    public void updateVersion(String versionCode, String versionDes) {
        VersionMsgDao versionMsgDao = GodCodeApplication.getInstance().getDaoSession().getVersionMsgDao();
        versionMsgDao.deleteAll();
        VersionMsg versionMsg = new VersionMsg(versionCode, versionDes);
        versionMsgDao.insert(versionMsg);
    }
}
