package com.example.godcode_en.ui.fragment.newui.friend;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode_en.R;
import com.example.godcode_en.bean.ApplyFriend;
import com.example.godcode_en.databinding.FragmentNewfriendBinding;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.fragment.newui.adapter.NewFriendListAdapter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;

public class NewFriendFragment extends BaseFragment {
    private FragmentNewfriendBinding binding;
    private View view;
    private List<ApplyFriend.ResultBean.ItemsBean> items;
    private NewFriendListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_newfriend, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initListener();
        }
        initData();
        return view;
    }


    public void initListener() {

    }

    private void querryFriendList(int page, boolean isConcur) {
        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        HashMap<String, String> urlMap = new HashMap<>();
        urlMap.put("Filter", "");
        urlMap.put("sorting", "");
        urlMap.put("UserId", Constant.userId + "");
        urlMap.put("isConcur", isConcur + "");
        HttpUtil.getInstance().getFriendList(urlMap).subscribe(
                getFriendListStr -> {
                    ApplyFriend applyFriend = new Gson().fromJson(getFriendListStr, ApplyFriend.class);
                    items = applyFriend.getResult().getItems();
                    initView();
                }
        );
    }




    public void initData() {
        querryFriendList(1, false);
    }


    public void initView() {
        adapter = new NewFriendListAdapter(activity, items, R.layout.item_lv_newfriend);
        binding.lvNewFriend.setAdapter(adapter);
        binding.addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFriendFragment addFriendFragment = new AddFriendFragment();
                Presenter.getInstance().step2Fragment(addFriendFragment,"addFriend");
            }
        });

    }

}
