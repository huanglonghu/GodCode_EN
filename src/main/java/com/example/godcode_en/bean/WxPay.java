package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/12.
 */

public class WxPay {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    private double totalFee;

}
