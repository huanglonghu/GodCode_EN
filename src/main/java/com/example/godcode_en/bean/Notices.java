package com.example.godcode_en.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */

public class Notices {

    /**
     * code : 0
     * msg : null
     * count : 3
     * data : [{"id":13,"noticeTitle":"aaaa","titlePageImgUrl":null,"noticeContent":"<p>aaaaaaaaaaaaaaaaaaaaaa<\/p>","isTop":false,"fK_UserIDPublish":2,"publishUserName":"admin","publishTime":"2018-08-04T17:37:17.1118448","isValid":true,"exporation":null,"updateTime":null,"updateUserID":null,"updateUserName":""},{"id":14,"noticeTitle":"bbbb","titlePageImgUrl":null,"noticeContent":"<p>bbbbbbbbbbbbbb<\/p>","isTop":false,"fK_UserIDPublish":2,"publishUserName":"admin","publishTime":"2018-08-04T17:37:32.4184718","isValid":true,"exporation":null,"updateTime":null,"updateUserID":null,"updateUserName":""},{"id":15,"noticeTitle":"测试啊!!!!!!","titlePageImgUrl":null,"noticeContent":"<p>&nbsp; &nbsp; &nbsp; &nbsp;测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试<\/p><p>&nbsp; &nbsp; &nbsp; 测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试<\/p><p>&nbsp; &nbsp; &nbsp; &nbsp;测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试<br><\/p><p><img src=\"http:\\\\192.200.109.162:8011\\Files\\Pictures\\Notice\\254a491e-923b-450f-bf1b-7a137df1c1e8.jpg\" style=\"max-width:100%;\"><br><\/p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\"><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3c/pcmoren_wu_org.png\" alt=\"[污]\" data-w-e=\"1\">好漂亮的小姐姐<br><\/p>","isTop":false,"fK_UserIDPublish":2,"publishUserName":"admin","publishTime":"2018-08-04T17:39:39.6308975","isValid":true,"exporation":null,"updateTime":null,"updateUserID":null,"updateUserName":""}]
     */

    private int code;
    private Object msg;
    private int count;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 13
         * noticeTitle : aaaa
         * titlePageImgUrl : null
         * noticeContent : <p>aaaaaaaaaaaaaaaaaaaaaa</p>
         * isTop : false
         * fK_UserIDPublish : 2
         * publishUserName : admin
         * publishTime : 2018-08-04T17:37:17.1118448
         * isValid : true
         * exporation : null
         * updateTime : null
         * updateUserID : null
         * updateUserName :
         */

        private int id;
        private String noticeTitle;
        private String titlePageImgUrl;
        private String noticeContent;
        private boolean isTop;
        private int fK_UserIDPublish;
        private String publishUserName;
        private String publishTime;
        private boolean isValid;
        private Object exporation;
        private Object updateTime;
        private Object updateUserID;
        private String updateUserName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNoticeTitle() {
            return noticeTitle;
        }

        public void setNoticeTitle(String noticeTitle) {
            this.noticeTitle = noticeTitle;
        }

        public String getTitlePageImgUrl() {
            return titlePageImgUrl;
        }

        public void setTitlePageImgUrl(String titlePageImgUrl) {
            this.titlePageImgUrl = titlePageImgUrl;
        }

        public String getNoticeContent() {
            return noticeContent;
        }

        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }

        public boolean isIsTop() {
            return isTop;
        }

        public void setIsTop(boolean isTop) {
            this.isTop = isTop;
        }

        public int getFK_UserIDPublish() {
            return fK_UserIDPublish;
        }

        public void setFK_UserIDPublish(int fK_UserIDPublish) {
            this.fK_UserIDPublish = fK_UserIDPublish;
        }

        public String getPublishUserName() {
            return publishUserName;
        }

        public void setPublishUserName(String publishUserName) {
            this.publishUserName = publishUserName;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public boolean isIsValid() {
            return isValid;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }

        public Object getExporation() {
            return exporation;
        }

        public void setExporation(Object exporation) {
            this.exporation = exporation;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getUpdateUserID() {
            return updateUserID;
        }

        public void setUpdateUserID(Object updateUserID) {
            this.updateUserID = updateUserID;
        }

        public String getUpdateUserName() {
            return updateUserName;
        }

        public void setUpdateUserName(String updateUserName) {
            this.updateUserName = updateUserName;
        }
    }
}
