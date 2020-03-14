package com.example.godcode.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */

public class Teansantion {
    /**
     * paySumMoney : 420.0
     * incomeSumMoney : 10.0
     * code : 0
     * msg : null
     * count : 4
     * data : [{"fK_UserID":12,"transactionType":1,"money":120,"relatedKey":1,"addTime":"2018-06-23T00:00:00","id":1},{"fK_UserID":12,"transactionType":2,"money":10,"relatedKey":1,"addTime":"2018-06-23T00:00:00","id":2},{"fK_UserID":12,"transactionType":3,"money":110,"relatedKey":1,"addTime":"2018-06-23T00:00:00","id":3},{"fK_UserID":12,"transactionType":4,"money":190,"relatedKey":1,"addTime":"2018-06-23T00:00:00","id":4}]
     */

    private double paySumMoney;
    private double incomeSumMoney;
    private int code;
    private Object msg;
    private int count;
    private List<DataBean> data;

    public double getPaySumMoney() {
        return paySumMoney;
    }

    public void setPaySumMoney(double paySumMoney) {
        this.paySumMoney = paySumMoney;
    }

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
         * fK_UserID : 12
         * transactionType : 1
         * money : 120.0
         * relatedKey : 1
         * addTime : 2018-06-23T00:00:00
         * id : 1
         */

        private int fK_UserID;
        private int transactionType;
        private double money;
        private int relatedKey;
        private String addTime;
        private int id;
        private int putStatus;

        public int getPutStatus() {
            return putStatus;
        }

        public void setPutStatus(int putStatus) {
            this.putStatus = putStatus;
        }

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public int getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(int transactionType) {
            this.transactionType = transactionType;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public int getRelatedKey() {
            return relatedKey;
        }

        public void setRelatedKey(int relatedKey) {
            this.relatedKey = relatedKey;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
