package com.example.godcode_en.ui.fragment.newui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.godcode_en.R;
import com.example.godcode_en.bean.MyAssetList;
import com.example.godcode_en.catche.Loader.RxImageLoader;
import com.example.godcode_en.databinding.ItemLvMyassetBinding;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.presenter.Presenter;

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

            binding.showQrcode.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(event.getAction()== MotionEvent.ACTION_UP){

                        Presenter.getInstance().showQrDialog(dataBean.getProductNumber());
                    }

                    return false;
                }
            });

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
