package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/9/3.
 */

public class WebSocketNews4 {


    /**
     * EventType : 12
     * Data : {"msg":"删除好友","RelatedKey":20109}
     */

    private int EventType;
    private DataBean Data;

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

    public static class DataBean {
        /**
         * msg : 删除好友
         * RelatedKey : 20109
         */

        private String msg;
        private int RelatedKey;

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
    }
}
