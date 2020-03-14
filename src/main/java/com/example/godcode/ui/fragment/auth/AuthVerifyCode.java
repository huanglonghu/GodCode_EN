package com.example.godcode.ui.fragment.auth;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.GetVerification;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.AuthVerifycodeBinding;
import com.example.godcode.greendao.entity.User;
import com.example.godcode.greendao.option.UserOption;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.fragment.pwd.ResetPwd;
import com.example.godcode.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class AuthVerifyCode extends BaseFragment {

    private AuthVerifycodeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.auth_verifycode, container, false);
        binding.setPresenter(Presenter.getInstance());
        initListen();
        return binding.getRoot();
    }

    private void initListen() {
        int type = getArguments().getInt("type");
        GetVerification getVerification = new GetVerification();
        getVerification.setType("3");
        binding.setType(type);
        binding.setGetVerification(getVerification);
        User user = UserOption.getInstance().querryUser(Constant.userId);
        binding.phone.setText(type == 1 ? user.getPhoneNumer() : user.getEmailAddress());

        binding.getYzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type == 1) {
                    getVerification.setPhoneNumber(user.getPhoneNumer());
                } else if (type == 2) {
                    getVerification.setEmailAddress(user.getEmailAddress());
                }
                HttpUtil.getInstance().getVerificationCode(getVerification).subscribe(
                        str -> {
                            countDownTime();
                        }
                );
            }
        });

        binding.yzm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String s1 = s.toString();
                if(s1.length()==6){
                    binding.next.setEnabled(true);
                }else {
                    binding.next.setEnabled(false);
                }
            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yzm = binding.yzm.getText().toString();
                if (TextUtils.isEmpty(yzm)) {
                    Toast.makeText(getContext(), "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                ResetPwd resetPwd = new ResetPwd();
                Bundle bundle = new Bundle();
                bundle.putInt("verifyCodeType", type == 1 ? 0 : 1);
                bundle.putString("verifyCode", binding.yzm.getText().toString());
                resetPwd.setArguments(bundle);
                Presenter.getInstance().step2Fragment(resetPwd, "resetPwd");
            }
        });
    }

    public void countDownTime() {
        binding.getYzm.setEnabled(false);
        Flowable.intervalRange(0, 61, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        binding.getYzm.setText("重新发送 " + String.valueOf(60 - aLong) + " 秒");
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        binding.getYzm.setText("获取验证码");
                        binding.getYzm.setEnabled(true);

                    }
                })
                .subscribe();
    }

    @Override
    protected void lazyLoad() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        LogUtil.log(TAG+"AuthverifyCode============onDestroy=============");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.log(TAG+"AuthverifyCode============onDetach=============");
    }

    private String TAG="====QQQQQQQQ=====";

}
