package com.example.godcode_en.interface_;

import com.example.godcode_en.bean.PackageList;

import java.util.List;

public abstract class EtStrategy {
    public void etComplete(String value, int position) {
    }

    ;

    public void etComplete(int value) {
    }

    ;

    public void etComplete() {
    }

    ;

    public void etComplete(List<Integer> list) {
    }

    ;

    public void etComplete(PackageList.ResultBean.DataBean bean) {
    }

    ;


    public void netChange(boolean isConnect) {
    }

    ;
}
