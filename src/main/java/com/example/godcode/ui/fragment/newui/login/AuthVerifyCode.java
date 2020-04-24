package com.example.godcode.ui.fragment.newui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.databinding.AuthVerifycodeBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class AuthVerifyCode extends BaseFragment {

    private AuthVerifycodeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.auth_verifycode, container, false);
        binding.setPresenter(Presenter.getInstance());
        initView();
        initListener();
        return binding.getRoot();
    }


    @Override
    public void initView() {

        countDownTime();

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        StringBuffer sb = new StringBuffer();
        binding.verifiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code1 = binding.code1.getText().toString();
                String code2 = binding.code2.getText().toString();
                String code3 = binding.code3.getText().toString();
                String code4 = binding.code4.getText().toString();
                String code5 = binding.code5.getText().toString();
                String code6 = binding.code6.getText().toString();
                sb.append(code1).append(code2).append(code3).append(code4).append(code5).append(code6);
                String code = sb.toString();
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(activity, "The code cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (code.length() < 6) {
                    Toast.makeText(activity, "The code length must be 6 bits", Toast.LENGTH_SHORT).show();
                    return;
                }
                ResetPwd resetPwd = new ResetPwd();
                Bundle bundle = getArguments();
                bundle.putString("code", code);
                resetPwd.setArguments(bundle);
                Presenter.getInstance().step2Fragment(resetPwd, "resetPwd");
            }
        });


    }

    private void countDownTime() {
        Observable.interval(1, TimeUnit.SECONDS).take(61).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String time = "00:" + (60 - aLong);
                return time;
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
            }
        }).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() {
            @Override
            public void run() throws Exception {

            }
        }).subscribe(
                t -> {
                    binding.djs.setText(t);
                }
        );
    }
}
