package com.example.godcode.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.activity.BaseActivity;

public abstract class BaseFragment extends Fragment {

    public Presenter presenter;
    public BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) getActivity();
        presenter = Presenter.getInstance();
    }


    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();


    public void onKeyDown() {

    }


}
