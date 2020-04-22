package com.example.godcode.ui.fragment.newui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.R;
import com.example.godcode.databinding.AuthVerifycodeBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;

public class AuthVerifyCode extends BaseFragment {

    private AuthVerifycodeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.auth_verifycode, container, false);
        binding.setPresenter(Presenter.getInstance());
        return binding.getRoot();
    }



    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
