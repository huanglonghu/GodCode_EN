package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.bean.FrcationOption;
import com.example.godcode.bean.ScoreOptionRecord;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.McdetailItemBinding;
import com.example.godcode.greendao.entity.Friend;
import com.example.godcode.greendao.option.FriendOption;

import java.text.NumberFormat;
import java.util.List;

public class ScoreOptionListAdapter extends BaseListAdapter {
    public ScoreOptionListAdapter(Context context, List datas, int res) {
        super(context, datas, res);
    }

    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        McdetailItemBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        ScoreOptionRecord.ResultBean.DataBean dataBean = (ScoreOptionRecord.ResultBean.DataBean) datas.get(position);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        String formatValue = nf.format(dataBean.getFraction());
        StringBuffer sb = new StringBuffer();
        int type = dataBean.getType();
        int fk_userID = dataBean.getFK_UserID();
        int giveUserID = dataBean.getGiveUserID();
        String addDateTime = dataBean.getAddDateTime();

        switch (type) {
            case 0://向平台获取积分
                sb.append("向平台获取积分");
                binding.setIsProfit(true);
                break;
            case 1://申请积分
                if (giveUserID == Constant.userId) {
                    Friend friend = FriendOption.getInstance(context).querryFriend(fk_userID);
                    String userName = friend.getUserName();
                    sb.append(userName+ "向你申请积分");
                    binding.setIsProfit(false);
                } else {
                    sb.append("申请积分");
                    binding.setIsProfit(true);
                }
                break;
            case 2://返还积分
                if (giveUserID == Constant.userId) {
                    Friend friend = FriendOption.getInstance(context).querryFriend(fk_userID);
                    String userName = friend.getUserName();
                    sb.append(fk_userID + "向你返还积分");
                    binding.setIsProfit(true);
                } else {
                    sb.append("返还积分");
                    binding.setIsProfit(false);
                }
                break;
        }
        binding.title.setText(sb.toString());
        binding.date.setText(addDateTime);
        if (binding.getIsProfit()) {
            binding.value.setText("+" + formatValue);
        } else {
            binding.value.setText("-" +formatValue);
        }
        return binding.getRoot();

    }
}
