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
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.ApplyScoreBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.ToastUtil;

public class ApplyScore extends BaseFragment {

    private ApplyScoreBinding binding;

    @Override
    protected void lazyLoad() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.apply_score, container, false);
        binding.setPresenter(presenter);
        initView();
        initListen();
        return binding.getRoot();
    }

    private void initListen() {
        binding.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scoreStr = binding.score.getText().toString();
                if (TextUtils.isEmpty(scoreStr)) {
                    ToastUtil.getInstance().showToast("请输入积分", 1000, getContext());
                    return;
                }
                int score = Integer.parseInt(scoreStr);
                HttpUtil.getInstance().requestOrReturnFraction(Constant.userId, score, 1).subscribe(
                        str -> {

                        }
                );
            }
        });
    }

    private void initView() {
        int jf = getArguments().getInt("jf");
        binding.jf.setText(jf + "");

    }
}
