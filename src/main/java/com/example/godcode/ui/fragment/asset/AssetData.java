package com.example.godcode.ui.fragment.asset;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.godcode.BR;

public class AssetData extends BaseObservable {

    private double papaer;

    private double coin;

    private double coinDivide;

    private double divide;

    private int sumCount;

    private int normalCount;

    private int errorCount;


    public AssetData() {

    }


    @Bindable
    public double getPapaer() {
        return papaer;
    }

    @Bindable
    public void setPapaer(double papaer) {
        this.papaer = papaer;
        notifyPropertyChanged(BR.papaer);
    }

    @Bindable
    public double getCoin() {
        return coin;
    }

    @Bindable
    public void setCoin(double coin) {
        this.coin = coin;
        notifyPropertyChanged(BR.coin);
    }

    @Bindable
    public double getCoinDivide() {
        return coinDivide;
    }

    @Bindable
    public void setCoinDivide(double coinDivide) {
        this.coinDivide = coinDivide;
        notifyPropertyChanged(BR.coinDivide);
    }

    @Bindable
    public double getDivide() {
        return divide;
    }

    @Bindable
    public void setDivide(double divide) {
        this.divide = divide;
        notifyPropertyChanged(BR.divide);
    }


    @Bindable
    public int getSumCount() {
        return sumCount;
    }

    @Bindable
    public void setSumCount(int sumCount) {
        this.sumCount = sumCount;
        notifyPropertyChanged(BR.sumCount);
    }

    @Bindable
    public int getNormalCount() {
        return normalCount;
    }


    @Bindable
    public void setNormalCount(int normalCount) {
        this.normalCount = normalCount;
        notifyPropertyChanged(BR.normalCount);
    }

    @Bindable
    public int getErrorCount() {
        return errorCount;
    }

    @Bindable
    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
        notifyPropertyChanged(BR.errorCount);
    }
}
