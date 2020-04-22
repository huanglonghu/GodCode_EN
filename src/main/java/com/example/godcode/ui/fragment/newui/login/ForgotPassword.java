package com.example.godcode.ui.fragment.newui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.databinding.FragmentForgotpwdBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.TimeUtil;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;

public class ForgotPassword extends BaseFragment {

    private FragmentForgotpwdBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgotpwd, container, false);
        initListener();
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

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = binding.etEmail.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(activity, "The email cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Observable.interval(1, TimeUnit.SECONDS).take(61).map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        String time = "00:" + (60 - aLong);
                        return time;
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        binding.send.setClickable(false);
                    }
                }).doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        binding.send.setClickable(true);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(
                        t -> {
                            binding.djs.setText(t);
                        }
                );


            }
        });



    }
}
