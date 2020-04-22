package com.example.godcode.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.godcode.R;
import com.example.godcode.bean.MyAssetList;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.ItemLvMyassetBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.constant.Constant;
import com.example.godcode.utils.FormatUtil;
import com.example.godcode.utils.LogUtil;
import java.util.HashMap;
import java.util.List;

public class AssetListAdapter extends BaseAdapter {

    private HashMap<Integer, View> viewMap = new HashMap<>();
    private LayoutInflater layoutInflater;
    private List<MyAssetList.ResultBean.DataBean> assetList;
    private Context context;


    public AssetListAdapter(Context context, List<MyAssetList.ResultBean.DataBean> assetList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.assetList = assetList;
    }

    @Override
    public int getCount() {
        return assetList == null ? 0 : assetList.size();
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
            ItemLvMyassetBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_lv_myasset, parent, false);
            binding.setPresenter(Presenter.getInstance());
            MyAssetList.ResultBean.DataBean dataBean = assetList.get(position);
            binding.setAssetBean(dataBean);
            if (dataBean.getFK_UserID() == Constant.userId) {
                binding.setIsMaster(true);
            } else {
                binding.setIsMaster(false);
            }
            String productImgUrl = dataBean.getProductImgUrl();
            if (!TextUtils.isEmpty(productImgUrl)) {
                if (!productImgUrl.contains("http")) {
                    productImgUrl = Constant.baseUrl + productImgUrl;
                }
                RxImageLoader.with(context).load(productImgUrl).into(binding.ivZc,2);
            }
            convertView = binding.getRoot();
            convertView.setTag(binding);
            viewMap.put(position, convertView);
        }

        return viewMap.get(position);
    }




    public void clearView() {
        viewMap.clear();
        assetList.clear();
        notifyDataSetChanged();
    }
}
