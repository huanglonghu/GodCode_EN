package com.example.godcode.ui.fragment.dm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.UnLockMc;
import com.example.godcode.bean.UnLockMcResponse;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.UnlockBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UnLock extends BaseFragment {

    private UnlockBinding binding;
    private int score;

    @Override
    protected void lazyLoad() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.unlock, container, false);
            binding.setPresenter(presenter);
            initView();
            initListen();
        }
        return binding.getRoot();
    }

    private void initView() {
        score = getArguments().getInt("score");
        binding.score.setText(score + "");
    }

    private int index1 = -1;
    private int index2 = -1;

    private void initListen() {
        binding.parmerterChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentProfit = binding.currentProfit.getText().toString();
                if (TextUtils.isEmpty(currentProfit)) {
                    ToastUtil.getInstance().showToast("请输入当期盈利", 1000, getContext());
                    return;
                }
                String productNum = binding.productNum.getText().toString();
                if (TextUtils.isEmpty(productNum)) {
                    ToastUtil.getInstance().showToast("请输入机台号码", 1000, getContext());
                    return;
                }
                String verifyCode = binding.verifyCode.getText().toString();
                if (TextUtils.isEmpty(verifyCode)) {
                    ToastUtil.getInstance().showToast("请输入校验码", 1000, getContext());
                    return;
                }
                UnLockMc unLockMc = new UnLockMc();
                unLockMc.setCurrentProfit(currentProfit);
                unLockMc.setMcProductNumber(productNum);
                unLockMc.setVerifyCode(verifyCode);
                unLockMc.setUserID(Constant.userId);
                unLockMc.setIsUnlock("0");
                ParameterChange parameterChange = new ParameterChange();
                parameterChange.setData(unLockMc, score);
                presenter.step2Fragment(parameterChange, "parameterchange");
            }
        });

        binding.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentProfit = binding.currentProfit.getText().toString();
                if (TextUtils.isEmpty(currentProfit)) {
                    ToastUtil.getInstance().showToast("请输入当期盈利", 1000, getContext());
                    return;
                }
                String productNum = binding.productNum.getText().toString();
                if (TextUtils.isEmpty(productNum)) {
                    ToastUtil.getInstance().showToast("请输入机台号码", 1000, getContext());
                    return;
                }
                String verifyCode = binding.verifyCode.getText().toString();
                if (TextUtils.isEmpty(verifyCode)) {
                    ToastUtil.getInstance().showToast("请输入校验码", 1000, getContext());
                    return;
                }
                UnLockMc unLockMc = new UnLockMc();
                unLockMc.setCurrentProfit(currentProfit);
                unLockMc.setMcProductNumber(productNum);
                unLockMc.setVerifyCode(verifyCode);
                unLockMc.setUserID(Constant.userId);
                unLockMc.setIsUnlock("0");
                unLockMc.setRunTime("-1");
                unLockMc.setCurrencyValue("-1");
                unLockMc.setGameGrade("-1");
                HttpUtil.getInstance().unLockMc(unLockMc).subscribe(
                        str -> {
                            if (str.contains("success\":true")) {
                                ToastUtil.getInstance().showToast("打码成功", 1000, getContext());
                                UnLockMcResponse unLockMcResponse = GsonUtil.fromJson(str, UnLockMcResponse.class);
                                UnLockMcResponse.ResultBean result = unLockMcResponse.getResult();
                                int score = Integer.parseInt(binding.score.getText().toString()) - Integer.parseInt(currentProfit);
                                binding.score.setText(score + "");
                                if (result != null) {
                                    String password = result.getPassword();
                                    binding.pwd.setText(password);
                                }
                                binding.commit.setEnabled(false);
                                binding.parmerterChange.setEnabled(false);
                            } else {
                                try {
                                    JSONObject jb = new JSONObject(str);
                                    JSONObject error = jb.getJSONObject("error");
                                    String message = error.getString("message");
                                    ToastUtil.getInstance().showToast(message, 1000, getContext());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                );
            }
        });


        RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(RxEvent rxEvent) {
                if (rxEvent.getEventType() == EventType.EVENTTYPE_DM_SUCCESSED) {
                    Bundle bundle = rxEvent.getBundle();
                    String psw = bundle.getString("psw");
                    binding.pwd.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.pwd.setText(psw);
                        }
                    });
                    binding.commit.setEnabled(false);
                    binding.parmerterChange.setEnabled(false);
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


}
