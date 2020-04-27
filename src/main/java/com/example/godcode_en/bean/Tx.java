package com.example.godcode_en.bean;

public class Tx {

    /**
     * password : string
     * putMoneyDto : {"fK_UserID":0,"fK_BankCardID":0,"sumTotal":0,"feeType":"string"}
     */

    private String password;
    private PutMoneyDtoBean putMoneyDto;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PutMoneyDtoBean getPutMoneyDto() {
        return putMoneyDto;
    }

    public void setPutMoneyDto(PutMoneyDtoBean putMoneyDto) {
        this.putMoneyDto = putMoneyDto;
    }

    public static class PutMoneyDtoBean {
        /**
         * fK_UserID : 0
         * fK_BankCardID : 0
         * sumTotal : 0
         * feeType : string
         */

        private int fK_UserID;
        private int fK_BankCardID;
        private double sumTotal;
        private String feeType;

        public int getFK_UserID() {
            return fK_UserID;
        }

        public void setFK_UserID(int fK_UserID) {
            this.fK_UserID = fK_UserID;
        }

        public int getFK_BankCardID() {
            return fK_BankCardID;
        }

        public void setFK_BankCardID(int fK_BankCardID) {
            this.fK_BankCardID = fK_BankCardID;
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
    }
}
