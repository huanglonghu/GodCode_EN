package com.example.godcode_en.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/6.
 */

public class Notice2 implements Serializable{

    /**
     * TransactionType : 6
     * RelatedKey : 24
     * Id : 40214
     */

    private int TransactionType;
    private int RelatedKey;
    private int Id;

    public int getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(int TransactionType) {
        this.TransactionType = TransactionType;
    }

    public int getRelatedKey() {
        return RelatedKey;
    }

    public void setRelatedKey(int RelatedKey) {
        this.RelatedKey = RelatedKey;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
