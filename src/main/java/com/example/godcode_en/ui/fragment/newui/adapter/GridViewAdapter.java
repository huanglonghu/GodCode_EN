package com.example.godcode_en.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.godcode_en.R;
import com.example.godcode_en.databinding.LayoutGridItemBinding;

import java.util.ArrayList;
import java.util.HashMap;


public class GridViewAdapter extends BaseAdapter {

    private HashMap<Integer, View> viewMap = new HashMap<>();
    private LayoutInflater layoutInflater;
    private ArrayList<String> typeList = new ArrayList<>();

    public GridViewAdapter(ArrayList<String> typeList, Context context, int selectPosition) {
        this.selectPosition = selectPosition;
        layoutInflater = LayoutInflater.from(context);
        this.typeList = typeList;
    }

    public void setSelectPosition(int position) {
        LayoutGridItemBinding binding = (LayoutGridItemBinding) viewMap.get(selectPosition).getTag();
        binding.tv.setBackgroundResource(0);
        this.selectPosition = position;
    }

    private int selectPosition;

    @Override
    public int getCount() {
        return typeList == null ? 0 : typeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (viewMap.get(position) == null) {
            LayoutGridItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_grid_item, parent, false);
            String productType = typeList.get(position);
            binding.tv.setText(productType);
            if (position == selectPosition) {
                binding.tv.setBackgroundResource(R.drawable.bg_wxdl);
            }
            convertView = binding.getRoot();
            convertView.setTag(binding);
            viewMap.put(position, convertView);
        }
        return viewMap.get(position);
    }

}
