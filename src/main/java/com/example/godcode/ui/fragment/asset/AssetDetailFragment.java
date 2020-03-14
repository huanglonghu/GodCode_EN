package com.example.godcode.ui.fragment.asset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.godcode.R;
import com.example.godcode.bean.MyAssetList;
import com.example.godcode.bean.ProductCategory;
import com.example.godcode.bean.WebSocketNews1;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.ItemLvMyassetBinding;
import com.example.godcode.databinding.LayoutAssetDetailBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.adapter.AssetListAdapter;
import com.example.godcode.ui.view.MyListView;
import com.example.godcode.ui.view.widget.AssetSelectDialog;
import com.example.godcode.utils.FormatUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AssetDetailFragment extends BaseAssetFragment implements AssetSelectDialog.AssetSelect, MyListView.RefreshData {
    private AssetListAdapter assetListAdapter;
    private LayoutAssetDetailBinding binding;
    private AssetData assetData;
    private int periodType;
    private int groupId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.layout_asset_detail, null, false);
            binding.lvDetail.setRefreshData(this);
            initView();
            initListener();
        }
        initData();
        return binding.getRoot();
    }


    private void initView() {
        assetListAdapter = new AssetListAdapter(activity, assetList, categoryMap);
        binding.lvDetail.setAdapter(assetListAdapter);
    }

    private void initData() {
        Bundle arguments = getArguments();
        periodType = arguments.getInt("periodType");
        binding.setSelectPosition(periodType);
        groupId = arguments.getInt("groupId");
        String name = arguments.getString("groupName");
        binding.setTitle(name);
        String[] fcArray = getResources().getStringArray(R.array.fcArray);
        String[] tbArray = getResources().getStringArray(R.array.tbArray);
        String[] zcArray = getResources().getStringArray(R.array.zcArray);
        binding.setFcArray(fcArray);
        binding.setTbArray(tbArray);
        binding.setZcArray(zcArray);
        assetData = new AssetData();
        binding.setAssetData(assetData);
        status = 2;
        getProductCategorys();
    }

    private void initListener() {
        binding.setFragment(this);
        binding.lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemLvMyassetBinding binding = DataBindingUtil.findBinding(view);
                MyAssetList.ResultBean.DataBean dataBean = assetList.get(position);
                if (binding.getIsMaster() || FormatUtil.getInstance().isBeginWith4G(dataBean.getProductNumber())) {
                    AssetConfigFragment asset_2_fragment = new AssetConfigFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dataBean", dataBean);
                    asset_2_fragment.setArguments(bundle);
                    presenter.step2Fragment(asset_2_fragment, "asset_2");
                }
            }
        });

        binding.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssetSelectDialog assetSelectDialog = new AssetSelectDialog(activity, typeMap);
                assetSelectDialog.setAssetSelect(AssetDetailFragment.this);
                assetSelectDialog.show();
            }
        });

        RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable disposable) {
            }

            @Override
            public void onNext(RxEvent rxEvent) {
                if (rxEvent.getEventType() == EventType.EVENTTYPE_DIVIDE_MSG) {
                    WebSocketNews1.DataBean data = (WebSocketNews1.DataBean) rxEvent.getBundle().getSerializable("dataBean");
                    String productNumber = data.getProductNumber();
                    if (periodType != 2 && assetMap.containsKey(productNumber)) {
                        int position = assetMap.get(productNumber);
                        int coinCount = data.getCoinCount();
                        double coinDivedeMoney = data.getCoinDivedeMoney();
                        double paperMoney = data.getPaperMoney();
                        assetData.setPapaer(assetData.getPapaer() + paperMoney);
                        assetData.setCoinDivide(assetData.getCoinDivide() + coinDivedeMoney);
                        assetData.setCoin(assetData.getCoin() + coinCount);
                        assetListAdapter.refreshData(position, coinCount, paperMoney, coinDivedeMoney);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onComplete() {
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });
    }

    private List<ProductCategory.ResultBean.ItemsBean> categoryList;
    private HashMap<Integer, Integer> categoryMap = new HashMap<>();
    private HashMap<String, Integer> typeMap = new HashMap<>();

    private void getProductCategorys() {
        HttpUtil.getInstance().getAllProductCategorys().subscribe(
                productCategory -> {
                    ProductCategory category = new Gson().fromJson(productCategory, ProductCategory.class);
                    categoryList = category.getResult().getItems();
                    for (int i = 0; i < categoryList.size(); i++) {
                        ProductCategory.ResultBean.ItemsBean itemsBean = categoryList.get(i);
                        int purview = itemsBean.getPurview();
                        int id = itemsBean.getId();
                        String productType = itemsBean.getProductType();
                        categoryMap.put(id, purview);
                        typeMap.put(productType, id);
                    }
                    refreshData(1);
                }
        );
    }

    private String productType;
    private int selectPosition;
    private String UserNameOrAddress;
    private int status;
    private HashMap<String, Integer> assetMap = new HashMap<>();
    private List<MyAssetList.ResultBean.DataBean> assetList = new ArrayList<>();

    @Override
    public void sureSelect(int position, String productType, String UserNameOrAddress) {
        assetList.clear();
        assetListAdapter.clearView(periodType);
        this.selectPosition = position;
        this.productType = productType;
        this.UserNameOrAddress = UserNameOrAddress;
        binding.lvDetail.setState(2);
    }

    @Override
    public void refreshData(int page) {
        HashMap<String, String> urlMap = new HashMap<>();
        urlMap.put("UserId", String.valueOf(Constant.userId));
        urlMap.put("limit", "20");
        urlMap.put("PeriodType", periodType + "");
        urlMap.put("CurrentGroupUserID", groupId + "");
        if (selectPosition == 1) {
            urlMap.put("isMaster", true + "");
        } else if (selectPosition == 2) {
            urlMap.put("isMaster", false + "");
        }
        urlMap.put("isValid", status + "");
        if (!TextUtils.isEmpty(UserNameOrAddress)) {
            urlMap.put("ProductNameOrAddress", UserNameOrAddress);
        }
        if (!TextUtils.isEmpty(productType)) {
            urlMap.put("ProductType", productType);
        }
        urlMap.put("page", page + "");
        HttpUtil.getInstance().getGroupById(urlMap).subscribe(
                assetStr -> {
                    MyAssetList myAssetList = new Gson().fromJson(assetStr, MyAssetList.class);
                    MyAssetList.ResultBean result = myAssetList.getResult();
                    List<MyAssetList.ResultBean.DataBean> datas = result.getData();
                    assetData.setSumCount(result.getCount());
                    assetData.setNormalCount(result.getNormalCount());
                    assetData.setErrorCount(result.getErrorCount());
                    assetData.setPapaer(result.getPaperCoinCount());
                    assetData.setDivide(result.getDividedMoney());
                    assetData.setCoinDivide(result.getCoinDividedMoney());
                    assetData.setCoin(result.getCoinCount());
                    if (page == 1) {
                        assetListAdapter.clearView(periodType);
                    }
                    if (datas != null && datas.size() > 0) {
                        binding.lvDetail.setState(0);
                        for (int i = 0; i < datas.size(); i++) {
                            MyAssetList.ResultBean.DataBean dataBean = datas.get(i);
                            assetMap.put(dataBean.getProductNumber(), i);
                            assetList.add(dataBean);
                        }
                    } else {
                        binding.lvDetail.setState(1);
                    }
                    assetListAdapter.notifyDataSetChanged();
                }
        );
    }

    @Override
    public void selectDate(int periodType) {
        this.periodType = periodType;
        refreshData(1);
    }

    @Override
    public void querryByStatus(int status) {
        this.status = status;
        refreshData(1);
    }
}
