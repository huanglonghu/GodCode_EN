package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/5/17.
 */

public class LoginResponse {
    /**
     * result : {"accessToken":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6IjEwODA3NSIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiZDYyN2I3YTMtODVlYy1lNmYzLTgyNTEtMzllOGY5MzY1ODEyIiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6IjExIiwianRpIjoiYTA1MDA0YzctMDgxMi00YzE4LTk2MzktODU2YjdjNmVkNTVjIiwiaWF0IjoxNTU3OTE3MjczLCJuYmYiOjE1NTc5MTcyNzMsImV4cCI6MTY1NzkxNzI3MywiaXNzIjoiR29kQ29kZSIsImF1ZCI6IkdvZENvZGUifQ.31kHxFoLOC-GVz2Rol8xyWuqptn_btgMF36uKXoaONE","encryptedAccessToken":"wNYmO41/48SHNstaLVXxHCCre29BZQl1NhC6NM3R3rzpXtPQxVzH6jEzA/QhXFN5tu6Fk7pO53uppm1mVXMZgxbyRVz26dnepi/FyB6axBY+6gq1GL+uRQgoiFUCjRN2p8w6LevViwKlHyWZZJZO1DGVSjAi1m2U+og9pkHw9/QFuTaddXoEc2aWHqYeqH6iCwpNxbsGH0q3Edfasw2jwuz1FDjpXGgGZjFKe9VFagwOaJgUAzM/NKslIhgJ4CuRm//r2X+egBTLD9RSXBv/bIva4BpeYHWnTArNA1WRh9/IPqOvxP9WBWYZ98PCiHm/LWlKE7bwxempGaPKi5ZYmaMq5uSh1LkHpYWpCUKH6s1d+MokTnrM8Jhk6Nfr70rcrGizdD/3wjlMmYoXIEEuXjeu9lC7LQ6YlpV19otaXEve7cIyrFJLRuN7K3XZxWnuuQdKelLCWcX6ranqaXWgoR70SNCNsH4oPkQFTyULT41SSW5N5Ud2dY+BF7uOvg+a8CUWurlBNwE8X2paunui7YcN+MK6m0DRtrDpvMWsmqieKKNpSLdCN5R1sBWGUzuIivhOYAgZAy2ycUhhPV3UHKD28mjtXwDLIFW2KTAatPB8bvjqtLfquP1MRugXCw6OyH1ZHQC1g54rmFczZp80CuFD+4RHEQid4GJ5j6GWrm1aFEX87EWz2wWcgJ0KB7+r2bpIICKbgxQHTI7+fI3Z3NnpE5x5BSrxaSwzOjhpMn8GsKhEjggK+6BzJuLWl4lM9gqrZ7R9orKGJFWxTmo++u6oSiAFuY+urCFd4iML1+BDnfxp0pzy/JGZq1pjTtG3n2lH0z3CqRhws9IS2wWv6mE8T8yi4lNIne74a/jftSE=","expireInSeconds":100000000,"userId":11,"payServerUrl":"http://godcodepay.joinvalue.com:8901","uniquenessToken":"B0D15B2E0C691071E7FF4FD5A4697A9F015BB4D40A6FF2D5EA91A0A6A02B37316674845C0B31DEB2","toDayMoney":0,"yesterDayMoney":0,"balances":14.56}
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
         * accessToken : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6IjEwODA3NSIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiZDYyN2I3YTMtODVlYy1lNmYzLTgyNTEtMzllOGY5MzY1ODEyIiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6IjExIiwianRpIjoiYTA1MDA0YzctMDgxMi00YzE4LTk2MzktODU2YjdjNmVkNTVjIiwiaWF0IjoxNTU3OTE3MjczLCJuYmYiOjE1NTc5MTcyNzMsImV4cCI6MTY1NzkxNzI3MywiaXNzIjoiR29kQ29kZSIsImF1ZCI6IkdvZENvZGUifQ.31kHxFoLOC-GVz2Rol8xyWuqptn_btgMF36uKXoaONE
         * encryptedAccessToken : wNYmO41/48SHNstaLVXxHCCre29BZQl1NhC6NM3R3rzpXtPQxVzH6jEzA/QhXFN5tu6Fk7pO53uppm1mVXMZgxbyRVz26dnepi/FyB6axBY+6gq1GL+uRQgoiFUCjRN2p8w6LevViwKlHyWZZJZO1DGVSjAi1m2U+og9pkHw9/QFuTaddXoEc2aWHqYeqH6iCwpNxbsGH0q3Edfasw2jwuz1FDjpXGgGZjFKe9VFagwOaJgUAzM/NKslIhgJ4CuRm//r2X+egBTLD9RSXBv/bIva4BpeYHWnTArNA1WRh9/IPqOvxP9WBWYZ98PCiHm/LWlKE7bwxempGaPKi5ZYmaMq5uSh1LkHpYWpCUKH6s1d+MokTnrM8Jhk6Nfr70rcrGizdD/3wjlMmYoXIEEuXjeu9lC7LQ6YlpV19otaXEve7cIyrFJLRuN7K3XZxWnuuQdKelLCWcX6ranqaXWgoR70SNCNsH4oPkQFTyULT41SSW5N5Ud2dY+BF7uOvg+a8CUWurlBNwE8X2paunui7YcN+MK6m0DRtrDpvMWsmqieKKNpSLdCN5R1sBWGUzuIivhOYAgZAy2ycUhhPV3UHKD28mjtXwDLIFW2KTAatPB8bvjqtLfquP1MRugXCw6OyH1ZHQC1g54rmFczZp80CuFD+4RHEQid4GJ5j6GWrm1aFEX87EWz2wWcgJ0KB7+r2bpIICKbgxQHTI7+fI3Z3NnpE5x5BSrxaSwzOjhpMn8GsKhEjggK+6BzJuLWl4lM9gqrZ7R9orKGJFWxTmo++u6oSiAFuY+urCFd4iML1+BDnfxp0pzy/JGZq1pjTtG3n2lH0z3CqRhws9IS2wWv6mE8T8yi4lNIne74a/jftSE=
         * expireInSeconds : 100000000
         * userId : 11
         * payServerUrl : http://godcodepay.joinvalue.com:8901
         * uniquenessToken : B0D15B2E0C691071E7FF4FD5A4697A9F015BB4D40A6FF2D5EA91A0A6A02B37316674845C0B31DEB2
         * toDayMoney : 0.0
         * yesterDayMoney : 0.0
         * balances : 14.56
         */

        private String accessToken;
        private String encryptedAccessToken;
        private int expireInSeconds;
        private int userId;
        private String payServerUrl;
        private String uniquenessToken;
        private double toDayMoney;
        private double yesterDayMoney;
        private double balances;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getEncryptedAccessToken() {
            return encryptedAccessToken;
        }

        public void setEncryptedAccessToken(String encryptedAccessToken) {
            this.encryptedAccessToken = encryptedAccessToken;
        }

        public int getExpireInSeconds() {
            return expireInSeconds;
        }

        public void setExpireInSeconds(int expireInSeconds) {
            this.expireInSeconds = expireInSeconds;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPayServerUrl() {
            return payServerUrl;
        }

        public void setPayServerUrl(String payServerUrl) {
            this.payServerUrl = payServerUrl;
        }

        public String getUniquenessToken() {
            return uniquenessToken;
        }

        public void setUniquenessToken(String uniquenessToken) {
            this.uniquenessToken = uniquenessToken;
        }

        public double getToDayMoney() {
            return toDayMoney;
        }

        public void setToDayMoney(double toDayMoney) {
            this.toDayMoney = toDayMoney;
        }

        public double getYesterDayMoney() {
            return yesterDayMoney;
        }

        public void setYesterDayMoney(double yesterDayMoney) {
            this.yesterDayMoney = yesterDayMoney;
        }

        public double getBalances() {
            return balances;
        }

        public void setBalances(double balances) {
            this.balances = balances;
        }
    }
}
