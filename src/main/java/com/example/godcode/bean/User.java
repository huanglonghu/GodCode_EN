package com.example.godcode.bean;

import java.io.Serializable;

public class User {


    /**
     * result : {"userName":"sy1533047708","nickName":null,"emailAddress":"sy1533047708@qq.com","phoneNumber":"18502085958","withdrawRate":0,"headImgUrl":null,"sex":0,"area":null,"signature":null,"address":null,"id":20014}
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

    public static class ResultBean implements Serializable{
        /**
         * userName : sy1533047708
         * nickName : null
         * emailAddress : sy1533047708@qq.com
         * phoneNumber : 18502085958
         * withdrawRate : 0.0
         * headImgUrl : null
         * sex : 0
         * area : null
         * signature : null
         * address : null
         * id : 20014
         */

        private String userName;
        private String nickName;
        private String emailAddress;
        private String phoneNumber;
        private double withdrawRate;
        private String headImgUrl;
        private int sex;
        private String area;
        private String signature;
        private String address;
        private int id;
        private double balance;
        private boolean isMakeCode;
        private boolean isProxy;

        public boolean isProxy() {
            return isProxy;
        }

        public void setProxy(boolean proxy) {
            isProxy = proxy;
        }

        public boolean isMakeCode() {
            return isMakeCode;
        }

        public void setMakeCode(boolean makeCode) {
            isMakeCode = makeCode;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public double getWithdrawRate() {
            return withdrawRate;
        }

        public void setWithdrawRate(double withdrawRate) {
            this.withdrawRate = withdrawRate;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
