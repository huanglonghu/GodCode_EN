package com.example.godcode.ui.fragment.mainActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.User;
import com.example.godcode.databinding.FragmentMainBinding;
import com.example.godcode.databinding.LayoutMainPopupBinding;
import com.example.godcode.greendao.option.FriendOption;
import com.example.godcode.greendao.option.UserOption;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.adapter.MyViewPagerAdapter;
import com.example.godcode.ui.base.Constant;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.MenuWindow;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainFragment extends BaseFragment {
    private FragmentMainBinding binding;
    private ArrayList<BaseFragment> fragments;
    private View view;
    private MenuWindow menuWindow;
    private int[] newsArray;

    public FragmentMainBinding getBinding() {
        return binding;
    }

    public void setBinding(FragmentMainBinding binding) {
        this.binding = binding;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
            presenter.setMainBinding(binding);
            binding.setNewsCount(0);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            binding.setPosition(0);
            initData();
            initFragments();
            initListener();
            MyViewPagerAdapter adapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments);
            binding.mainViewPager.setAdapter(adapter);
            binding.mainViewPager.setOffscreenPageLimit(3);
        }
        return view;
    }

    private void initData() {
        if (UserOption.getInstance().querryUser(Constant.userId) == null) {
            HttpUtil.getInstance().getUserMsgById(Constant.userId).subscribe(
                    personalStr -> {
                        User mine = new Gson().fromJson(personalStr, User.class);
                        User.ResultBean result = mine.getResult();
                        if (UserOption.getInstance().querryUser(Constant.userId) == null) {
                            Constant.userName = mine.getResult().getNickName();
                            Constant.syNum = mine.getResult().getUserName();
                            com.example.godcode.greendao.entity.User user = new com.example.godcode.greendao.entity.User();
                            user.setHeadImageUrl(result.getHeadImgUrl());
                            user.setUserName(result.getNickName());
                            user.setSyNumber(result.getUserName());
                            user.setArea(result.getArea());
                            user.setPhoneNumer(result.getPhoneNumber());
                            if (result.getSex() == 1) {
                                user.setSex("男");
                            } else {
                                user.setSex("女");
                            }
                            user.setUserId(result.getId());
                            UserOption.getInstance().addUser(user);
                            FriendOption.getInstance(activity).querryFriendList(1, true);
                        }
                    }
            );
        } else {
            com.example.godcode.greendao.entity.User user = UserOption.getInstance().querryUser(Constant.userId);
            Constant.userName = user.getUserName();
            Constant.syNum = user.getSyNumber();
        }
    }

    private void initListener() {
        binding.mainToolbar.ivMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.step2Fragment("personal");
            }
        });

        binding.mainToolbar.ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuWindow = new MenuWindow(activity);
                LayoutMainPopupBinding binding = menuWindow.getBinding1();
                binding.setFragment(MainFragment.this);
                menuWindow.show(v);
            }
        });

        binding.mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.setPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void refreshData() {

    }

    public void initFragments() {
        String[] titleArray = {"首页", "朋友", "发现", "我"};
        binding.setTitleArray(titleArray);
        fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        FriendFragment friendFragment = new FriendFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        friendFragment.setArguments(bundle);
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        MineFragment mineFragment = new MineFragment();
        fragments.add(homeFragment);
        fragments.add(friendFragment);
        fragments.add(discoveryFragment);
        fragments.add(mineFragment);
        presenter.setFragments(fragments);

    }

    public void config(View view) {
        switch (view.getId()) {
            case R.id.mainPopup_addFriend:
                presenter.step2Fragment("addFriend");
                break;
            case R.id.mainPopup_sys:
                presenter.sys();
                break;
            case R.id.mainPopup_gathering:
                presenter.step2Fragment("gathering");
                break;
        }
        menuWindow.dismiss();
    }

}
