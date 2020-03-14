package com.example.godcode.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DmGroupMsg {


    /**
     * result : {"mcFraction":0,"data":{"11":{"headImgUrl":null,"fK_UserID":11,"overMCFration":0,"goruoName":"穷开心","count":2},"21":{"headImgUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/YRr6oD4gXAGhxicIibho8mMdUfYvB4s12CjSnZicIC0zF1VaxEG9yDuOwViatWszHuuLjvj1nsicZnsPvtWsVJeZJgA/132","fK_UserID":21,"overMCFration":11,"goruoName":"口十金玉先森","count":1}}}
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private ResultBean result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }

    public void set__abp(boolean __abp) {
        this.__abp = __abp;
    }

    public static class ResultBean {
        /**
         * mcFraction : 0.0
         * data : {"11":{"headImgUrl":null,"fK_UserID":11,"overMCFration":0,"goruoName":"穷开心","count":2},"21":{"headImgUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/YRr6oD4gXAGhxicIibho8mMdUfYvB4s12CjSnZicIC0zF1VaxEG9yDuOwViatWszHuuLjvj1nsicZnsPvtWsVJeZJgA/132","fK_UserID":21,"overMCFration":11,"goruoName":"口十金玉先森","count":1}}
         */

        private int mcFraction;
        private boolean isGeneralAgent;
        private HashMap<String, DataBean> data;

        public boolean isGeneralAgent() {
            return isGeneralAgent;
        }

        public void setGeneralAgent(boolean generalAgent) {
            isGeneralAgent = generalAgent;
        }

        public int getMcFraction() {
            return mcFraction;
        }

        public void setMcFraction(int mcFraction) {
            this.mcFraction = mcFraction;
        }

        public HashMap<String, DataBean> getData() {
            return data;
        }

        public void setData(HashMap<String, DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * headImgUrl : null
             * fK_UserID : 11
             * overMCFration : 0.0
             * goruoName : 穷开心
             * count : 2
             */

            private String headImgUrl;
            private int fK_UserID;
            private int overMCFration;
            private String goruoName;
            private int count;

            public String getHeadImgUrl() {
                return headImgUrl;
            }

            public void setHeadImgUrl(String headImgUrl) {
                this.headImgUrl = headImgUrl;
            }

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public int getOverMCFration() {
                return overMCFration;
            }

            public void setOverMCFration(int overMCFration) {
                this.overMCFration = overMCFration;
            }

            public String getGoruoName() {
                return goruoName;
            }

            public void setGoruoName(String goruoName) {
                this.goruoName = goruoName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
