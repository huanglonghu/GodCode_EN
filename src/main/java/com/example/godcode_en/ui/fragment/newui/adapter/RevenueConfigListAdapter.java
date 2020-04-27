package com.example.godcode_en.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.godcode_en.R;
import com.example.godcode_en.bean.RevenueDivideItem;
import com.example.godcode_en.databinding.ItemLvRevenueconfigBinding;
import com.example.godcode_en.ui.fragment.newui.asset.RevenueConfigFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class RevenueConfigListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<RevenueDivideItem> divideList;
    private RevenueConfigFragment fragment;
    private HashMap<Integer, View> viewMap = new HashMap<>();

    public RevenueConfigListAdapter(Context context, ArrayList<RevenueDivideItem> divideList, RevenueConfigFragment fragment) {
        this.context = context;
        this.divideList = divideList;
        this.fragment = fragment;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return divideList.size();
    }

    @Override
    public Object getItem(int position) {
        return divideList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (viewMap.get(position) == null) {
            ItemLvRevenueconfigBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_lv_revenueconfig, parent, false);
            binding.setFragment(fragment);
            RevenueDivideItem revenueDivideItem = divideList.get(position);
            binding.setRevenueDivideItem(revenueDivideItem);
            binding.setPosition(position);
            convertView = binding.getRoot();
            convertView.setTag(binding);
            viewMap.put(position, convertView);
        }
        return viewMap.get(position);
    }


    public void refresData(int position){
        View view = getView(position, null, null);
        ItemLvRevenueconfigBinding binding = (ItemLvRevenueconfigBinding) view.getTag();
        binding.setRevenueDivideItem(divideList.get(position));
    }


}
