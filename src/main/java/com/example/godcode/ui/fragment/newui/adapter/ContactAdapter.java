package com.example.godcode.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.godcode.R;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.ItemFootBinding;
import com.example.godcode.databinding.ItemFriendBinding;
import com.example.godcode.databinding.ItemHeadBinding;
import com.example.godcode.greendao.entity.Friend;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.StringUtil;
import java.util.HashMap;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Presenter presenter;
    private int type;
    private List<Friend> friendList;
    private int HEAD_COUNT = 1;
    private int FOOT_COUNT = 1;
    private final int TYPE_HEAD = 0;
    private final int TYPE_CONTENT = 1;
    private final int TYPE_FOOTER = 2;
    private Context context;
    private HashMap<String, Friend> charcterMap2 = new HashMap<>();
    private HashMap<Integer, View> viewMap = new HashMap<>();


    public ContactAdapter(Context context, Presenter presenter, int type) {
        mLayoutInflater = LayoutInflater.from(context);
        this.presenter = presenter;
        this.type = type;
        this.context = context;
        if (type != 1) {
            HEAD_COUNT = 0;
            FOOT_COUNT = 0;
        }
    }


    public void initCharcterMap() {
        for (int i = 0; i < friendList.size(); i++) {
            Friend friend = friendList.get(i);
            String firstChar = friend.getFirstChar();
            if (!charcterMap2.containsKey(firstChar)) {
                charcterMap2.put(firstChar, friend);
            }
        }
    }

    public void refreshData(List<Friend> friendList) {
        this.friendList = friendList;
        initCharcterMap();
        notifyDataSetChanged();
    }

    public void initData(int viewType, int position) {
        View view = getView(position, null, null);
        if (viewType == TYPE_HEAD) {
            ItemHeadBinding binding = (ItemHeadBinding) view.getTag();
            if (position == 0) {
                String str = StringUtil.getString(context, R.string.newfriend);
                binding.headName.setText(str);
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.step2Fragment("newFriend");
                        presenter.showNew(2);
                    }
                });
            }
        } else if (viewType == TYPE_CONTENT) {
            Friend friend = friendList.get(position - HEAD_COUNT);
            ItemFriendBinding binding = (ItemFriendBinding) view.getTag();
            String headImageUrl = friend.getHeadImageUrl();
            String firstChar = friend.getFirstChar();
            if (charcterMap2.get(firstChar) == friend) {
                binding.setCharacter(firstChar);
            }
            if (!TextUtils.isEmpty(headImageUrl)) {
                if (!headImageUrl.contains("http")) {
                    headImageUrl = Constant.baseUrl + headImageUrl;
                }
                RxImageLoader.with(context).load(headImageUrl).into(binding.friendPhoto,1);
            } else {
                binding.friendPhoto.setBackgroundResource(R.drawable.contact_normal);
            }
            binding.setType(type);
            binding.setFriend(friend);
            binding.setPresenter(presenter);
        } else if (viewType == TYPE_FOOTER) {
            ItemFootBinding binding = (ItemFootBinding) view.getTag();
            String friendNum = StringUtil.getString(context, R.string.friendNum);
            binding.foot.setText((friendList == null ? 0 : friendList.size()) + friendNum);
        }
    }

    @Override
    public int getCount() {
        return friendList == null ? HEAD_COUNT + FOOT_COUNT : friendList.size() + HEAD_COUNT + FOOT_COUNT;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (viewMap.get(position) == null) {
            int viewType = getViewType(position);
            if (viewType == TYPE_HEAD) {
                ItemHeadBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_head, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
                viewMap.put(position, convertView);
            } else if (viewType == TYPE_FOOTER) {
                ItemFootBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_foot, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
                viewMap.put(position, convertView);
            } else if (viewType == TYPE_CONTENT) {
                ItemFriendBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_friend, parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
                viewMap.put(position, convertView);
            }
            initData(viewType, position);
        }

        return viewMap.get(position);
    }


    public int getViewType(int position) {
        if (type == 1) {
            if (position == 0) { // 头部
                return TYPE_HEAD;
            } else if (position == getCount() - 1) { // 尾部
                return TYPE_FOOTER;
            } else {
                return TYPE_CONTENT;
            }
        } else {
            return TYPE_CONTENT;
        }
    }

    public int getScrollPosition(String character) {
        int position = -1;
        String s = character.toUpperCase();
        if (charcterMap2.containsKey(s)) {
            Friend friend = charcterMap2.get(s);
            int i = friendList.indexOf(friend);
            return i + 1;
        }

        return position; // -1不会滑动
    }


    public void clear() {
        charcterMap2.clear();
        viewMap.clear();
        if (friendList != null) {
            friendList.clear();
        }
    }

}
