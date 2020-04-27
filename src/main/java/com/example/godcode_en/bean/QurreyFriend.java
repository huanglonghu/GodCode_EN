package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/6/27.
 */

public class QurreyFriend {


    /**
     * result : {"userName":"sy1535984081","nickName":"keyd","emailAddress":"sy1535984081@qq.com","phoneNumber":"13076737863","withdrawRate":0.006,"headImgUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIM5icsOStbNUvad5Jic1lX1iaKeUO03yN33cEI7yv6M4QqRrUJ8DyUrck9cb6IrF6aMj4bsqdqgc2mQ/132","sex":1,"area":null,"signature":null,"address":null,"balance":0,"id":6}
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
         * userName : sy1535984081
         * nickName : keyd
         * emailAddress : sy1535984081@qq.com
         * phoneNumber : 13076737863
         * withdrawRate : 0.006
         * headImgUrl : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIM5icsOStbNUvad5Jic1lX1iaKeUO03yN33cEI7yv6M4QqRrUJ8DyUrck9cb6IrF6aMj4bsqdqgc2mQ/132
         * sex : 1
         * area : null
         * signature : null
         * address : null
         * balance : 0.0
         * id : 6
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
        private double balance;
        private int id;

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

        public Object getSignature() {
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

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
