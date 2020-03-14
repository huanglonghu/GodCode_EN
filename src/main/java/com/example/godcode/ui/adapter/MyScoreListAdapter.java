package com.example.godcode.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.DmGroupMsg;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.ItemMyscoreBinding;
import com.example.godcode.utils.LogUtil;

import java.util.HashMap;
import java.util.List;

public class MyScoreListAdapter extends BaseListAdapter {
    private HashMap<Integer, View> indexMap = new HashMap<>();

    public MyScoreListAdapter(Context context, List datas, int res) {
        super(context, datas, res);
    }

    @Override
    View initView(LayoutInflater layoutInflater, int res, List datas, int position, ViewGroup parent) {
        ItemMyscoreBinding binding = DataBindingUtil.inflate(layoutInflater, res, parent, false);
        DmGroupMsg.ResultBean.DataBean dataBean = (DmGroupMsg.ResultBean.DataBean) datas.get(position);
        String imgUrl = dataBean.getHeadImgUrl();
        if (!TextUtils.isEmpty(imgUrl)) {
            if (!imgUrl.contains("http")) {
                imgUrl = Constant.baseUrl + imgUrl;
            }
            RxImageLoader.with(context).load(imgUrl).into(binding.iv);
        } else {
            binding.iv.setImageResource(R.drawable.contact_normal);
        }
        binding.setDataBean(dataBean);
        indexMap.put(dataBean.getFK_UserID(), binding.getRoot());
        return binding.getRoot();
    }


    public void notifyItem(int userId) {
        View view = indexMap.get(userId);
        ItemMyscoreBinding binding = DataBindingUtil.findBinding(view);
        binding.setShowNews(true);
    }

}
