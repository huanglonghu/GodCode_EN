package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode.R;
import com.example.godcode.bean.EditProduct;
import com.example.godcode.bean.MyAssetList;
import com.example.godcode.databinding.FragmentEditAssetBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class EditAssetFragment extends BaseFragment {

    private FragmentEditAssetBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_asset, container, false);
            view = binding.getRoot();
            binding.setPresenter(presenter);
            binding.setBean(bean);
            initView();
            initListener();
        }
        return view;
    }


    private void initListener() {
        binding.editAssetToolbar.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(binding.productName.getText())) {
                    if (!TextUtils.isEmpty(binding.productAddress.getText())) {
                        editAsset(binding.productName.getText().toString(), binding.productAddress.getText().toString());
                    } else {
                        Toast.makeText(activity, "Please enter the product address", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(activity, "Please enter the product name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void editAsset(String productName, String adress) {
        EditProduct editProduct = new EditProduct();
        EditProduct.ProductBean productBean = new EditProduct.ProductBean();
        productBean.setId(bean.getFK_ProductID());
        productBean.setFK_ProductCategoryID(bean.getProductCategoryID());
        productBean.setProductName(productName);
        productBean.setProductNumber(bean.getProductNumber());
        productBean.setMachineAddress(adress);
        productBean.setIsValid(true);
        editProduct.setProduct(productBean);
        HttpUtil.getInstance().editProduct(editProduct).subscribe(
                editProductStr -> {
                    assetUpdate.assetUpdate(productName,adress);
                    Toast.makeText(activity, "Modify the success", Toast.LENGTH_SHORT).show();
                    presenter.back();
                }
        );
    }

    private MyAssetList.ResultBean.DataBean bean;

    public void initData(MyAssetList.ResultBean.DataBean bean) {
        this.bean = bean;
    }


    public void initView() {
        binding.editAssetToolbar.tvOption.setText("Save");
    }


    @Override
    protected void lazyLoad() {
    }


    public interface AssetUpdate {
        void assetUpdate(String productName, String adress);
    }

    private AssetUpdate assetUpdate;

    public void setAssetUpdate(AssetUpdate assetUpdate) {
        this.assetUpdate = assetUpdate;
    }
}
