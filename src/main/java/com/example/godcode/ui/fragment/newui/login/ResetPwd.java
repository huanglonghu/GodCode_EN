package com.example.godcode.ui.fragment.newui.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.databinding.FragmentResetpwdBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;

public class ResetPwd extends BaseFragment {

    private FragmentResetpwdBinding binding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_resetpwd, container, false);
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
        Bundle bundle = getArguments();
        String email = bundle.getString("email");
        String code = bundle.getString("code");
        binding.resetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = binding.etPwd.getText().toString();
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(getContext(), "The password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                HttpUtil.getInstance().resetPwd(email, code, pwd).subscribe(
                        str -> {
                            Toast.makeText(getContext(), "Reset password success", Toast.LENGTH_SHORT).show();
                            Presenter.getInstance().back();
                            Presenter.getInstance().back();
                        }
                );


            }
        });


    }




}
