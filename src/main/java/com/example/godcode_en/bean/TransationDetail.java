package com.example.godcode_en.bean;

/**
 * Created by Administrator on 2018/7/20.
 */

public class TransationDetail {

    /**
     * id : 0
     * transationType : string
     * relatedKey : 0
     */

    private int id;
    private String transationType;
    private int relatedKey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransationType() {
        return transationType;
    }

    public void setTransationType(String transationType) {
        this.transationType = transationType;
    }

    public int getRelatedKey() {
        return relatedKey;
    }

    public void setRelatedKey(int relatedKey) {
        this.relatedKey = relatedKey;
    }
}
