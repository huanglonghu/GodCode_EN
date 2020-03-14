package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.R;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.FragmentMyagentBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.YqmDialog;

public class MyAgent extends BaseFragment {


    private FragmentMyagentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myagent, container, false);
            binding.setPresenter(Presenter.getInstance());
        }
        initListen();
        return binding.getRoot();
    }

    private void initListen() {

        binding.yqm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YqmDialog yqmDialog = new YqmDialog(getContext(), Constant.userId);
                yqmDialog.show();
            }
        });

        binding.txsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxSy txSy = new TxSy();
                Presenter.getInstance().step2Fragment(txSy,"txsy");
            }
        });

    }

    @Override
    protected void lazyLoad() {
    }
}
