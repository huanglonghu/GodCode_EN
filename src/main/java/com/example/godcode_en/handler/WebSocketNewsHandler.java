package com.example.godcode_en.handler;

import com.example.godcode_en.bean.WebSocketNews1;
import com.example.godcode_en.bean.WebSocketNews2;
import com.example.godcode_en.bean.WebSocketNews3;
import com.example.godcode_en.bean.WebSocketNews4;
import com.example.godcode_en.bean.WsHeart;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.greendao.entity.Notification;
import com.example.godcode_en.greendao.option.NotificationOption;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebSocketNewsHandler {

    private WebSocketNews1 webSocketNews1;
    private WebSocketNews2 webSocketNews2;
    private WebSocketNews3 webSocketNews3;
    private WebSocketNews4 webSocketNews4;
    private WsHeart wsHeart;
    private int handlerType;
    private String eventType;

    private WebSocketNewsHandler(Builder builder) {
        this.webSocketNews1 = builder.webSocketNews1;
        this.webSocketNews2 = builder.webSocketNews2;
        this.webSocketNews3 = builder.webSocketNews3;
        this.webSocketNews4 = builder.webSocketNews4;
        this.wsHeart = builder.wsHeart;
        this.handlerType = builder.handlerType;
        this.eventType = builder.eventType;
    }

    //{"EventType":22,"Data":{"msg":"'13250554787'向您申请'100'积分！"},"Flag":"78a31ef8-5f59-4f06-8da6-073eab619628","SendTime":"2019-06-27T16:59:26.184+08:00"}
    public void setNofication() {
        Notification notification = new Notification();
        switch (eventType) {
            case "1":
            case "2":
            case "28":
                notification.setContent(webSocketNews3.getData().getMsg());
                notification.setDate(webSocketNews3.getSendTime());
                notification.setType(3);
                break;
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "18":
                notification.setContent(webSocketNews3.getData().getMsg());
                notification.setDate(webSocketNews3.getSendTime());
                notification.setType(4);
                break;
            case "3":
            case "7":
                notification.setContent(webSocketNews3.getData().getMsg());
                notification.setDate(webSocketNews3.getSendTime());
                notification.setType(2);
                break;
            case "4":
            case "5":
            case "6":
            case "8":
            case "10":
            case "11":
                notification.setContent(webSocketNews2.getData().getMsg());
                notification.setRelatedKey(webSocketNews2.getData().getRelatedKey());
                notification.setTransactionId(webSocketNews2.getData().getId());
                notification.setTransactionType(webSocketNews2.getData().getTransactionType());
                notification.setType(1);
                notification.setDate(webSocketNews2.getSendTime());
                break;
            case "22":
            case "23":
            case "24":
            case "25":
            case "26":
            case "27":
                notification.setContent(webSocketNews3.getData().getMsg());
                notification.setDate(webSocketNews3.getSendTime());
                notification.setType(5);
                break;
        }
        if (notification.getType() != 0) {
            notification.setUserId(Constant.userId);
            notification.setDate(getDate());
            int i = Integer.parseInt(eventType);
            String title = titleArray[i - 1];
            notification.setTitle(title);
            NotificationOption.getInstance().memoryNotification(notification);
        }
    }


    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        return sdf.format(now);
    }

    String[] titleArray = {"Request to add friends", "Agree to add friends", "Bank card approved successfully", "Withdrawal success", "Friends transfer", "Qr code payment", "Bank card audit failed", "Withdrawal of failure", "Abnormal login", "Refund to the account",
            "Product camp received the account", "Remove buddy", "Assets are divided into", "Modified asset sharing", "Delete asset sharing", "Unbind assets", "Property to return it", "Transfer of property rights", "Revenue is divided into", "", "", "Application integration", "Return the integral", "Applications for points were rejected", "Credits returned are rejected",
            "The application for points has been approved", "Return credits passed","Power is too low"
    };

    public static class Builder {
        private WebSocketNews1 webSocketNews1;
        private WebSocketNews2 webSocketNews2;
        private WebSocketNews3 webSocketNews3;
        private WebSocketNews4 webSocketNews4;
        private WsHeart wsHeart;
        private int handlerType;
        private String eventType;

        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder handlerType(int handlerType) {
            this.handlerType = handlerType;
            return this;
        }

        public Builder webSocketNews1(WebSocketNews1 webSocketNews1) {
            this.webSocketNews1 = webSocketNews1;
            return this;
        }

        public Builder webSocketNews2(WebSocketNews2 webSocketNews2) {
            this.webSocketNews2 = webSocketNews2;
            return this;
        }

        public Builder webSocketNews3(WebSocketNews3 webSocketNews3) {
            this.webSocketNews3 = webSocketNews3;
            return this;
        }

        public Builder webSocketNews4(WebSocketNews4 webSocketNews4) {
            this.webSocketNews4 = webSocketNews4;
            return this;
        }


        public Builder wsHeart(WsHeart wsHeart) {
            this.wsHeart = wsHeart;
            return this;
        }


        public WebSocketNewsHandler build() {
            return new WebSocketNewsHandler(this);
        }


    }


    public WebSocketNews1 getWebSocketNews1() {
        return webSocketNews1;
    }

    public void setWebSocketNews1(WebSocketNews1 webSocketNews1) {
        this.webSocketNews1 = webSocketNews1;
    }

    public WebSocketNews2 getWebSocketNews2() {
        return webSocketNews2;
    }

    public void setWebSocketNews2(WebSocketNews2 webSocketNews2) {
        this.webSocketNews2 = webSocketNews2;
    }

    public WebSocketNews3 getWebSocketNews3() {
        return webSocketNews3;
    }

    public void setWebSocketNews3(WebSocketNews3 webSocketNews3) {
        this.webSocketNews3 = webSocketNews3;
    }

    public WebSocketNews4 getWebSocketNews4() {
        return webSocketNews4;
    }

    public void setWebSocketNews4(WebSocketNews4 webSocketNews4) {
        this.webSocketNews4 = webSocketNews4;
    }

    public WsHeart getWsHeart() {
        return wsHeart;
    }

    public void setWsHeart(WsHeart wsHeart) {
        this.wsHeart = wsHeart;
    }

    public int getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(int handlerType) {
        this.handlerType = handlerType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}


