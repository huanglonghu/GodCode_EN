package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.BankBean;
import com.example.godcode.databinding.LvSelectbankItemBinding;

import java.util.List;

public class BankSelectAdapter extends BaseListAdapter {

    public BankSelectAdapter(Context context, List datas, int res) {
        super(context, datas, res);
    }

    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {

        LvSelectbankItemBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        BankBean bankBean = (BankBean) datas.get(position);
        binding.bankName.setText(bankBean.getBankName() + "(" + bankBean.getLastfourNum() + ")");
        binding.bankIcon.setImageResource(bankBean.getBankIconRes());
        return binding.getRoot();
    }

    public void selectItem(int position) {
        View view = getView(position);
        LvSelectbankItemBinding binding = DataBindingUtil.findBinding(view);
        binding.cb.setSelected(true);
    }
}
