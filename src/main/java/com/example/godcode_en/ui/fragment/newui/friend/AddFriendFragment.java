package com.example.godcode_en.ui.fragment.newui.friend;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode_en.R;
import com.example.godcode_en.databinding.FragmentAddfriendBinding;
import com.example.godcode_en.greendao.entity.User;
import com.example.godcode_en.greendao.option.UserOption;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;

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
                Presenter.getInstance().step2Fragment(searchFragment, "searchFriend");
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
