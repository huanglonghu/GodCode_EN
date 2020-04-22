package com.example.godcode.bean;

import android.text.TextUtils;
import android.util.TimeUtils;

import com.example.godcode.utils.TimeUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 */

public class YSRecord {


    /**
     * result : {"returnSumMoney":0,"incomeSumMoney":22,"allSumMoney":22,"code":0,"msg":null,"count":58,"data":[{"orderNumber":"T5B9CEA9AB951E","fK_ProductID":14,"productName":"","productOwnerName":"sy1535984040","payUserName":"sy1535989178","productNumber":"SY39","feeType":"CNY","sumOrder":1,"orderStatus":1,"orderDate":"2018-09-15T11:18:50.0701307","refundDate":null,"payDate":"2018-09-15T11:18:57.7453442","divideMoney":0.3,"divideRate":30,"isRefund":false,"isCapableRefund":true,"id":478}]}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * returnSumMoney : 0.0
         * incomeSumMoney : 22.0
         * allSumMoney : 22.0
         * code : 0
         * msg : null
         * count : 58
         * data : [{"orderNumber":"T5B9CEA9AB951E","fK_ProductID":14,"productName":"","productOwnerName":"sy1535984040","payUserName":"sy1535989178","productNumber":"SY39","feeType":"CNY","sumOrder":1,"orderStatus":1,"orderDate":"2018-09-15T11:18:50.0701307","refundDate":null,"payDate":"2018-09-15T11:18:57.7453442","divideMoney":0.3,"divideRate":30,"isRefund":false,"isCapableRefund":true,"id":478}]
         */

        private double returnSumMoney;
        private double incomeSumMoney;
        private double allSumMoney;
        private int code;
        private Object msg;
        private int count;
        private List<DataBean> data;

        public double getReturnSumMoney() {
            return returnSumMoney;
        }

        public void setReturnSumMoney(double returnSumMoney) {
            this.returnSumMoney = returnSumMoney;
        }

        public double getIncomeSumMoney() {
            return incomeSumMoney;
        }

        public void setIncomeSumMoney(double incomeSumMoney) {
            this.incomeSumMoney = incomeSumMoney;
        }

        public double getAllSumMoney() {
            return allSumMoney;
        }

        public void setAllSumMoney(double allSumMoney) {
            this.allSumMoney = allSumMoney;
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

        public static class DataBean implements Serializable{
            /**
             * orderNumber : T5B9CEA9AB951E
             * fK_ProductID : 14
             * productName :
             * productOwnerName : sy1535984040
             * payUserName : sy1535989178
             * productNumber : SY39
             * feeType : CNY
             * sumOrder : 1.0
             * orderStatus : 1
             * orderDate : 2018-09-15T11:18:50.0701307
             * refundDate : null
             * payDate : 2018-09-15T11:18:57.7453442
             * divideMoney : 0.3
             * divideRate : 30
             * isRefund : false
             * isCapableRefund : true
             * id : 478
             */

            private String orderNumber;
            private int fK_ProductID;
            private String productName;
            private String productOwnerName;
            private String payUserName;
            private String productNumber;
            private String feeType;
            private double sumOrder;
            private int orderStatus;
            private String orderDate;
            private Object refundDate;
            private String payDate;
            private double divideMoney;
            private int divideRate;
            private boolean isRefund;
            private boolean isCapableRefund;
            private int id;

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

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

            public String getProductOwnerName() {
                return productOwnerName;
            }

            public void setProductOwnerName(String productOwnerName) {
                this.productOwnerName = productOwnerName;
            }

            public String getPayUserName() {
                return payUserName;
            }

            public void setPayUserName(String payUserName) {
                this.payUserName = payUserName;
            }

            public String getProductNumber() {
                return productNumber;
            }

            public void setProductNumber(String productNumber) {
                this.productNumber = productNumber;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public double getSumOrder() {
                return sumOrder;
            }

            public void setSumOrder(double sumOrder) {
                this.sumOrder = sumOrder;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getOrderDate() {

                if(!TextUtils.isEmpty(orderDate)){
                    orderDate= TimeUtil.getStringToDate2(orderDate);
                }

                return orderDate;
            }

            public void setOrderDate(String orderDate) {
                this.orderDate = orderDate;
            }

            public Object getRefundDate() {
                return refundDate;
            }

            public void setRefundDate(Object refundDate) {
                this.refundDate = refundDate;
            }

            public String getPayDate() {
                return payDate;
            }

            public void setPayDate(String payDate) {
                this.payDate = payDate;
            }

            public double getDivideMoney() {
                return divideMoney;
            }

            public void setDivideMoney(double divideMoney) {
                this.divideMoney = divideMoney;
            }

            public int getDivideRate() {
                return divideRate;
            }

            public void setDivideRate(int divideRate) {
                this.divideRate = divideRate;
            }

            public boolean isIsRefund() {
                return isRefund;
            }

            public void setIsRefund(boolean isRefund) {
                this.isRefund = isRefund;
            }

            public boolean isIsCapableRefund() {
                return isCapableRefund;
            }

            public void setIsCapableRefund(boolean isCapableRefund) {
                this.isCapableRefund = isCapableRefund;
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
