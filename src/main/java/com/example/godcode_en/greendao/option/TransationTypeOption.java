package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.TransationName;
import com.example.godcode_en.greendao.entity.TranscationType;
import com.example.godcode_en.greendao.gen.TransationNameDao;
import com.example.godcode_en.greendao.gen.TranscationTypeDao;
import com.example.godcode_en.ui.base.GodCodeApplication;

import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */

public class TransationTypeOption {
    private TransationTypeOption() {
    }

    private static TransationTypeOption defaultInstance;

    public static TransationTypeOption getInstance() {
        TransationTypeOption transationOption = defaultInstance;
        if (defaultInstance == null) {
            synchronized (TransationTypeOption.class) {
                if (defaultInstance == null) {
                    transationOption = new TransationTypeOption();
                    defaultInstance = transationOption;
                }
            }
        }

        return transationOption;
    }


    public List<TranscationType> querryTransationNames() {
        TranscationTypeDao ttd = GodCodeApplication.getInstance().getDaoSession().getTranscationTypeDao();
        List<TranscationType> transcationTypes = ttd.loadAll();
        if(transcationTypes.size()>0){
            return transcationTypes;
        }else {
            return null;
        }
    }

    public void insertTransationType(String transationName, String transationId) {
        TranscationTypeDao ttd = GodCodeApplication.getInstance().getDaoSession().getTranscationTypeDao();
        TranscationType tt = new TranscationType(transationName, transationId);
        ttd.insert(tt);
    }

    public String getTransationId(String transationType){
        TransationNameDao transationNameDao = GodCodeApplication.getInstance().getDaoSession().getTransationNameDao();
        TransationName transationName = transationNameDao.queryBuilder().where(TransationNameDao.Properties.TransationId.eq(transationType)).unique();
        return transationName.getTransationName();
    }

}
