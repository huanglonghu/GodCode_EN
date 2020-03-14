package com.example.godcode.bean;

import android.text.TextUtils;

import com.example.godcode.utils.DateUtil;

import java.util.List;

public class McUnlockDetail  {


    /**
     * result : {"code":0,"msg":null,"count":1,"data":[{"fK_UserID":11,"fK_MCProductID":12,"mcProductName":"5","mcProductNumber":"5","helpUserID":11,"helpUserName":"穷开心","currentProfit":2,"addDateTime":"2019-06-27T11:12:55.901406","id":4}]}
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
         * count : 1
         * data : [{"fK_UserID":11,"fK_MCProductID":12,"mcProductName":"5","mcProductNumber":"5","helpUserID":11,"helpUserName":"穷开心","currentProfit":2,"addDateTime":"2019-06-27T11:12:55.901406","id":4}]
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
             * fK_UserID : 11
             * fK_MCProductID : 12
             * mcProductName : 5
             * mcProductNumber : 5
             * helpUserID : 11
             * helpUserName : 穷开心
             * currentProfit : 2
             * addDateTime : 2019-06-27T11:12:55.901406
             * id : 4
             */

            private int fK_UserID;
            private int fK_MCProductID;
            private String mcProductName;
            private String mcProductNumber;
            private int helpUserID;
            private String helpUserName;
            private int currentProfit;
            private String addDateTime;
            private int id;

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public int getFK_MCProductID() {
                return fK_MCProductID;
            }

            public void setFK_MCProductID(int fK_MCProductID) {
                this.fK_MCProductID = fK_MCProductID;
            }

            public String getMcProductName() {
                return mcProductName;
            }

            public void setMcProductName(String mcProductName) {
                this.mcProductName = mcProductName;
            }

            public String getMcProductNumber() {
                return mcProductNumber;
            }

            public void setMcProductNumber(String mcProductNumber) {
                this.mcProductNumber = mcProductNumber;
            }

            public int getHelpUserID() {
                return helpUserID;
            }

            public void setHelpUserID(int helpUserID) {
                this.helpUserID = helpUserID;
            }

            public String getHelpUserName() {
                return helpUserName;
            }

            public void setHelpUserName(String helpUserName) {
                this.helpUserName = helpUserName;
            }

            public int getCurrentProfit() {
                return currentProfit;
            }

            public void setCurrentProfit(int currentProfit) {
                this.currentProfit = currentProfit;
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
