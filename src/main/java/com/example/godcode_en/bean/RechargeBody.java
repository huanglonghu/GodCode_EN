package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/20.
 */

public class RechargeBody {

    /**
     * payMoney : {"fK_UserID":0,"sumTotal":0,"feeType":"string","recordTime":"2018-07-20T01:39:08.368Z"}
     */

    private PayMoneyBean payMoney;

    public PayMoneyBean getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(PayMoneyBean payMoney) {
        this.payMoney = payMoney;
    }

    public static class PayMoneyBean {
        /**
         * fK_UserID : 0
         * sumTotal : 0
         * feeType : string
         * recordTime : 2018-07-20T01:39:08.368Z
         */

        private int fK_UserID;
        private double sumTotal;
        private String feeType;
        private String recordTime;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public double getSumTotal() {
            return sumTotal;
        }

        public void setSumTotal(double sumTotal) {
            this.sumTotal = sumTotal;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public String getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(String recordTime) {
            this.recordTime = recordTime;
        }
    }
}
