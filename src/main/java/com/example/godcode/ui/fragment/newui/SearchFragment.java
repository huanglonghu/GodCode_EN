package com.example.godcode.ui.fragment.newui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.QurreyFriend;
import com.example.godcode.bean.SearchListAdaPter;
import com.example.godcode.databinding.FragmentSearchBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SearchFragment extends BaseFragment {
    private FragmentSearchBinding binding;
    private View view;

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
        binding.searchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.back();
            }
        });
    }

    private ArrayList<QurreyFriend.ResultBean> datas = new ArrayList<>();


    public void initView() {
        SearchListAdaPter adaPter = new SearchListAdaPter(datas, activity, presenter);
        binding.searchList.setAdapter(adaPter);
        binding.searchview.setSubmitButtonEnabled(true);
        binding.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                datas.clear();
                if (!TextUtils.isEmpty(query)) {
                    HttpUtil.getInstance().searchFriend(query).subscribe(
                            addFriendStr -> {
                                QurreyFriend qurreyFriend = new Gson().fromJson(addFriendStr, QurreyFriend.class);
                                QurreyFriend.ResultBean result = qurreyFriend.getResult();
                                if (result != null) {
                                    datas.add(result);
                                    adaPter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(activity, "No user was found", Toast.LENGTH_SHORT).show();
                                }
                            }
                    );
                } else {
                    Toast.makeText(activity, "Please enter what you want to query", Toast.LENGTH_SHORT).show();
                }

                return true;
            }

            public boolean onQueryTextChange(String newText) {

                if (TextUtils.isEmpty(newText)) {
                    //清空listview
                    datas.clear();
                    adaPter.notifyDataSetChanged();
                }

//                if (TextUtils.isEmpty(newText)) {
//                } else {
//                    findList.clear();
//                    for (int i = 0; i < list.size(); i++) {
//                        iconInformation information = list.get(i);
//                        if (information.getName().contains(newText)) {
//                            findList.add(information);
//                        }
//                    }
//                    findAdapter = new listViewAdapter(activity, findList);
//                    findAdapter.notifyDataSetChanged();
//                    listView.setAdapter(findAdapter);
//                }
                return true;

            }
        });


    }

    @Override
    public void initData() {

    }


}
