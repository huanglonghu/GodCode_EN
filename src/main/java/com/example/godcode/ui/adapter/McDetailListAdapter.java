package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.bean.McUnlockDetail;
import com.example.godcode.databinding.McdetailItemBinding;
import java.util.List;

public class McDetailListAdapter extends BaseListAdapter {
    public McDetailListAdapter(Context context, List datas, int res) {
        super(context, datas, res);
    }

    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        McdetailItemBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        McUnlockDetail.ResultBean.DataBean dataBean = (McUnlockDetail.ResultBean.DataBean) datas.get(position);
        String mcProductNumber = dataBean.getMcProductNumber();
        int currentProfit = 0 - dataBean.getCurrentProfit();
        if (currentProfit > 0) {
            binding.title.setText(mcProductNumber + "号机收入积分");
            binding.setIsProfit(true);
        } else {
            binding.title.setText(mcProductNumber + "号机消费积分");
            binding.setIsProfit(false);
        }
        binding.date.setText(dataBean.getAddDateTime());
        binding.setDataBean(dataBean);
        if(binding.getIsProfit()){
            binding.value.setText("+"+(0-dataBean.getCurrentProfit()));
        }else {
            binding.value.setText(""+(0-dataBean.getCurrentProfit()));
        }
        return binding.getRoot();
    }
}
