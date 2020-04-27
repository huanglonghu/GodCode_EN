package com.example.godcode_en.bean;

import android.text.TextUtils;

import com.example.godcode_en.utils.DateUtil;

/**
 * Created by Administrator on 2018/9/3.
 */

public class WebSocketNews3 {


    /**
     * EventType : 2
     * Data : {"msg":"您的好友'穷开心'同意了您的添加请求！"}
     * Flag : 407a4464-43ea-47c6-97ae-344b629910e2
     * SendTime : 2019-05-29T14:18:52.1836277+08:00
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
         * msg : 您的好友'穷开心'同意了您的添加请求！
         */

        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
