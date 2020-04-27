package com.example.godcode_en.bean;

import android.text.TextUtils;

import com.example.godcode_en.utils.DateUtil;

/**
 * Created by Administrator on 2018/7/31.
 */

public class WebSocketNews2 {


    /**
     * EventType : 6
     * Data : {"msg":"二维码收款入账0.1元！","RelatedKey":24447,"Id":32630,"TransactionType":2}
     * Flag : 471fd2f2-572c-48c2-bdb2-d8518f01dc81
     * SendTime : 2019-05-29T14:08:38.9006277+08:00
     */

    private int EventType;
    private DataBean Data;
    private String Flag;
    private String SendTime;

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int EventType) {
        this.EventType = EventType;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }

    public String getSendTime() {
        if(!TextUtils.isEmpty(SendTime)){
            SendTime= DateUtil.getInstance().formatDate(SendTime);
        }
        return SendTime;
    }

    public void setSendTime(String SendTime) {
        this.SendTime = SendTime;
    }

    public static class DataBean {
        /**
         * msg : 二维码收款入账0.1元！
         * RelatedKey : 24447
         * Id : 32630
         * TransactionType : 2
         */

        private String msg;
        private int RelatedKey;
        private int Id;
        private int TransactionType;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getRelatedKey() {
            return RelatedKey;
        }

        public void setRelatedKey(int RelatedKey) {
            this.RelatedKey = RelatedKey;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getTransactionType() {
            return TransactionType;
        }

        public void setTransactionType(int TransactionType) {
            this.TransactionType = TransactionType;
        }
    }
}
