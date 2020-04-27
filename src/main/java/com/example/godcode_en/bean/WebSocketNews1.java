package com.example.godcode_en.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/31.
 */

public class WebSocketNews1 implements Serializable{


    /**
     * EventType : 19
     * Data : {"ProductNumber":"SY1AC","CoinCount":1,"PaperMoney":2,"ScanQRMoney":0,"DivedeMoney":0,"MerchantUserIds":"29","AwardPosition":"3","AwardCount":"4"}
     * Flag : f7a59513-3d6a-4dfc-b047-3d45e48515a6
     */

    private int EventType;
    private DataBean Data;
    private String Flag;

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int EventType) {
        this.EventType = EventType;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }

    public static class DataBean implements Serializable{
        /**
         * ProductNumber : SY1AC
         * CoinCount : 1
         * PaperMoney : 2.0
         * ScanQRMoney : 0.0
         * DivedeMoney : 0.0
         * MerchantUserIds : 29
         * AwardPosition : 3
         * AwardCount : 4
         */

        private String ProductNumber;
        private int CoinCount;
        private double PaperMoney;
        private double ScanQRMoney;
        private double DivedeMoney;
        private String MerchantUserIds;
        private String AwardPosition;
        private String AwardCount;
        private double CoinDivedeMoney;

        public double getCoinDivedeMoney() {
            return CoinDivedeMoney;
        }

        public void setCoinDivedeMoney(double coinDivedeMoney) {
            CoinDivedeMoney = coinDivedeMoney;
        }

        public String getProductNumber() {
            return ProductNumber;
        }

        public void setProductNumber(String ProductNumber) {
            this.ProductNumber = ProductNumber;
        }

        public int getCoinCount() {
            return CoinCount;
        }

        public void setCoinCount(int CoinCount) {
            this.CoinCount = CoinCount;
        }

        public double getPaperMoney() {
            return PaperMoney;
        }

        public void setPaperMoney(double PaperMoney) {
            this.PaperMoney = PaperMoney;
        }

        public double getScanQRMoney() {
            return ScanQRMoney;
        }

        public void setScanQRMoney(double ScanQRMoney) {
            this.ScanQRMoney = ScanQRMoney;
        }

        public double getDivedeMoney() {
            return DivedeMoney;
        }

        public void setDivedeMoney(double DivedeMoney) {
            this.DivedeMoney = DivedeMoney;
        }

        public String getMerchantUserIds() {
            return MerchantUserIds;
        }

        public void setMerchantUserIds(String MerchantUserIds) {
            this.MerchantUserIds = MerchantUserIds;
        }

        public String getAwardPosition() {
            return AwardPosition;
        }

        public void setAwardPosition(String AwardPosition) {
            this.AwardPosition = AwardPosition;
        }

        public String getAwardCount() {
            return AwardCount;
        }

        public void setAwardCount(String AwardCount) {
            this.AwardCount = AwardCount;
        }
    }
}
