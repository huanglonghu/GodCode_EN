package com.example.godcode.bean;

import java.util.List;

public class TxsyResponse {

    /**
     * result : {"incomeSumMoney":0.1,"code":0,"msg":null,"count":1,"data":[{"putMoneyUserName":"666666","putMoney":1,"incomeMoney":0.1,"putTime":"2019-09-19T17:53:34.8984009"}]}
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
         * incomeSumMoney : 0.1
         * code : 0
         * msg : null
         * count : 1
         * data : [{"putMoneyUserName":"666666","putMoney":1,"incomeMoney":0.1,"putTime":"2019-09-19T17:53:34.8984009"}]
         */

        private double incomeSumMoney;
        private int code;
        private Object msg;
        private int count;
        private List<DataBean> data;

        public double getIncomeSumMoney() {
            return incomeSumMoney;
        }

        public void setIncomeSumMoney(double incomeSumMoney) {
            this.incomeSumMoney = incomeSumMoney;
        }

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
             * putMoneyUserName : 666666
             * putMoney : 1.0
             * incomeMoney : 0.1
             * putTime : 2019-09-19T17:53:34.8984009
             */

            private String putMoneyUserName;
            private double putMoney;
            private double incomeMoney;
            private String putTime;

            public String getPutMoneyUserName() {
                return putMoneyUserName;
            }

            public void setPutMoneyUserName(String putMoneyUserName) {
                this.putMoneyUserName = putMoneyUserName;
            }

            public double getPutMoney() {
                return putMoney;
            }

            public void setPutMoney(double putMoney) {
                this.putMoney = putMoney;
            }

            public double getIncomeMoney() {
                return incomeMoney;
            }

            public void setIncomeMoney(double incomeMoney) {
                this.incomeMoney = incomeMoney;
            }

            public String getPutTime() {
                return putTime;
            }

            public void setPutTime(String putTime) {
                this.putTime = putTime;
            }
        }
    }
}
