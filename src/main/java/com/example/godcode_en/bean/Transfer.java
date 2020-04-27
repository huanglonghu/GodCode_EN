package com.example.godcode_en.bean;


public class Transfer{
    ///  FK_UserIDDisburs支出用户ID
    /// FK_UserIDIncome 收入用户ID
    /// Money 转账金额
    /// FeeType 货币种类
    /// Password 支付密码
    /// IncomeGenreType 转账类型 2.转账收入 3.扫码收入

    private int FK_UserIDDisburs;
    private int FK_UserIDIncome;
    private String FeeType;
    private String Password;
    private double money;
    private int IncomeGenreType;
    private String Describe;


    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
    }

    public int getFK_UserIDDisburs() {
        return FK_UserIDDisburs;
    }

    public void setFK_UserIDDisburs(int FK_UserIDDisburs) {
        this.FK_UserIDDisburs = FK_UserIDDisburs;
    }

    public int getFK_UserIDIncome() {
        return FK_UserIDIncome;
    }

    public void setFK_UserIDIncome(int FK_UserIDIncome) {
        this.FK_UserIDIncome = FK_UserIDIncome;
    }

    public String getFeeType() {
        return FeeType;
    }

    public void setFeeType(String feeType) {
        FeeType = feeType;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getIncomeGenreType() {
        return IncomeGenreType;
    }

    public void setIncomeGenreType(int incomeGenreType) {
        IncomeGenreType = incomeGenreType;
    }
}
