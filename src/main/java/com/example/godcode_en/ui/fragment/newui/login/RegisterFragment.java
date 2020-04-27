package com.example.godcode_en.ui.fragment.newui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode_en.R;
import com.example.godcode_en.bean.GetVerification;
import com.example.godcode_en.bean.LoginBody;
import com.example.godcode_en.bean.LoginResponse;
import com.example.godcode_en.bean.RegisterBody;
import com.example.godcode_en.bean.YZM;
import com.example.godcode_en.databinding.FragmentRegisterBinding;
import com.example.godcode_en.greendao.entity.LoginResult;
import com.example.godcode_en.greendao.option.LoginResultOption;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.activity.MainActivity;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.utils.GsonUtil;
import com.example.godcode_en.utils.SharepreferenceUtil;
import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RegisterFragment extends BaseFragment {

    private FragmentRegisterBinding binding;
    private RegisterBody registerBody;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
            binding.setPresenter(presenter);
            initListener();
        }
        return binding.getRoot();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    public void initListener() {

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        binding.eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean selected = binding.eye.isSelected();
                if (selected) {
                    binding.etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    binding.etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                binding.eye.setSelected(!selected);
            }
        });

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = binding.etEmail.getText().toString();
                if (TextUtils.isEmpty(emailAddress)) {
                    Toast.makeText(activity, "The email cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isEmail = isEmail(emailAddress);
                if (!isEmail) {
                    Toast.makeText(activity, "Incorrect mailbox format", Toast.LENGTH_SHORT).show();
                    return;
                }
                GetVerification getVerification = new GetVerification();
                getVerification.setType("1");
                getVerification.setEmailAddress(emailAddress);
                HttpUtil.getInstance().getVerificationCode(getVerification).subscribe(
                        str -> {
                            YZM yzm = GsonUtil.getInstance().fromJson(str, YZM.class);
                            String result = yzm.getResult();
                            if (result.equals("True")) {
                            } else {
                                Toast.makeText(activity, result, Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                countDownTime();
            }
        });


    }


    private void countDownTime() {
        Observable.interval(1, TimeUnit.SECONDS).take(61).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String time = "Resend 00:" + (60 - aLong);
                return time;
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                binding.send.setClickable(false);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                binding.send.setClickable(true);
                binding.send.setText("SEND CODE");
            }
        }).subscribe(
                t -> {
                    binding.send.setText(t);
                }
        );
    }


    private boolean isEmail(String email) {
        Pattern pattern = Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher mc = pattern.matcher(email.trim());
        boolean b = mc.find();
        return b;
    }


    public void  register() {
        registerBody = new RegisterBody();
        String nickName = binding.etAccount.getText().toString();
        if (TextUtils.isEmpty(nickName)) {
            Toast.makeText(activity, "The username cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        registerBody.setNickName(nickName);
        String emailAddress = binding.etEmail.getText().toString();
        if (TextUtils.isEmpty(emailAddress)) {
            Toast.makeText(activity, "The email cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isEmail = isEmail(emailAddress);
        if (!isEmail) {
            Toast.makeText(activity, "Incorrect mailbox format", Toast.LENGTH_SHORT).show();
            return;
        }
        registerBody.setEmailAddress(emailAddress);

        String code = binding.etCode.getText().toString();
        if (TextUtils.isEmpty(code)) {
            Toast.makeText(getContext(), "The sms code cannotbe empty", Toast.LENGTH_SHORT).show();
            return;
        }
        registerBody.setVerificationCode(code);

        String password = binding.etPwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getContext(), "The password cannotbe empty", Toast.LENGTH_SHORT).show();
            return;
        }
        registerBody.setPassword(password);
        HttpUtil.getInstance().register(registerBody).subscribe(
                registerStr -> {
                    if (registerBody.getOpenID() == null) {
                        Toast.makeText(getContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        Presenter.getInstance().back();
                    } else {
                        LoginBody loginBody = new LoginBody();
                        loginBody.setOpenID(registerBody.getOpenID());
                        loginBody.setDeviceToken(Constant.diviceToken);
                        HttpUtil.getInstance().login(loginBody).subscribe(
                                loginStr -> {
                                    LoginResponse loginResponse = new Gson().fromJson(loginStr, LoginResponse.class);
                                    LoginResponse.ResultBean result = loginResponse.getResult();
                                    LoginResult loginResult = new LoginResult(Constant.uniquenessToken, result.getPayServerUrl(), result.getUserId());
                                    Constant.uniquenessToken = result.getUniquenessToken();
                                    loginResult.setUniquenessToken(Constant.uniquenessToken);
                                    Constant.balances = result.getBalances();
                                    Constant.toDayMoney = result.getToDayMoney();
                                    Constant.yesterDayMoney = result.getYesterDayMoney();
                                    LoginResultOption.getInstance().insertLoginResult(loginResult);
                                    Constant.userId = result.getUserId();
                                    Constant.expireInSeconds = result.getExpireInSeconds();
                                    long time = System.currentTimeMillis();
                                    SharepreferenceUtil.getInstance().saveAccessToken(result.getAccessToken(), Constant.uniquenessToken, time);
                                    Constant.payUrl = result.getPayServerUrl();
                                    Intent intent = new Intent(activity, MainActivity.class);
                                    activity.startActivity(intent);
                                }
                        );
                    }
                }
        );
    }

    public void initData(RegisterBody registerBody) {
        this.registerBody = registerBody;
    }


}
