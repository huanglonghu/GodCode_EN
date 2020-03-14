package com.example.godcode.ui.fragment.pwd;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.bean.ResetPwdBean;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.ResetpwdBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.KeyBoard;
import com.example.godcode.utils.ToastUtil;

public class ResetPwd extends BaseFragment {

    private ResetpwdBinding binding;

    @Override
    protected void lazyLoad() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.resetpwd, container, false);
        initListen();
        return binding.getRoot();
    }

    private KeyBoard keyBoard;
    private int index;
    private String psd1;

    private void initListen() {
        binding.setPsdTitle.setText("Please enter a new 6-digit password");
        keyBoard = new KeyBoard(activity, new ClickSureListener() {
            @Override
            public void checkPwd(String pwd) {
                if (index == 0) {
                    psd1 = keyBoard.getPsd();
                    binding.setPayPsdPsdView.setPsLength(0);
                    keyBoard.clearPsd();
                    binding.setPsdTitle.setText("Please fill in the new password again");
                } else if (index >= 1) {
                    if (psd1.equals(keyBoard.getPsd())) {
                        binding.btnSetPsd.setEnabled(true);
                    } else {
                        Toast.makeText(activity, "The password entered twice is inconsistent, please re-enter it", Toast.LENGTH_SHORT).show();
                        binding.setPayPsdPsdView.setPsLength(0);
                    }
                }
                index++;
            }
        });
        keyBoard.setRefreshPsd(binding.setPayPsdPsdView);


        binding.setPayPsdPsdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!keyBoard.isShowing()) {
                    keyBoard.show(binding.getRoot());
                }
            }
        });

        int verifyCodeType = getArguments().getInt("verifyCodeType");
        String verifyCode = getArguments().getString("verifyCode");
        binding.btnSetPsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetPwdBean resetPwdBean = new ResetPwdBean();
                resetPwdBean.setNewPayPassword(keyBoard.getPsd());
                resetPwdBean.setVerificationCodeType(verifyCodeType);
                resetPwdBean.setUserID(Constant.userId);
                resetPwdBean.setVerificationCode(verifyCode);
                HttpUtil.getInstance().resetPassword(resetPwdBean).subscribe(
                        str -> {
                            ToastUtil.getInstance().showToast("Password reset successful", 1000, getContext());
                            back();
                        }
                );

            }
        });


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });


    }

    private void back() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack("authverifyCode",1);
        fm.popBackStack();
    }

    @Override
    public void onKeyDown() {
        back();
    }
}
