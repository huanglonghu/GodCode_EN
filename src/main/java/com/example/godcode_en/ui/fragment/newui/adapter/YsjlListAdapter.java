package com.example.godcode_en.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode_en.bean.YSRecord;
import com.example.godcode_en.databinding.ItemLvYsjlBinding;

import java.util.List;

public class YsjlListAdapter extends BaseListAdapter {

    public YsjlListAdapter(Context context, List<YSRecord.ResultBean.DataBean> datas, int res) {
        super(context, datas, res);
    }
    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        ItemLvYsjlBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        YSRecord.ResultBean.DataBean bean = (YSRecord.ResultBean.DataBean) datas.get(position);
        binding.setBean(bean);
        if(bean.isIsRefund()){
            binding.setIsIncome(false);
        }else {
            binding.setIsIncome(true);
        }
        return    binding.getRoot();
    }

}
