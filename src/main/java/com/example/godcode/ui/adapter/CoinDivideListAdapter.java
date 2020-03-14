package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.bean.CoinDivideRecord;
import com.example.godcode.bean.YSRecord;
import com.example.godcode.databinding.ItemLvCoindivideBinding;
import com.example.godcode.databinding.ItemLvYsjlBinding;
import com.example.godcode.utils.DateUtil;
import com.example.godcode.utils.FormatUtil;

import java.util.List;

public class CoinDivideListAdapter extends BaseListAdapter {

    public CoinDivideListAdapter(Context context, List<CoinDivideRecord.ResultBean.DataBean> datas, int res) {
        super(context, datas, res);
    }
    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        ItemLvCoindivideBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        CoinDivideRecord.ResultBean.DataBean bean = (CoinDivideRecord.ResultBean.DataBean) datas.get(position);
        binding.setBean(bean);
        String money = FormatUtil.getInstance().get2double(bean.getDivideAmount());
        binding.setMoney(money);
        String time  = DateUtil.getInstance().formatDate(bean.getAddDatetime());
        binding.ysjlDate.setText(time);
        return    binding.getRoot();
    }

}
