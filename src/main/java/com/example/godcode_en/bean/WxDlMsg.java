package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/16.
 */

public class WxDlMsg {

    /**
     * errcode : 0
     * errmsg : success
     * data : {"subscribe":0,"openid":"oC3SO1s_AaZZJpL3FHYZjfYMs3qU","nickname":"keyd","sex":1,"language":"zh_CN","city":"Guangzhou","province":"Guangdong","country":"CN","headimgurl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIM5icsOStbNUvad5Jic1lX1iaKeUO03yN33cEI7yv6M4QqRrUJ8DyUrckF0TxW6kwG8Qch08ianHZJ0Q/132","subscribe_time":0,"remark":null,"groupid":0,"tagid_list":null,"unionid":"oyYiH1KvldeAK2w5MIjNcINvsLrA"}
     */

    private int errcode;
    private String errmsg;
    private DataBean data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * subscribe : 0
         * openid : oC3SO1s_AaZZJpL3FHYZjfYMs3qU
         * nickname : keyd
         * sex : 1
         * language : zh_CN
         * city : Guangzhou
         * province : Guangdong
         * country : CN
         * headimgurl : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIM5icsOStbNUvad5Jic1lX1iaKeUO03yN33cEI7yv6M4QqRrUJ8DyUrckF0TxW6kwG8Qch08ianHZJ0Q/132
         * subscribe_time : 0
         * remark : null
         * groupid : 0
         * tagid_list : null
         * unionid : oyYiH1KvldeAK2w5MIjNcINvsLrA
         */

        private int subscribe;
        private String openid;
        private String nickname;
        private int sex;
        private String language;
        private String city;
        private String province;
        private String country;
        private String headimgurl;
        private int subscribe_time;
        private Object remark;
        private int groupid;
        private Object tagid_list;
        private String unionid;

        public int getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(int subscribe) {
            this.subscribe = subscribe;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public int getSubscribe_time() {
            return subscribe_time;
        }

        public void setSubscribe_time(int subscribe_time) {
            this.subscribe_time = subscribe_time;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getGroupid() {
            return groupid;
        }

        public void setGroupid(int groupid) {
            this.groupid = groupid;
        }

        public Object getTagid_list() {
            return tagid_list;
        }

        public void setTagid_list(Object tagid_list) {
            this.tagid_list = tagid_list;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }
    }
}
