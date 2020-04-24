package com.example.godcode.ui.fragment.newui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.LoginBody;
import com.example.godcode.bean.LoginResponse;
import com.example.godcode.bean.RegisterBody;
import com.example.godcode.databinding.FragmentRegisterBinding;
import com.example.godcode.greendao.entity.LoginResult;
import com.example.godcode.greendao.option.LoginResultOption;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.activity.MainActivity;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.SharepreferenceUtil;
import com.google.gson.Gson;

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


    }


    public void register() {
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
        registerBody.setEmailAddress(emailAddress);
        String password = binding.etPwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getContext(), "The password cannotbe empty", Toast.LENGTH_SHORT).show();
            return;
        }
        registerBody.setPassword(password);
        HttpUtil.getInstance().register(registerBody).subscribe(
                registerStr -> {
                    if (registerBody.getOpenID() == null) {
                        LoginFragment loginFragment = new LoginFragment();
                        presenter.step2Fragment(loginFragment, "login");
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
