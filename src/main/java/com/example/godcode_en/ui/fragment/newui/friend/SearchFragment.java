package com.example.godcode_en.ui.fragment.newui.friend;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode_en.R;
import com.example.godcode_en.bean.QurreyFriend;
import com.example.godcode_en.bean.SearchListAdaPter;
import com.example.godcode_en.databinding.FragmentSearchBinding;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SearchFragment extends BaseFragment {
    private FragmentSearchBinding binding;
    private View view;
    private SearchListAdaPter adaPter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initView();
            initListener();
        }
        return view;
    }


    public void initListener() {

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.searchContent.setText("");
                datas.clear();
                adaPter.notifyDataSetChanged();
            }
        });

        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });


    }

    private ArrayList<QurreyFriend.ResultBean> datas = new ArrayList<>();


    public void initView() {

        adaPter = new SearchListAdaPter(datas, activity, presenter);
        binding.lvSearch.setAdapter(adaPter);


        TextWatcher searchWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!TextUtils.isEmpty(s)) {
                    if (binding.delete.getVisibility() != View.VISIBLE) {
                        binding.delete.setVisibility(View.VISIBLE);
                    }
                    String content = s.toString();
                    search(content);
                } else {
                    if (binding.delete.getVisibility() == View.VISIBLE) {
                        binding.delete.setVisibility(View.GONE);
                    }
                }

            }
        };
        binding.searchContent.addTextChangedListener(searchWatcher);


    }

    @Override
    public void initData() {


    }


    private void search(String content) {

        HttpUtil.getInstance().searchFriend(content).subscribe(
                addFriendStr -> {
                    QurreyFriend qurreyFriend = new Gson().fromJson(addFriendStr, QurreyFriend.class);
                    QurreyFriend.ResultBean result = qurreyFriend.getResult();
                    if (result != null) {
                        datas.add(result);
                        adaPter.notifyDataSetChanged();
                        binding.lvSearch.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(activity, "No user was found", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


}
