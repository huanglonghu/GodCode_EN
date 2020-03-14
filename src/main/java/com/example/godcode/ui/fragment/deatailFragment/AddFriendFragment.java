package com.example.godcode.ui.fragment.deatailFragment;

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
import com.example.godcode.utils.StringUtil;


public class AddFriendFragment extends BaseFragment {

    private FragmentAddfriendBinding binding;
    private boolean isPrepared;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_addfriend, container, false);
            isPrepared = true;
            binding.setPresenter(presenter);
            String title = StringUtil.getString(activity, R.string.addFriend);
            binding.addFriendToolBar.title.setText(title);
            view = binding.getRoot();
            initData();
            initView();
            lazyLoad();
            initListener();
        }
        return view;
    }

    private void initListener() {
        binding.addFriendSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = new SearchFragment();
                presenter.step2Fragment(searchFragment, "search");
            }
        });
    }


    private void initData() {}

    public void initView() {
        User user = UserOption.getInstance().querryUser(Constant.userId);
        binding.tvMySmNum.setText("My ID:" + user.getSyNumber());
    }

    @Override
    protected void lazyLoad() {

    }


}
