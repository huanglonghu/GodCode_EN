package com.example.godcode.ui.fragment.dm;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
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
import com.example.godcode.bean.PriceScale;
import com.example.godcode.bean.PublicKey;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.GetScoreBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.KeyBoard;
import com.example.godcode.ui.view.PsdPopupWindow;
import com.example.godcode.utils.EncryptUtil;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.PayPwdSetting;
import com.example.godcode.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.HashMap;

public class GetScore extends BaseFragment {

    private GetScoreBinding binding;

    @Override
    protected void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.get_score, container, false);
        binding.setPresenter(presenter);
        initView();
        iniData();
        initListen();
        return binding.getRoot();
    }

    private void iniData() {
        HttpUtil.getInstance().getPriceScale(Constant.userId).subscribe(
                str -> {
                    PriceScale priceScale = GsonUtil.fromJson(str, PriceScale.class);
                    PriceScale.ResultBean result = priceScale.getResult();
                    if (result != null) {
                        binding.setPriceScale(result);
                    } else {
                        binding.submit.setClickable(false);
                        binding.submit.setBackgroundColor(Color.GRAY);
                    }

                }
        );
    }

    private void initView() {
        int jf = getArguments().getInt("jf");
        binding.jf.setText(jf + "");
    }

    private void initListen() {

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View v) {
                String moneyStr = binding.money.getText().toString();
                if (TextUtils.isEmpty(moneyStr)) {
                    ToastUtil.getInstance().showToast("请输入金额", 1000, getContext());
                    return;
                }
                if (Integer.parseInt(moneyStr) == 0) {
                    ToastUtil.getInstance().showToast("金额不能为0", 1000, getContext());
                    return;
                }

                HttpUtil.getInstance().getPublicKey(Constant.userId).subscribe(
                        publicKeyStr -> {
                            PublicKey publicKey = new Gson().fromJson(publicKeyStr, PublicKey.class);
                            String key = publicKey.getResult().getXmlKey();
                            double money = Double.parseDouble(moneyStr);
                            PayPwdSetting.getInstance().checkPwd(money, new ClickSureListener() {
                                @Override
                                public void isPwdExit(boolean isPwdExit) {
                                    if (isPwdExit) {
                                        KeyBoard keyBoard = new KeyBoard(activity, new ClickSureListener() {
                                            @Override
                                            public void checkPwd(String pwd) {
                                                HashMap<String, String> map = new HashMap<>();
                                                map.put("Password", pwd);
                                                map.put("RechargeMoney", moneyStr);
                                                map.put("FeeType", "CNY");
                                                String s = new Gson().toJson(map);
                                                String encryptStr = EncryptUtil.encryptByPublic(s, key);
                                                HttpUtil.getInstance().buyScore(Constant.userId, encryptStr).subscribe(
                                                        str -> {
                                                            if (str.contains("\"success\":false")) {
                                                                PsdPopupWindow.getInstance(activity).clear();
                                                                Toast.makeText(activity, "密码输入错误，请重新输入", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                PsdPopupWindow.getInstance(activity).exit();
                                                                ToastUtil.getInstance().showToast("积分购买成功", 1000, getContext());
                                                                Presenter.getInstance().back();
                                                            }

                                                        }
                                                );
                                            }
                                        });
                                        double money = Double.parseDouble(moneyStr);
                                        PsdPopupWindow.getInstance(activity).show("购买积分", money, v, keyBoard);
                                    }
                                }
                            });
                        }
                );
            }
        });

        binding.money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    int i = Integer.parseInt(s.toString());
                    if (binding.getPriceScale() != null) {
                        binding.score.setText(" = " + i * (binding.getPriceScale().getFraction() / binding.getPriceScale().getPrice()));
                    }
                } else {
                    binding.score.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void toPay(String moneyStr, String key, View v) {

    }


    public void getScore() {

    }
}
