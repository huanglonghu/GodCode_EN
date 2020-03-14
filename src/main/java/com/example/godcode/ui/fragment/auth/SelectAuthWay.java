package com.example.godcode.ui.fragment.auth;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.databinding.SelectAuthwayBinding;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.LogUtil;

public class SelectAuthWay extends BaseFragment {

    private SelectAuthwayBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.select_authway, container, false);
        initListen();
        return binding.getRoot();
    }

    private void initListen() {

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onKeyDown();
            }
        });

        binding.mobileVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthVerifyCode authVerifyCode = new AuthVerifyCode();
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                authVerifyCode.setArguments(bundle);
                Presenter.getInstance().step2Fragment(authVerifyCode, "authverifyCode");
            }
        });

        binding.emailVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthVerifyCode authVerifyCode = new AuthVerifyCode();
                Bundle bundle = new Bundle();
                bundle.putInt("type", 2);
                authVerifyCode.setArguments(bundle);
                Presenter.getInstance().step2Fragment(authVerifyCode, "authverifyCode");
            }
        });


    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onKeyDown() {
        Presenter.getInstance().back();
        RxBus.getInstance().post(new RxEvent(EventType.EVENTTYPE_CHANGEPWD_BACK));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        LogUtil.log(TAG+"SelectAuthWay============onDestroy=============");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        LogUtil.log(TAG+"SelectAuthWay============onAttach=============");
    }


    private String TAG="====QQQQQQQQ=====";
}
