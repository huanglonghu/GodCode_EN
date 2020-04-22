package com.example.godcode.ui.fragment.newui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.R;
import com.example.godcode.bean.Notices;
import com.example.godcode.databinding.FragmentDiscoveryBinding;
import com.example.godcode.ui.base.BaseFragment;
import java.util.List;

public class DiscoveryFragment extends BaseFragment {
    private FragmentDiscoveryBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discovery, container, false);
            view = binding.getRoot();
            initView();
            initListener();
        }
        return view;
    }




    public void initListener() {
    }


    private List<Notices.DataBean> data;

    public void initView() {}

    @Override
    public void initData() {

    }

}
