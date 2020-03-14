package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.bean.GroupItemDetail;
import com.example.godcode.databinding.GroupitemItemBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.fragment.dm.McDetail;

import java.util.ArrayList;
import java.util.List;

public class GroupItemListAdapter extends BaseListAdapter {
    private ArrayList<Integer> idList = new ArrayList<>();
    private int userId;

    public GroupItemListAdapter(Context context, List datas, int res,int userId) {
        super(context, datas, res);
        this.userId=userId;
    }

    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        GroupitemItemBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        GroupItemDetail.ResultBean.DataBean dataBean = (GroupItemDetail.ResultBean.DataBean) datas.get(position);
        binding.setDataBean(dataBean);
        View view = binding.getRoot();
        view.setTag(binding);
        binding.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = binding.cb.isChecked();
                if (checked) {
                    idList.add(dataBean.getMcProductID());
                } else {
                    int i = idList.indexOf(dataBean.getMcProductID());
                    idList.remove(i);
                }
            }
        });
        binding.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                McDetail mcDetail = new McDetail();
                Bundle bundle = new Bundle();
                bundle.putInt("userId", userId);
                bundle.putInt("productId",dataBean.getMcProductID());
                mcDetail.setArguments(bundle);
                Presenter.getInstance().step2Fragment(mcDetail, "mcDetail");
            }
        });
        return view;
    }


    @Override
    public void setSelect(View view, int option, int position) {
        GroupitemItemBinding binding = (GroupitemItemBinding) view.getTag();
        binding.setOption(option);
    }

    public ArrayList<Integer> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<Integer> idList) {
        this.idList = idList;
    }


}
