package com.example.godcode.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.ApplyFriend;
import com.example.godcode.bean.ConcurAddFriend;
import com.example.godcode.bean.ConcurAddFriendResponse;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.ItemLvNewfriendBinding;
import com.example.godcode.constant.Constant;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.fragment.newui.ContactDetailFragment;
import com.google.gson.Gson;
import java.util.List;

public class NewFriendListAdapter extends BaseListAdapter {
    public NewFriendListAdapter(Context context, List<ApplyFriend.ResultBean.ItemsBean> datas, int res) {
        super(context, datas, res);
    }

    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        ItemLvNewfriendBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        ApplyFriend.ResultBean.ItemsBean itemsBean = (ApplyFriend.ResultBean.ItemsBean) datas.get(position);
        binding.setItem(itemsBean);
        binding.btnAcceptfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceptFriend(itemsBean);
            }
        });
        String friendImgPath = itemsBean.getFriendImgPath();
        if (!TextUtils.isEmpty(friendImgPath)) {
            if (!friendImgPath.contains("http")) {
                friendImgPath = Constant.baseUrl + friendImgPath;
            }
            RxImageLoader.with(context).load(friendImgPath).into(binding.itemNewfriendPhoto,1);
        } else {
            binding.itemNewfriendPhoto.setImageResource(R.drawable.contact_normal);
        }
        return binding.getRoot();
    }


    public void acceptFriend(ApplyFriend.ResultBean.ItemsBean bean) {
        ConcurAddFriend concurAddFriend = new ConcurAddFriend();
        concurAddFriend.setIsConcur(true);
        concurAddFriend.setId(bean.getId());
        HttpUtil.getInstance().concurAddFriend(concurAddFriend).subscribe(
                concurAddFriendStr -> {
                    ConcurAddFriendResponse concurAddFriendResponse = new Gson().fromJson(concurAddFriendStr, ConcurAddFriendResponse.class);
                    if (concurAddFriendResponse.isSuccess()) {
                        ContactDetailFragment cdf = new ContactDetailFragment();
                        cdf.initData(bean.getFK_UserID());
                        Presenter.getInstance().step2Fragment(cdf, "cdf");
                    }
                }
        );
    }
}
