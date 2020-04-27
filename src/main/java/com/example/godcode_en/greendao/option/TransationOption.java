package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.TransationName;
import com.example.godcode_en.greendao.gen.TransationNameDao;
import com.example.godcode_en.ui.base.GodCodeApplication;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */

public class TransationOption {
    private TransationOption() {
    }

    private static TransationOption defaultInstance;

    public static TransationOption getInstance() {
        TransationOption transationOption = defaultInstance;
        if (defaultInstance == null) {
            synchronized (TransationOption.class) {
                if (defaultInstance == null) {
                    transationOption = new TransationOption();
                    defaultInstance = transationOption;
                }
            }
        }

        return transationOption;
    }


    public List<TransationName> querryTransationNames() {
        TransationNameDao transationNameDao = GodCodeApplication.getInstance().getDaoSession().getTransationNameDao();
        List<TransationName> transationNames = transationNameDao.loadAll();
        if(transationNames.size()>0){
            return transationNames;
        }else {
            return null;
        }
    }

    public void insertTransationName(String transationName, String transationId) {
        TransationNameDao transationNameDao = GodCodeApplication.getInstance().getDaoSession().getTransationNameDao();
        TransationName unique = transationNameDao.queryBuilder().where(TransationNameDao.Properties.TransationName.eq(transationName),
                TransationNameDao.Properties.TransationId.eq(transationId)).unique();
        if(unique == null){
            TransationName tn = new TransationName(transationName, transationId);
            transationNameDao.insert(tn);
        }
    }

    public String getTransationName(int transationId){
        TransationNameDao transationNameDao = GodCodeApplication.getInstance().getDaoSession().getTransationNameDao();
        TransationName transationName = transationNameDao.queryBuilder().where(TransationNameDao.Properties.TransationId.eq(transationId)).unique();
        return transationName.getTransationName();
    }
}
