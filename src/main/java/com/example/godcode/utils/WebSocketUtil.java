package com.example.godcode.utils;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.godcode.bean.WebSocketNews1;
import com.example.godcode.bean.WebSocketNews2;
import com.example.godcode.bean.WebSocketNews3;
import com.example.godcode.bean.WebSocketNews4;
import com.example.godcode.bean.WsHeart;
import com.example.godcode.handler.WebSocketNewsHandler;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Subscription;

public class WebSocketUtil {
    private String TAG = "WebSocket:";
    private WebSocketClient mSocketClient;
    private static Disposable subscribe;
    private Subscription heartSubscribe;

    public WebSocketUtil() {}

    @SuppressLint("CheckResult")
    public void connect(String url) {
        Observable.create(new ObservableOnSubscribe<WebSocketNewsHandler.Builder>() {
            @Override
            public void subscribe(ObservableEmitter<WebSocketNewsHandler.Builder> e) throws Exception {
                HashMap<String, String> map = new HashMap<>();
                map.put("Language", "enUS");
                mSocketClient = new WebSocketClient(new URI(url), map) {
                    @Override
                    public void onOpen(ServerHandshake handshakedata) {
                        LogUtil.log(TAG + "打开通道" + handshakedata.getHttpStatus());
                        sendHeart();
                        if (subscribe != null) {
                            subscribe.dispose();
                            subscribe = null;
                        }
                    }

                    @Override
                    public void onMessage(String message) {
                     //   message="{\"EventType\":19,\"Data\":{\"ProductNumber\":\"T2\",\"CoinCount\":0,\"PaperMoney\":5.00,\"ScanQRMoney\":0.0,\"DivedeMoney\":0.0,\"CoinDivedeMoney\":5.00,\"MerchantUserIds\":\"26-11\",\"AwardPosition\":0,\"AwardCount\":0},\"Flag\":\"f8a9494b-010f-4ccf-a8bd-6f7f419f10bf\",\"SendTime\":\"2019-12-03T14:12:01.5160006+08:00\"}\n";

                        LogUtil.log(message);
                        WebSocketNewsHandler.Builder builder = new WebSocketNewsHandler.Builder();
                        String type = message.substring(message.indexOf("\"EventType\":") + "\"EventType\":".length(), message.indexOf(","));
                        analyWebSocketNews(type, message, builder);
                        e.onNext(builder);
                    }

                    @Override
                    public void onClose(int code, String reason, boolean remote) {
                        LogUtil.log(TAG + "通道关闭" + reason);
                        if (subscribe == null) {
                            synchronized (WebSocketUtil.class) {
                                if (subscribe == null) {
                                    subscribe = Observable.interval(0, 5, TimeUnit.SECONDS).subscribe(
                                            s -> {
                                                if (s == 1) {
                                                    mSocketClient.reconnect();
                                                    subscribe.dispose();
                                                    subscribe = null;
                                                }
                                            }
                                    );
                                }
                            }
                        }
                    }

                    @Override
                    public void onError(Exception ex) {
                        LogUtil.log(TAG + "链接错误" + ex.toString());

                    }
                };

                mSocketClient.connect();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                builder -> {
                    WebSocketNewsHandler webSocketNewsHandler = builder.build();
                    webSocketNewsHandler.setNofication();
                    getStrategyByType(webSocketNewsHandler);
                }
        );
    }


    public void analyWebSocketNews(String type, String message, WebSocketNewsHandler.Builder builder) {
        builder.eventType(type);
        switch (type) {
            case "19":
                WebSocketNews1 webSocketNews1 = GsonUtil.getInstance().fromJson(message, WebSocketNews1.class);
                builder.webSocketNews1(webSocketNews1);
                break;
            case "4":
            case "5":
            case "6":
            case "8":
            case "10":
            case "11":
                WebSocketNews2 webSocketNews2 = GsonUtil.getInstance().fromJson(message, WebSocketNews2.class);
                builder.webSocketNews2(webSocketNews2);
            case "12":
                WebSocketNews4 webSocketNews4 = GsonUtil.getInstance().fromJson(message, WebSocketNews4.class);
                builder.webSocketNews4(webSocketNews4);
                break;
            case "1":
            case "2":
            case "3":
            case "7":
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "18":
            case "22":
            case "23":
            case "24":
            case "25":
            case "26":
            case "27":
            case "28":
                WebSocketNews3 webSocketNews3 = GsonUtil.getInstance().fromJson(message, WebSocketNews3.class);
                builder.webSocketNews3(webSocketNews3);
                break;
            case "21":
                WsHeart wsHeart = GsonUtil.getInstance().fromJson(message, WsHeart.class);
                builder.wsHeart(wsHeart);
                break;
        }
    }

    // {"EventType":28,"Data":{"msg":"设备'SY3F5'电量过低，请充电！"},"Flag":"5f25d516-edf0-4ae0-ac06-989815245164","SendTime":"2019-09-21T11:26:40.203539+08:00"}
    public void getStrategyByType(WebSocketNewsHandler webSocketNewsHandler) {
        switch (webSocketNewsHandler.getEventType()) {
            case "2":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_ADDFRIEND_SUCCESS));
                break;
            case "3":
            case "7":
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "18":
            case "28":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_REFRESH_NOTIFICATION));
                break;
            case "9":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_EXIT));
                break;
            case "12":
                RxEvent rxEvent = new RxEvent(EventType.EVENTTYPE_DELETE_FRIEND);
                rxEvent.setId(webSocketNewsHandler.getWebSocketNews4().getData().getRelatedKey());
                RxBus.getInstance().post(rxEvent);
                break;
            case "1":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_ADDFRIEND));
                break;
            case "19":
                RxEvent rxEvent2 = new RxEvent(EventType.EVENTTYPE_DIVIDE_MSG);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("dataBean", webSocketNewsHandler.getWebSocketNews1().getData());
                rxEvent2.setBundle(bundle1);
                RxBus.getInstance().post(rxEvent2);
                break;
            case "4":
            case "5":
            case "6":
            case "8":
            case "10":
            case "11":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_BALANCE_CHANGE));
                break;
            case "21":
                RxEvent rxEvent1 = new RxEvent(EventType.EVENTTYPE_HEART);
                Bundle bundle = new Bundle();
                bundle.putSerializable("heart", webSocketNewsHandler.getWsHeart());
                rxEvent1.setBundle(bundle);
                RxBus.getInstance().post(rxEvent1);
                break;
            case "22":
            case "23":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_APPLAY_SCORE));
                break;
            case "24":
            case "25":
            case "26":
            case "27":
                RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_REFRESH_SCORE));
                break;
        }

    }


    // 1 请求添加好友 您有一条好友请求！   /**
    //     * EventType : 1
    //     * Data : {"msg":"用户'sy1535799652'请求添加您为好友！"}
    //     */
    // 2 同意添加好友 您的好友'{0}'同意了您的添加请求！
    // {"EventType":3,"Data":{"msg":"您绑定的银行卡已审核通过！"}}
    //4 提现成功 您的提现已成功
    // 5好友转账 您的好友向您转账
    // 6二维码收款 您有新的二维码收款入账
    // {"EventType":7,"Data":{"msg":"您绑定的银行卡审核不通过！"}}
    //8 提现失败  "您的提现申请审核失败已驳回！
    // 9接收消息{"EventType":9,"Data":{"msg":"该账户已在其他设备登录！"}}
    //10 您的退款已到账
    //11 您的产品营收已到账
    //WebSocket:接收消息{"EventType":12,"Data":{"msg":"删除好友","RelatedKey":20109}}
    //{"EventType":11,"Data":{"msg":"您的产品营收已转入您的余额！","RelatedKey":10313,"Id":50942,"TransactionType":9}}
    //{"EventType":13,"Data":{"msg":"您已获得新设备'xdq'的分成比例'10%'！"}}
    //{"EventType":14,"Data":{"msg":"设备'xdq'的分成比例已变更为'1%'！"}}
    //{"EventType":15,"Data":{"msg":"主商家已删除您对设备'xdq''的分成占比！"}}
    //  {"EventType":19,"Data":{"ProductNumber":"SY143","CoinCount":3,"PaperMoney":0.0,"ScanQRMoney":0.0,"DivedeMoney":0.0,"MerchantUserIds":"26/29"},"Flag":"6159558f-f4a1-4c77-8f43-94903cd9407e"}
    public void stopWebSocket() {
        if (mSocketClient != null) {
            mSocketClient.close();
        }
    }

    public void sendHeart() {

        if (heartSubscribe == null) {
            heartSubscribe = rx.Observable.interval(0, 30, TimeUnit.SECONDS, rx.schedulers.Schedulers.io()).subscribe(
                    (Long time) -> {
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("EventType", 20);
                            JSONObject data = new JSONObject();
                            jsonObject.put("Data", data);
                            String s = jsonObject.toString();
                            mSocketClient.send(s);
                        } catch (Exception e) {
                            LogUtil.log("-----心跳异常------" + e.toString());
                        }
                    }
            );
        }

    }


}
