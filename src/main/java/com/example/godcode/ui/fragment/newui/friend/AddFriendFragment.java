package com.example.godcode.ui.fragment.newui.friend;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.databinding.FragmentAddfriendBinding;
import com.example.godcode.greendao.entity.User;
import com.example.godcode.greendao.option.UserOption;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;

public class AddFriendFragment extends BaseFragment {

    private FragmentAddfriendBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_addfriend, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initData();
            initView();
            initListener();
        }
        return view;
    }


    public void initListener() {
        binding.addFriendSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = new SearchFragment();
                presenter.step2Fragment(searchFragment, "search");
            }
        });
    }


    public void initData() {
    }

    public void initView() {
        User user = UserOption.getInstance().querryUser(Constant.userId);
        if (user != null) {
            String syNumber = user.getSyNumber();
            binding.tvMySmNum.setText(syNumber);
        }

    }


}
