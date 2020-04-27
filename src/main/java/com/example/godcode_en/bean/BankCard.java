package com.example.godcode_en.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class BankCard {


    /**
     * result : [{"fK_UserID":11,"bankID":0,"bankName":"中国银行","accountName":"虎","bankTime":"2019-02-19T14:05:34.7689628","bankNumber":0,"mobile":"13076737863","bankCardNumber":"6214230031002334236","bindType":3,"bindMoney":0,"userName":"13076737863","area":"天津市天津市","network":"广州","id":138}]
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * fK_UserID : 11
         * bankID : 0
         * bankName : 中国银行
         * accountName : 虎
         * bankTime : 2019-02-19T14:05:34.7689628
         * bankNumber : 0
         * mobile : 13076737863
         * bankCardNumber : 6214230031002334236
         * bindType : 3
         * bindMoney : 0.0
         * userName : 13076737863
         * area : 天津市天津市
         * network : 广州
         * id : 138
         */

        private int fK_UserID;
        private int bankID;
        private String bankName;
        private String accountName;
        private String bankTime;
        private int bankNumber;
        private String mobile;
        private String bankCardNumber;
        private int bindType;
        private double bindMoney;
        private String userName;
        private String area;
        private String network;
        private int id;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public int getBankID() {
            return bankID;
        }

        public void setBankID(int bankID) {
            this.bankID = bankID;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getBankTime() {
            return bankTime;
        }

        public void setBankTime(String bankTime) {
            this.bankTime = bankTime;
        }

        public int getBankNumber() {
            return bankNumber;
        }

        public void setBankNumber(int bankNumber) {
            this.bankNumber = bankNumber;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
        }

        public int getBindType() {
            return bindType;
        }

        public void setBindType(int bindType) {
            this.bindType = bindType;
        }

        public double getBindMoney() {
            return bindMoney;
        }

        public void setBindMoney(double bindMoney) {
            this.bindMoney = bindMoney;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String network) {
            this.network = network;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
