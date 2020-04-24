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
import com.example.godcode.bean.GetVerification;
import com.example.godcode.bean.YZM;
import com.example.godcode.databinding.FragmentForgotpwdBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.GsonUtil;

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
                GetVerification getVerification = new GetVerification();
                getVerification.setType("2");
                getVerification.setEmailAddress(email);
                HttpUtil.getInstance().getVerificationCode(getVerification).subscribe(
                        str -> {
                            YZM yzm = GsonUtil.getInstance().fromJson(str, YZM.class);
                            String result = yzm.getResult();
                            if (result.equals("True")) {
                                AuthVerifyCode authVerifyCode = new AuthVerifyCode();
                                Bundle bundle = new Bundle();
                                bundle.putString("email", email);
                                authVerifyCode.setArguments(bundle);
                                Presenter.getInstance().step2Fragment(authVerifyCode, "verifyCode");
                            } else {
                                Toast.makeText(activity, result, Toast.LENGTH_SHORT).show();
                            }
                        }
                );

            }
        });


    }


}
