package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/13.
 */

public class GetVerification {


    /**
     * phoneNumber : string
     * emailAddress : string
     * type : string
     */

    private String phoneNumber;
    private String emailAddress;
    private String type;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
