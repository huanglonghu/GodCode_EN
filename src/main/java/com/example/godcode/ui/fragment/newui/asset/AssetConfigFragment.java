package com.example.godcode.ui.fragment.newui.asset;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.bean.BindProduct;
import com.example.godcode.bean.EditProduct;
import com.example.godcode.bean.EditProductPrice;
import com.example.godcode.bean.EditProductSetting;
import com.example.godcode.bean.MyAssetList;
import com.example.godcode.bean.ProductSetting;
import com.example.godcode.bean.ReturnEquity;
import com.example.godcode.bean.UploadResponse;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.FragmentMyassetConfigBinding;
import com.example.godcode.handler.ActivityResultHandler;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.interface_.EtStrategy;
import com.example.godcode.interface_.HandlerStrategy;
import com.example.godcode.interface_.ProductSettingStrategy;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.fragment.newui.assetconfig.Curency;
import com.example.godcode.ui.fragment.newui.assetconfig.Jbyw;
import com.example.godcode.ui.fragment.newui.assetconfig.ProductPrice;
import com.example.godcode.ui.fragment.newui.assetconfig.Proportion;
import com.example.godcode.ui.fragment.newui.assetconfig.Volume;
import com.example.godcode.ui.view.widget.DeleteDialog;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.StringUtil;
import com.example.godcode.utils.ToastUtil;
import okhttp3.MultipartBody;

public class AssetConfigFragment extends BaseFragment {
    private FragmentMyassetConfigBinding binding;
    private View view;
    private MyAssetList.ResultBean.DataBean bean;
    private ProductSetting productSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myasset_config, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            binding.setFragment(this);
            initListener();
            Bundle bundle = getArguments();
            if (bundle != null) {
                bean = (MyAssetList.ResultBean.DataBean) bundle.getSerializable("dataBean");
                if (bean.getFK_UserID() == Constant.userId) {
                    binding.setIsMaster(true);
                }
            }
        }
        initView();
        initData();
        return view;
    }


    public void initData() {
        HttpUtil.getInstance().getProductSettingMsg(bean.getFK_ProductID()).subscribe(
                productSettingStr -> {
                    productSetting = GsonUtil.fromJson(productSettingStr, ProductSetting.class);
                }
        );
        binding.setAssetBean(bean);
    }

    public void initListener() {
        binding.unBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.getFK_UserID() == Constant.userId) {
                    String title = null;
                    if (type == 1) {
                        title = "Are you sure to unbind this product? ";
                        DeleteDialog deleteDialog = new DeleteDialog(activity, title, new ClickSureListener() {
                            @Override
                            public void clickSure() {
                                BindProduct body = new BindProduct();
                                body.setFK_UserID(bean.getFK_UserID());
                                body.setIsBind(false);
                                body.setProductName(bean.getProductName());
                                body.setProductNumber(bean.getProductNumber());
                                body.setMachineAddress(bean.getMachineAddress());
                                body.setFK_ProductCategoryID(bean.getProductCategoryID());
                                body.setPrice(bean.getPrice() + "");
                                HttpUtil.getInstance().bindProduct(body).subscribe(
                                        bindProductStr -> {
                                            if (bindProductStr.contains("\"success\":true")) {
                                                Toast.makeText(activity, "Unbundling success", Toast.LENGTH_SHORT).show();
                                                presenter.back();
                                            }
                                        }
                                );
                            }
                        });
                        deleteDialog.show();
                    } else if (type == 2) {
                        title = "Return equity?";
                        DeleteDialog deleteDialog = new DeleteDialog(activity, title, new ClickSureListener() {
                            @Override
                            public void clickSure() {
                                ReturnEquity returnEquity = new ReturnEquity();
                                returnEquity.setFK_UserID(bean.getFK_UserID());
                                returnEquity.setId(bean.getId());
                                HttpUtil.getInstance().returnEquity(returnEquity).subscribe(
                                        returnEquityStr -> {
                                            Toast.makeText(activity, "Successful return of property right", Toast.LENGTH_SHORT).show();
                                            presenter.back();
                                        }
                                );
                            }
                        });
                        deleteDialog.show();
                    }
                }
            }
        });

        binding.ivZc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                new ActivityResultHandler.Builder().hadlerStrategy(new HandlerStrategy() {
                    @Override
                    public void onActivityResult(MultipartBody.Part filePart, Bitmap bitmap) {
                        upload(filePart, bitmap);
                    }
                }).requestCode(ActivityResultHandler.REQUEST_SELECT_PHOTO).intent(intent).activity(activity).build().startActivityForResult();

            }
        });
    }


    public void assetConfig(int type) {
        ProductSetting.ResultBean result = productSetting.getResult();
        Integer productSettingId = result.getId();
        int productID = bean.getFK_ProductID();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bean);
        switch (type) {
            case 1:
                RevenueConfigFragment revenueConfigFragment = new RevenueConfigFragment();
                revenueConfigFragment.setArguments(bundle);
                presenter.step2Fragment(revenueConfigFragment, "revenue");
                break;
            case 2:
                ProductPrice productPrice = new ProductPrice();
                productPrice.setArguments(bundle);
                Presenter.getInstance().step2Fragment(productPrice, "productPrice");
                break;
            case 3:
                EditAssetFragment editAssetFragment = new EditAssetFragment();
                editAssetFragment.initData(bean);
                presenter.step2Fragment(editAssetFragment, "etAsset");
                break;
            case 4:
                Volume volume = new Volume();
                bundle.putInt("productId", productID);
                bundle.putInt("productSettingId", productSettingId);
                bundle.putInt("volume", result.getVolume());
                volume.setArguments(bundle);
                presenter.step2Fragment(volume, "volume");
                break;
            case 5:
                Jbyw jbyw = new Jbyw();
                bundle.putInt("productId", productID);
                bundle.putInt("productSettingId", productSettingId);
                bundle.putInt("coin", result.getCoinPlay());
                jbyw.setArguments(bundle);
                presenter.step2Fragment(jbyw, "jbyw");
                break;
            case 6:
                Curency curency = new Curency();
                Presenter.getInstance().step2Fragment(curency, "curency");
                break;
            case 7:
                Proportion proportion = new Proportion();
                Presenter.getInstance().step2Fragment(proportion, "proportion");
                break;
            case 8:

                break;
        }

    }

    private int type;

    public void initView() {
        if (bean.getPrimaevalUserID() == 0) {
            type = 1;
            String str = StringUtil.getString(activity, R.string.unbindAsset);
            binding.unBind.setText(str);
        } else {
            if (bean.getPrimaevalUserID() == Constant.userId) {
                type = 1;
                String str = StringUtil.getString(activity, R.string.unbindAsset);
                binding.unBind.setText(str);
            } else {
                type = 2;
                String fhgq = getResources().getString(R.string.fhgq);
                binding.unBind.setText(fhgq);
            }
        }
        String productImgUrl = bean.getProductImgUrl();
        if (!TextUtils.isEmpty(productImgUrl)) {
            if (!productImgUrl.contains("http")) {
                productImgUrl = Constant.baseUrl + productImgUrl;
            }
            RxImageLoader.with(getContext()).load(productImgUrl).into(binding.ivZc, 2);
        }
        binding.setAssetBean(bean);
    }


    public void upload(MultipartBody.Part filePart, Bitmap bitmap) {
        binding.ivZc.setBackground(new BitmapDrawable(bitmap));
        HttpUtil.getInstance().upload(filePart, 1).subscribe(
                uploadStr -> {
                    UploadResponse uploadResponse = GsonUtil.getInstance().fromJson(uploadStr, UploadResponse.class);
                    String picturePath = uploadResponse.getResult().get(0);
                    EditProduct editProduct = new EditProduct();
                    EditProduct.ProductBean productBean = new EditProduct.ProductBean();
                    productBean.setId(bean.getFK_ProductID());
                    productBean.setFK_ProductCategoryID(bean.getProductCategoryID());
                    productBean.setProductName(bean.getProductName());
                    productBean.setProductNumber(bean.getProductNumber());
                    productBean.setMachineAddress(bean.getMachineAddress());
                    productBean.setIsValid(true);
                    productBean.setThumbnailImgPath(picturePath);
                    editProduct.setProduct(productBean);
                    HttpUtil.getInstance().editProduct(editProduct).subscribe(
                    );
                }
        );
    }

    class EtProductPriceSt extends EtStrategy {
        @Override
        public void etComplete(String str, int position) {
            int price = Integer.parseInt(str);
            EditProductPrice editProductPrice = new EditProductPrice();
            EditProductPrice.ProductPriceBean productPriceBean = new EditProductPrice.ProductPriceBean();
            productPriceBean.setPrice(price);
            productPriceBean.setFK_ProductID(bean.getFK_ProductID());
            productPriceBean.setFK_UserID(bean.getFK_UserID());
            productPriceBean.setId(bean.getFK_PriceID());
            productPriceBean.setIsValid(true);
            editProductPrice.setProductPrice(productPriceBean);
            HttpUtil.getInstance().editProductPrice(editProductPrice).subscribe(
                    editPriceStr -> {
                        if (editPriceStr.contains("\"success\":true")) {
                            Toast.makeText(activity, "Modify the success", Toast.LENGTH_SHORT).show();
                            bean.setPrice(price);
                            binding.setAssetBean(bean);
                        } else {
                            Toast.makeText(activity, "Modify the failure", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }
    }

    class VolumeStrategy implements ProductSettingStrategy {

        @Override
        public void valueSetting(int value) {
            EditProductSetting.ProductSettingBean psb = getProductSettingBean();
            psb.setProductSettingType(1 + "");
            psb.setVolume(value + "");
            HttpUtil.getInstance().editProductSetting(psb).subscribe(
                    epsStr -> {
                        productSetting = GsonUtil.fromJson(epsStr, ProductSetting.class);
                        ToastUtil.getInstance().showToast("Modify the success", 1000, activity);
                    }
            );
        }
    }

    class JvStrategy implements ProductSettingStrategy {
        @Override
        public void valueSetting(int value) {
            EditProductSetting.ProductSettingBean psb = getProductSettingBean();
            psb.setProductSettingType(2 + "");
            psb.setAward(value + "");
            HttpUtil.getInstance().editProductSetting(psb).subscribe(
                    epsStr -> {
                        productSetting = GsonUtil.fromJson(epsStr, ProductSetting.class);
                        ToastUtil.getInstance().showToast("Modify the success", 1000, activity);
                    }
            );
        }
    }

    class CoinStrategy implements ProductSettingStrategy {
        @Override
        public void valueSetting(int value) {
            EditProductSetting.ProductSettingBean psb = getProductSettingBean();
            psb.setProductSettingType(3 + "");
            psb.setCoinPlay(value + "");
            HttpUtil.getInstance().editProductSetting(psb).subscribe(
                    epsStr -> {
                        productSetting = GsonUtil.fromJson(epsStr, ProductSetting.class);
                        ToastUtil.getInstance().showToast("Modify the success", 1000, activity);
                    }
            );

        }
    }

    @NonNull
    private EditProductSetting.ProductSettingBean getProductSettingBean() {
        EditProductSetting.ProductSettingBean psb = new EditProductSetting.ProductSettingBean();
        psb.setFK_ProductID(bean.getFK_ProductID());
        ProductSetting.ResultBean result = productSetting.getResult();
        if (result != null) {
            psb.setId(result.getId());
        }
        return psb;
    }

}
