package com.example.godcode.ui.fragment.newui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.bean.AddFriend;
import com.example.godcode.bean.QurreyFriend;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.FragmentUserBinding;
import com.example.godcode.greendao.entity.Friend;
import com.example.godcode.greendao.option.FriendOption;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.GsonUtil;

public class UserFragment extends BaseFragment {
    private FragmentUserBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
            view = binding.getRoot();
            binding.setPresenter(presenter);
            initView();
            initListener();
        }
        return view;
    }


    public void initView() {
        binding.userDetailToolbar.title.setText("Detailed information on");

        Friend friend = FriendOption.getInstance(activity).querryFriend(id);
        if (friend == null) {
            HttpUtil.getInstance().getUserMsgById(id).subscribe(
                    userStr -> {
                        QurreyFriend qurreyFriend = GsonUtil.getInstance().fromJson(userStr, QurreyFriend.class);
                        QurreyFriend.ResultBean bean = qurreyFriend.getResult();
                        String headImgUrl = bean.getHeadImgUrl();
                        setHeadImg(headImgUrl);
                        binding.tvUserName.setText(bean.getNickName());
                        binding.tvNumber.setText(bean.getUserName());
                        binding.userArea.setText(bean.getArea());
                    }
            );
        } else {
            setHeadImg(friend.getHeadImageUrl());
            binding.tvUserName.setText(friend.getUserName());

        }


    }

    @Override
    public void initData() {

    }

    private void setHeadImg(String headImgUrl) {
        if (!TextUtils.isEmpty(headImgUrl)) {
            if (!headImgUrl.contains("http")) {
                headImgUrl = Constant.baseUrl + headImgUrl;
            }
            RxImageLoader.with(activity).load(headImgUrl).into(binding.ivUser,1);
        }
    }


    public void initListener() {
        binding.btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFriend addFriend = new AddFriend();
                AddFriend.FriendsBean friendsBean = new AddFriend.FriendsBean();
                friendsBean.setFK_UserID(Constant.userId);
                friendsBean.setToUserID(id);
                addFriend.setFriends(friendsBean);
                HttpUtil.getInstance().addFriend(addFriend).subscribe(
                        addFriendStr -> {
                            Toast.makeText(activity, "A friend request has been sent", Toast.LENGTH_SHORT).show();
                        }
                );
            }
        });
    }


    private int id;

    public void initData(int id) {
        this.id = id;
    }

}
