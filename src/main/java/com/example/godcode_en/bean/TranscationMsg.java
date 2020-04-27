package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/26.
 */

public class TranscationMsg {
    private String money;//保留两位小数
    private String date;  //日期
    private String factorage;//手续费
    private String payWay;//付款方式
    private String payType;//交易类型
    private String transcationObj;//交易对象
    private String status;
    private String productName;//产品名称
    private String orderNum;//订单号
    private String refoundDate;//退款时间
    private String txTime;
    private String bankName;
    private String jqbm;
    private String rechargePhone;
    private String rechargeAmount;
    private String description;
    private String paymentAmount;
    private String rechargeDate;
    private String fraction;


    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(String rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public String getRechargePhone() {
        return rechargePhone;
    }

    public void setRechargePhone(String rechargePhone) {
        this.rechargePhone = rechargePhone;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getJqbm() {
        return jqbm;
    }

    public void setJqbm(String jqbm) {
        this.jqbm = jqbm;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFactorage() {
        return factorage;
    }

    public void setFactorage(String factorage) {
        this.factorage = factorage;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTranscationObj() {
        return transcationObj;
    }

    public void setTranscationObj(String transcationObj) {
        this.transcationObj = transcationObj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRefoundDate() {
        return refoundDate;
    }

    public void setRefoundDate(String refoundDate) {
        this.refoundDate = refoundDate;
    }

    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
