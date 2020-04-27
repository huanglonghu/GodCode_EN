package com.example.godcode_en.bean;

import java.util.List;

public class CoinDivideRecord {


    /**
     * result : {"currentIncome":4,"frontIncome":0,"sumIncome":0,"code":0,"msg":null,"count":4,"data":[{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T19:02:19.317","id":5},{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T18:56:52.94","id":4},{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T18:54:07.077","id":3},{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T10:43:32.03","id":1}]}
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
         * currentIncome : 4.0
         * frontIncome : 0.0
         * sumIncome : 0.0
         * code : 0
         * msg : null
         * count : 4
         * data : [{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T19:02:19.317","id":5},{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T18:56:52.94","id":4},{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T18:54:07.077","id":3},{"fK_ProductID":20972,"productName":"124G","productNumber":"SY12","divideAmount":1,"divideRate":100,"addDatetime":"2019-11-14T10:43:32.03","id":1}]
         */

        private double currentIncome;
        private double frontIncome;
        private double sumIncome;
        private int code;
        private Object msg;
        private int count;
        private List<DataBean> data;

        public double getCurrentIncome() {
            return currentIncome;
        }

        public void setCurrentIncome(double currentIncome) {
            this.currentIncome = currentIncome;
        }

        public double getFrontIncome() {
            return frontIncome;
        }

        public void setFrontIncome(double frontIncome) {
            this.frontIncome = frontIncome;
        }

        public double getSumIncome() {
            return sumIncome;
        }

        public void setSumIncome(double sumIncome) {
            this.sumIncome = sumIncome;
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
             * fK_ProductID : 20972
             * productName : 124G
             * productNumber : SY12
             * divideAmount : 1.0
             * divideRate : 100
             * addDatetime : 2019-11-14T19:02:19.317
             * id : 5
             */

            private int fK_ProductID;
            private String productName;
            private String productNumber;
            private double divideAmount;
            private int divideRate;
            private String addDatetime;
            private int id;

            public int getFK_ProductID() {
                return fK_ProductID;
            }

            public void setFK_ProductID(int fK_ProductID) {
                this.fK_ProductID = fK_ProductID;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductNumber() {
                return productNumber;
            }

            public void setProductNumber(String productNumber) {
                this.productNumber = productNumber;
            }

            public double getDivideAmount() {
                return divideAmount;
            }

            public void setDivideAmount(double divideAmount) {
                this.divideAmount = divideAmount;
            }

            public int getDivideRate() {
                return divideRate;
            }

            public void setDivideRate(int divideRate) {
                this.divideRate = divideRate;
            }

            public String getAddDatetime() {
                return addDatetime;
            }

            public void setAddDatetime(String addDatetime) {
                this.addDatetime = addDatetime;
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
