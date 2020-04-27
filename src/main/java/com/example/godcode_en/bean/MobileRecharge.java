package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/11/2.
 */

public class MobileRecharge {

    /**
     * rechargeRecord : {"fK_UserID":0,"payPassword":"string","rechargeSettingId":0,"rechargePhoneNumber":"string"}
     */

    private RechargeRecordBean rechargeRecord;

    public RechargeRecordBean getRechargeRecord() {
        return rechargeRecord;
    }

    public void setRechargeRecord(RechargeRecordBean rechargeRecord) {
        this.rechargeRecord = rechargeRecord;
    }

    public static class RechargeRecordBean {
        /**
         * fK_UserID : 0
         * payPassword : string
         * rechargeSettingId : 0
         * rechargePhoneNumber : string
         */

        private int fK_UserID;
        private String payPassword;
        private int rechargeSettingId;
        private String rechargePhoneNumber;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public String getPayPassword() {
            return payPassword;
        }

        public void setPayPassword(String payPassword) {
            this.payPassword = payPassword;
        }

        public int getRechargeSettingId() {
            return rechargeSettingId;
        }

        public void setRechargeSettingId(int rechargeSettingId) {
            this.rechargeSettingId = rechargeSettingId;
        }

        public String getRechargePhoneNumber() {
            return rechargePhoneNumber;
        }

        public void setRechargePhoneNumber(String rechargePhoneNumber) {
            this.rechargePhoneNumber = rechargePhoneNumber;
        }
    }
}
