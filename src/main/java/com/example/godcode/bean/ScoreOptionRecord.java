package com.example.godcode.bean;

import android.text.TextUtils;

import com.example.godcode.utils.DateUtil;

import java.util.List;

public class ScoreOptionRecord {
    /**
     * result : {"code":0,"msg":null,"count":3,"data":[{"fK_UserID":116,"money":0,"fraction":100,"giveUserID":11,"type":1,"addDateTime":"2019-06-27T16:59:25.424","id":5},{"fK_UserID":11,"money":1,"fraction":10000,"giveUserID":11,"type":0,"addDateTime":"2019-06-25T18:37:11.743","id":2},{"fK_UserID":11,"money":1,"fraction":10000,"giveUserID":11,"type":0,"addDateTime":"2019-06-25T18:34:45.378","id":1}]}
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
         * code : 0
         * msg : null
         * count : 3
         * data : [{"fK_UserID":116,"money":0,"fraction":100,"giveUserID":11,"type":1,"addDateTime":"2019-06-27T16:59:25.424","id":5},{"fK_UserID":11,"money":1,"fraction":10000,"giveUserID":11,"type":0,"addDateTime":"2019-06-25T18:37:11.743","id":2},{"fK_UserID":11,"money":1,"fraction":10000,"giveUserID":11,"type":0,"addDateTime":"2019-06-25T18:34:45.378","id":1}]
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
             * fK_UserID : 116
             * money : 0.0
             * fraction : 100.0
             * giveUserID : 11
             * type : 1
             * addDateTime : 2019-06-27T16:59:25.424
             * id : 5
             */

            private int fK_UserID;
            private double money;
            private double fraction;
            private int giveUserID;
            private int type;
            private String addDateTime;
            private int id;

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
            }

            public double getFraction() {
                return fraction;
            }

            public void setFraction(double fraction) {
                this.fraction = fraction;
            }

            public int getGiveUserID() {
                return giveUserID;
            }

            public void setGiveUserID(int giveUserID) {
                this.giveUserID = giveUserID;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getAddDateTime() {
                if(!TextUtils.isEmpty(addDateTime)){
                    addDateTime= DateUtil.getInstance().formatDate(addDateTime);
                }
                return addDateTime;
            }

            public void setAddDateTime(String addDateTime) {
                this.addDateTime = addDateTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
