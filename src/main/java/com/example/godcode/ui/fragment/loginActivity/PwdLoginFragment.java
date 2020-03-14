package com.example.godcode.ui.fragment.loginActivity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.GetVerification;
import com.example.godcode.bean.LoginBody;
import com.example.godcode.bean.LoginResponse;
import com.example.godcode.bean.YZM;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.FragmentLoginBinding;
import com.example.godcode.databinding.FragmentPwdloginBinding;
import com.example.godcode.greendao.entity.LoginResult;
import com.example.godcode.greendao.option.LoginResultOption;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.activity.MainActivity;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.FormatUtil;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.SharepreferenceUtil;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PwdLoginFragment extends BaseFragment {

    private FragmentPwdloginBinding binding;
    private LoginBody loginBody;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pwdlogin, container, false);
            binding.setPresenter(presenter);
            initListener();
        }
        initData();
        return binding.getRoot();
    }

    private void initData() {
        loginBody = new LoginBody();
        loginBody.setDeviceToken(Constant.diviceToken);
        binding.setLoginBody(loginBody);
    }

    private void initListener() {

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        binding.resetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetPwd resetPwd = new ResetPwd();
                Presenter.getInstance().step2Fragment(resetPwd, "resetPwd");
            }
        });

        binding.loginByCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });

    }


    public void login() {
        String account = binding.etAccount.getText().toString();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(activity, "The account cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(loginBody.getPassword())) {
            Toast.makeText(activity, "The password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        loginBody.setUserName(account);
        HttpUtil.getInstance().login(loginBody).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                loginStr -> {
                    if (loginStr.contains("\"success\":false")) {
                        Presenter.getInstance().step2Fragment("register");
                    } else {
                        LoginResponse loginResponse = new Gson().fromJson(loginStr, LoginResponse.class);
                        LoginResponse.ResultBean result = loginResponse.getResult();
                        LoginResult loginResult = new LoginResult(Constant.uniquenessToken, result.getPayServerUrl(), result.getUserId());
                        Constant.balances = result.getBalances();
                        Constant.toDayMoney = result.getToDayMoney();
                        Constant.yesterDayMoney = result.getYesterDayMoney();
                        Constant.uniquenessToken = result.getUniquenessToken();
                        loginResult.setUniquenessToken(Constant.uniquenessToken);
                        LoginResultOption.getInstance().insertLoginResult(loginResult);
                        Constant.expireInSeconds = result.getExpireInSeconds();
                        Constant.userId = result.getUserId();
                        long time = System.currentTimeMillis();
                        SharepreferenceUtil.getInstance().saveAccessToken(result.getAccessToken(), Constant.uniquenessToken, time);
                        Constant.payUrl = result.getPayServerUrl();
                        Intent intent = new Intent(activity, MainActivity.class);
                        activity.startActivity(intent);
                    }
                }
        );

    }


    @Override
    protected void lazyLoad() {

    }

}
