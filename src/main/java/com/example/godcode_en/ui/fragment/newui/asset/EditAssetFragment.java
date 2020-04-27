package com.example.godcode_en.ui.fragment.newui.asset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godcode_en.R;
import com.example.godcode_en.bean.EditProduct;
import com.example.godcode_en.bean.MyAssetList;
import com.example.godcode_en.catche.Loader.RxImageLoader;
import com.example.godcode_en.databinding.FragmentEditAssetBinding;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.utils.ImagUtil;

public class EditAssetFragment extends BaseFragment {

    private FragmentEditAssetBinding binding;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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


    public void initListener() {
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = binding.productName.getText().toString();
                if (TextUtils.isEmpty(productName)) {
                    Toast.makeText(activity, "Please enter the product name", Toast.LENGTH_SHORT).show();
                    return;
                }
                String productAdress = binding.productAddress.getText().toString();
                if (TextUtils.isEmpty(productAdress)) {
                    Toast.makeText(activity, "Please enter the product address", Toast.LENGTH_SHORT).show();
                    return;
                }
                editAsset(productName, productAdress);
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
                    bean.setProductName(productName);
                    bean.setMachineAddress(adress);
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

        String productImgUrl = bean.getProductImgUrl();
        String url = ImagUtil.handleUrl(productImgUrl);
        if (!TextUtils.isEmpty(url)) {
            RxImageLoader.with(getContext()).load(url).into(binding.iv, 3);
        }


    }

    @Override
    public void initData() {

    }


}
