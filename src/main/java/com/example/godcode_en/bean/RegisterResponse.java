package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/5/17.
 */

public class RegisterResponse {


    /**
     * result : {"userName":"afdsf","name":"afdsf","surname":"afdsf","emailAddress":"1234@123","isActive":true,"fullName":"afdsf afdsf","lastLoginTime":null,"creationTime":"2018-05-17T11:49:47.0181203+08:00","roleNames":null,"id":21}
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
         * userName : afdsf
         * name : afdsf
         * surname : afdsf
         * emailAddress : 1234@123
         * isActive : true
         * fullName : afdsf afdsf
         * lastLoginTime : null
         * creationTime : 2018-05-17T11:49:47.0181203+08:00
         * roleNames : null
         * id : 21
         */

        private String userName;
        private String name;
        private String surname;
        private String emailAddress;
        private boolean isActive;
        private String fullName;
        private Object lastLoginTime;
        private String creationTime;
        private Object roleNames;
        private int id;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public boolean isIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Object getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(Object lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public Object getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(Object roleNames) {
            this.roleNames = roleNames;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
