package com.example.godcode_en.bean;

import com.example.godcode_en.utils.FormatUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/9.
 */

public class GroupMsg {

    /**
     * result : {"normalCount":0,"errorCount":2,"dividedMoney":0,"coinCount":0,"data":{"ifelse":{"fK_UserID":40,"scanCodeIncome":0,"divideIncome":0,"onlineCount":0,"offlineCount":1},"穷开":{"fK_UserID":11,"scanCodeIncome":0,"divideIncome":0,"onlineCount":0,"offlineCount":1}}}
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

    public static class ResultBean implements Serializable {


        private int normalCount;
        private int errorCount;
        private double dividedMoney;
        private int coinCount;
        private int count;
        private int sumAwardCount;
        private double paperCoinCount;
        private double coinDividedMoney;


        public double getCoinDividedMoney() {
            return coinDividedMoney;
        }

        public void setCoinDividedMoney(double coinDividedMoney) {
            this.coinDividedMoney = coinDividedMoney;
        }

        public double getPaperCoinCount() {
            return paperCoinCount;
        }

        public void setPaperCoinCount(double paperCoinCount) {
            this.paperCoinCount = paperCoinCount;
        }

        public int getSumAwardCount() {
            return sumAwardCount;
        }

        public void setSumAwardCount(int sumAwardCount) {
            this.sumAwardCount = sumAwardCount;
        }

        private Map<String, bean> data;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getNormalCount() {
            return normalCount;
        }

        public void setNormalCount(int normalCount) {
            this.normalCount = normalCount;
        }

        public int getErrorCount() {
            return errorCount;
        }

        public void setErrorCount(int errorCount) {
            this.errorCount = errorCount;
        }

        public double getDividedMoney() {
            return dividedMoney;
        }

        public void setDividedMoney(double dividedMoney) {
            this.dividedMoney = dividedMoney;
        }

        public int getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(int coinCount) {
            this.coinCount = coinCount;
        }

        public Map<String, bean> getData() {
            return data;
        }

        public void setData(Map<String, bean> data) {
            this.data = data;
        }

        public static class bean {
            /**
             * fK_UserID : 11
             * scanCodeIncome : 0.0
             * divideIncome : 0.0
             * onlineCount : 0
             * offlineCount : 1
             */
            private String userName;
            private int fK_UserID;
            private double scanCodeIncome;
            private double divideIncome;
            private int onlineCount;
            private int offlineCount;
            private String headImgUrl;
            private int todayCoin;
            private double todayBanknote;

            public int getTodayCoin() {
                return todayCoin;
            }

            public void setTodayCoin(int todayCoin) {
                this.todayCoin = todayCoin;
            }

            public double getTodayBanknote() {
                return todayBanknote;
            }

            public void setTodayBanknote(double todayBanknote) {
                this.todayBanknote = todayBanknote;
            }

            public String getHeadImgUrl() {
                return headImgUrl;
            }

            public void setHeadImgUrl(String headImgUrl) {
                this.headImgUrl = headImgUrl;
            }

            public int getFK_UserID() {
                return fK_UserID;
            }

            public void setFK_UserID(int fK_UserID) {
                this.fK_UserID = fK_UserID;
            }

            public String getScanCodeIncome() {
                String aDouble = FormatUtil.getInstance().get2double(scanCodeIncome);
                return aDouble;
            }

            public void setScanCodeIncome(double scanCodeIncome) {
                this.scanCodeIncome = scanCodeIncome;
            }

            public String getDivideIncome() {
                String a = FormatUtil.getInstance().get2double(divideIncome);
                return a;
            }

            public void setDivideIncome(double divideIncome) {
                this.divideIncome = divideIncome;
            }

            public int getOnlineCount() {
                return onlineCount;
            }

            public void setOnlineCount(int onlineCount) {
                this.onlineCount = onlineCount;
            }

            public int getOfflineCount() {
                return offlineCount;
            }

            public void setOfflineCount(int offlineCount) {
                this.offlineCount = offlineCount;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }
        }
    }
}
