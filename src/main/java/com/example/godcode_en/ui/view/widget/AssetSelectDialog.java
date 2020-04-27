package com.example.godcode_en.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;

import com.example.godcode_en.R;
import com.example.godcode_en.databinding.ItemAssetGridBinding;
import com.example.godcode_en.databinding.LayoutAssetDialogBinding;
import com.example.godcode_en.presenter.Presenter;

import java.util.ArrayList;
import java.util.HashMap;

public class AssetSelectDialog extends Dialog {
    private int selectPosition;
    private LayoutAssetDialogBinding binding;
    private ArrayList<String> typeList;
    private HashMap<String, Integer> typeMap;


    public AssetSelectDialog(@NonNull Context context, HashMap<String, Integer> typeMap) {
        super(context, R.style.dialog2);
        this.typeMap = typeMap;
        typeList = new ArrayList<>(typeMap.keySet());
        initView(context);
    }

    private void initView(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_asset_dialog, null, false);
        binding.setAssetDialog(this);
        AssetGridAdapter assetGridAdapter = new AssetGridAdapter(typeList, context);
        binding.gridAsset.setAdapter(assetGridAdapter);
        binding.sureGridAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < selectList.size(); i++) {
                    String name = selectList.get(i);
                    int id = typeMap.get(name);
                    if (i == selectList.size() - 1) {
                        sb.append(id);
                    } else {
                        sb.append(id + ",");
                    }
                }
                String s = binding.UserNameOrAddress.getText().toString();
                assetSelect.sureSelect(selectPosition, sb.toString(),s);
                dismiss();
            }
        });
        getWindow().setWindowAnimations(R.style.popupStyle);
        setContentView(binding.getRoot());
        setCancelable(false);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = Presenter.getInstance().getWindowWidth();
        layoutParams.height =WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.5f;
        getWindow().setAttributes(layoutParams);
    }


    public void selectSj(int position) {
        binding.setPosition(position);
        selectPosition = position;
    }

    public interface AssetSelect {
        void sureSelect(int position, String productType,String UserNameOrAddress );
    }

    private AssetSelect assetSelect;

    public void setAssetSelect(AssetSelect assetSelect) {
        this.assetSelect = assetSelect;
    }

    private ArrayList<String> selectList = new ArrayList<>();

    private class AssetGridAdapter extends BaseAdapter {
        private ArrayList<String> typeList;
        private HashMap<Integer, View> viewMap = new HashMap<>();
        private LayoutInflater layoutInflater;


        public AssetGridAdapter(ArrayList<String> typeList, Context context) {
            this.typeList = typeList;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return typeList.size();
        }

        @Override
        public Object getItem(int position) {
            return typeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (viewMap.get(position) == null) {
                ItemAssetGridBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_asset_grid, parent, false);
                binding.gridAssetItem.setText(typeList.get(position));
                convertView = binding.getRoot();
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.isSelected()) {
                            v.setSelected(false);
                            selectList.remove(typeList.get(position));
                        } else {
                            v.setSelected(true);
                            selectList.add(typeList.get(position));
                        }
                    }
                });
                viewMap.put(position, convertView);
            }
            return viewMap.get(position);
        }
    }


}
