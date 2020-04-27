package com.example.godcode_en.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/30.
 */

public class WsHeart implements Serializable {

    /**
     * EventType : 21
     * Data : {"IOSVer":"2.2.3","AndroidVer":"2.2.3","IOSVerDes":"1.修改已知BUG,优化用户体验|2.增加产品设置及退礼展示","AndroidVerDes":"1.修改资产页面|2.优化主界面","UpdateAddress":"https://gcp.app.d.godcode.me?pla?platform=godcode2"}
     * Flag : 89c49e58-09ff-431d-a049-71efc61d59cb
     */

    private int EventType;
    private DataBean Data;
    private String Flag;

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

    public static class DataBean {
        /**
         * IOSVer : 2.2.3
         * AndroidVer : 2.2.3
         * IOSVerDes : 1.修改已知BUG,优化用户体验|2.增加产品设置及退礼展示
         * AndroidVerDes : 1.修改资产页面|2.优化主界面
         * UpdateAddress : https://gcp.app.d.godcode.me?pla?platform=godcode2
         */

        private String IOSVer;
        private String AndroidVer;
        private String IOSVerDes;
        private String AndroidVerDes;
        private String UpdateAddress;

        public String getIOSVer() {
            return IOSVer;
        }

        public void setIOSVer(String IOSVer) {
            this.IOSVer = IOSVer;
        }

        public String getAndroidVer() {
            return AndroidVer;
        }

        public void setAndroidVer(String AndroidVer) {
            this.AndroidVer = AndroidVer;
        }

        public String getIOSVerDes() {
            return IOSVerDes;
        }

        public void setIOSVerDes(String IOSVerDes) {
            this.IOSVerDes = IOSVerDes;
        }

        public String getAndroidVerDes() {
            return AndroidVerDes;
        }

        public void setAndroidVerDes(String AndroidVerDes) {
            this.AndroidVerDes = AndroidVerDes;
        }

        public String getUpdateAddress() {
            return UpdateAddress;
        }

        public void setUpdateAddress(String UpdateAddress) {
            this.UpdateAddress = UpdateAddress;
        }
    }
}
