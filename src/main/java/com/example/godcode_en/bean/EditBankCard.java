package com.example.godcode_en.bean;

public class EditBankCard {

    /**
     * bankCard : {"id":0,"fK_UserID":0,"bankID":0,"bankName":"string","accountName":"string","bankNumber":0,"mobile":"string","bindType":"string","bindMoney":0,"bankCardNumber":"string","area":"string","network":"string"}
     */

    private BankCardBean bankCard;

    public BankCardBean getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCardBean bankCard) {
        this.bankCard = bankCard;
    }

    public static class BankCardBean {
        /**
         * id : 0
         * fK_UserID : 0
         * bankID : 0
         * bankName : string
         * accountName : string
         * bankNumber : 0
         * mobile : string
         * bindType : string
         * bindMoney : 0
         * bankCardNumber : string
         * area : string
         * network : string
         */

        private int id;
        private int fK_UserID;
        private int bankID;
        private String bankName;
        private String accountName;
        private int bankNumber;
        private String mobile;
        private String bindType;
        private int bindMoney;
        private String bankCardNumber;
        private String area;
        private String network;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getBindType() {
            return bindType;
        }

        public void setBindType(String bindType) {
            this.bindType = bindType;
        }

        public int getBindMoney() {
            return bindMoney;
        }

        public void setBindMoney(int bindMoney) {
            this.bindMoney = bindMoney;
        }

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
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
    }
}
