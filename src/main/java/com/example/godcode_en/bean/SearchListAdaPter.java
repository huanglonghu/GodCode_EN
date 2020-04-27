package com.example.godcode_en.bean;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.godcode_en.R;
import com.example.godcode_en.catche.Loader.RxImageLoader;
import com.example.godcode_en.databinding.ItemLvSearchBinding;
import com.example.godcode_en.greendao.entity.Friend;
import com.example.godcode_en.greendao.option.FriendOption;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.fragment.newui.friend.ContactDetailFragment;
import com.example.godcode_en.ui.fragment.newui.UserFragment;
import com.example.godcode_en.utils.ImagUtil;

import java.util.ArrayList;

public class SearchListAdaPter extends BaseAdapter {

    private ArrayList<QurreyFriend.ResultBean> datas;
    private LayoutInflater inflater;
    private Presenter presenter;
    private Context context;

    public SearchListAdaPter(ArrayList<QurreyFriend.ResultBean> datas, Context context, Presenter presenter) {
        this.datas = datas;
        this.presenter = presenter;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemLvSearchBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_lv_search, parent, false);
        convertView = binding.getRoot();
        QurreyFriend.ResultBean resultBean = datas.get(position);
        binding.name.setText(resultBean.getNickName());
        String headImgUrl = resultBean.getHeadImgUrl();
        String url = ImagUtil.handleUrl(headImgUrl);
        if (!TextUtils.isEmpty(url)) {
            RxImageLoader.with(context).load(url).into(binding.friendPhoto, 3);
        } else {
            binding.friendPhoto.setBackgroundResource(R.drawable.contact_normal);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend friend = FriendOption.getInstance(context).querryFriend(resultBean.getId());
                if (friend == null) {
                    UserFragment userFragment = new UserFragment();
                    userFragment.initData(resultBean.getId());
                    presenter.step2Fragment(userFragment, "user");
                } else {
                    ContactDetailFragment cdf = new ContactDetailFragment();
                    cdf.initData(friend.getUserId());
                    presenter.step2Fragment(cdf, "cdf");
                }

            }
        });
        return convertView;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;
}
