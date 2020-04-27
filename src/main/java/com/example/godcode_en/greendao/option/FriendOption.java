package com.example.godcode_en.greendao.option;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

import com.example.godcode_en.bean.FriendListResponse;
import com.example.godcode_en.greendao.entity.Friend;
import com.example.godcode_en.greendao.gen.FriendDao;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.ui.base.GodCodeApplication;
import com.example.godcode_en.utils.StringUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class FriendOption {

    private Subject<Object, Boolean> friendUpdate;

    private FriendOption(Context context) {
        friendUpdate = new SerializedSubject(PublishSubject.create());
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.godcode_en.service.friendUpdate");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                querryFriendList(1, true);
            }
        };
        context.registerReceiver(receiver, filter);
    }

    public rx.Observable<Boolean> friendUpdateListener() {
        return friendUpdate;
    }

    private static FriendOption defaultInstane;

    public static FriendOption getInstance(Context context) {
        FriendOption friendOption = defaultInstane;
        if (defaultInstane == null) {
            synchronized (FriendOption.class) {
                if (defaultInstane == null) {
                    friendOption = new FriendOption(context);
                    defaultInstane = friendOption;
                }
            }
        }
        return friendOption;
    }


    public Friend querryFriend(int userId) {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        Friend friend = friendDao.queryBuilder()
                .where(FriendDao.Properties.UserId.eq(userId), FriendDao.Properties.FriendId.eq(Constant.userId)).unique();
        return friend;
    }

    public Friend querryFriend(String friendName) {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        Friend friend = friendDao.queryBuilder()
                .where(FriendDao.Properties.UserName.eq(friendName), FriendDao.Properties.FriendId.eq(Constant.userId)).unique();
        return friend;
    }

    public void addFriend(FriendListResponse.ResultBean.ItemsBean itemsBean) {
        Friend friend = querryFriend(itemsBean.getToUserID());
        if (friend == null) {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        friend = new Friend();
        friend.setUserId(itemsBean.getToUserID());
        friend.setUserName(itemsBean.getNickName());
        friend.setFriendId(Constant.userId);
        friend.setHeadImageUrl(itemsBean.getFriendImgPath());
        friend.setSyNum(itemsBean.getToUserName());
        friend.setId_(itemsBean.getId());
        String nickName = itemsBean.getNickName();
        if (!TextUtils.isEmpty(nickName)) {
            String firstChar = StringUtil.getPingYin(nickName).substring(0, 1);
            friend.setFirstChar(firstChar.toUpperCase());
        }
        friendDao.insert(friend);
    }

}


    public void deleteFriend(int id) {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        Friend friend = querryFriend(id);
        friendDao.delete(friend);
        friendUpdate.onNext(true);
    }

    public List<Friend> getAllFriend(int friendId) {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        List<Friend> friends = friendDao.queryBuilder()
                .where(FriendDao.Properties.FriendId.eq(friendId))
                .orderAsc(FriendDao.Properties.FirstChar)
                .list();
        return friends;
    }

    public void updateFriend(Friend friend) {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        friendDao.update(friend);
    }


    public void querryFriendList(int page, boolean isConcur) {
        clear();
        HashMap<String, String> urlMap = new HashMap<>();
        urlMap.put("UserId", Constant.userId + "");
        urlMap.put("isConcur", isConcur + "");
        HttpUtil.getInstance().getFriendList(urlMap).subscribe(
                getFriendListStr -> {
                   //  getFriendListStr="{\"result\":{\"totalCount\":4,\"items\":[{\"fK_UserID\":11,\"toUserID\":20,\"nickName\":\"Dan\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":28},{\"fK_UserID\":11,\"toUserID\":21,\"nickName\":\"a\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":29},{\"fK_UserID\":11,\"toUserID\":22,\"nickName\":\"a1\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":27},{\"fK_UserID\":11,\"toUserID\":23,\"nickName\":\"b\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":30},{\"fK_UserID\":11,\"toUserID\":24,\"nickName\":\"c\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":31},{\"fK_UserID\":11,\"toUserID\":25,\"nickName\":\"d\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":32},{\"fK_UserID\":11,\"toUserID\":26,\"nickName\":\"f\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":33},{\"fK_UserID\":11,\"toUserID\":27,\"nickName\":\"k\",\"toUserName\":\"sy1537220696\",\"friendImgPath\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/4rDU87Tvl7PRYiblHibW8mgfFTGxUgp1cl9aLGSicbV9cFHiaSEcUbcFPdSzcx8ia6UzFOBicHGL1jiblevQ4JuBRtwCw/132\",\"addTime\":\"2018-09-17T21:47:01.9069447\",\"isConcur\":true,\"id\":34}]},\"targetUrl\":null,\"success\":true,\"error\":null,\"unAuthorizedRequest\":false,\"__abp\":true}";
                    FriendListResponse friendListResponse = new Gson().fromJson(getFriendListStr, FriendListResponse.class);
                    List<FriendListResponse.ResultBean.ItemsBean> items = friendListResponse.getResult().getItems();
                    for (int i = 0; i < items.size(); i++) {
                        FriendListResponse.ResultBean.ItemsBean itemsBean = items.get(i);
                        addFriend(itemsBean);
                    }
                    friendUpdate.onNext(true);
                }
        );
    }


    public void clear() {
        FriendDao friendDao = GodCodeApplication.getInstance().getDaoSession().getFriendDao();
        friendDao.deleteAll();
    }


}
