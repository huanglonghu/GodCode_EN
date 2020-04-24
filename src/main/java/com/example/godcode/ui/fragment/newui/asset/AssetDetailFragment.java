package com.example.godcode.ui.fragment.newui.asset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.example.godcode.R;
import com.example.godcode.bean.MyAssetList;
import com.example.godcode.bean.WebSocketNews1;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.ItemLvMyassetBinding;
import com.example.godcode.databinding.LayoutAssetDetailBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.fragment.newui.adapter.AssetListAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetDetailFragment extends BaseAssetFragment {
    private AssetListAdapter assetListAdapter;
    private LayoutAssetDetailBinding binding;
    private int periodType;
    private int groupId;
    private int status;
    private HashMap<String, Integer> assetMap = new HashMap<>();
    private List<MyAssetList.ResultBean.DataBean> datas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.layout_asset_detail, null, false);
            initView();
            initListener();
        }
        initData();
        return binding.getRoot();
    }


    public void initView() {
        datas = new ArrayList<>();
        assetListAdapter = new AssetListAdapter(activity, datas);
        binding.lvDetail.setAdapter(assetListAdapter);
    }

    public void initData() {
        Bundle arguments = getArguments();
        periodType = arguments.getInt("periodType");
        groupId = arguments.getInt("groupId");
        String name = arguments.getString("groupName");
        binding.setSelectPosition(periodType);
        binding.title.setText(name);
        String[] fcArray = getResources().getStringArray(R.array.fcArray);
        String[] tbArray = getResources().getStringArray(R.array.tbArray);
        String[] zcArray = getResources().getStringArray(R.array.zcArray);
        binding.setFcArray(fcArray);
        binding.setTbArray(tbArray);
        binding.setZcArray(zcArray);
        status = 2;
        selectDate(1);
    }

    public void initListener() {
        binding.setFragment(this);
        binding.lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemLvMyassetBinding binding = DataBindingUtil.findBinding(view);
                MyAssetList.ResultBean.DataBean dataBean = datas.get(position);
                if (binding.getIsMaster()) {
                    AssetConfigFragment asset_2_fragment = new AssetConfigFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dataBean", dataBean);
                    asset_2_fragment.setArguments(bundle);
                    presenter.step2Fragment(asset_2_fragment, "asset_2");
                }
            }
        });

        RxBus.getInstance().toObservable(RxEvent.class).subscribe(
                rxEvent -> {
                    if (rxEvent.getEventType() == EventType.EVENTTYPE_DIVIDE_MSG) {
                        WebSocketNews1.DataBean data = (WebSocketNews1.DataBean) rxEvent.getBundle().getSerializable("dataBean");
                        String productNumber = data.getProductNumber();
                        if (periodType != 2 && assetMap.containsKey(productNumber)) {
                            int position = assetMap.get(productNumber);
                            MyAssetList.ResultBean.DataBean dataBean = datas.get(position);
                            int coin = data.getCoinCount();
                            double divedeMoney = data.getCoinDivedeMoney();
                            double paper = data.getPaperMoney();
                            dataBean.setCoinDivideIncome(divedeMoney + dataBean.getCoinDivideIncome());
                            dataBean.setTodayBanknote((int) paper + dataBean.getTodayBanknote());
                            dataBean.setTodayCoin(coin + dataBean.getTodayCoin());
                            datas.set(position, dataBean);
                            assetListAdapter.notifyDataSetChanged();
                        }
                    }
                }

        );

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });
    }


    public void refreshData(int page) {
        if (page == 1 && datas.size() > 0) {
            assetListAdapter.clearView();
        }
        HashMap<String, Integer> urlMap = new HashMap<>();
        urlMap.put("page", page);
        urlMap.put("UserId", Constant.userId);
        urlMap.put("limit", 20);
        urlMap.put("PeriodType", periodType);
        urlMap.put("CurrentGroupUserID", groupId);
        urlMap.put("isValid", status);
        HttpUtil.getInstance().getGroupById(urlMap).subscribe(
                assetStr -> {
                    MyAssetList myAssetList = new Gson().fromJson(assetStr, MyAssetList.class);
                    MyAssetList.ResultBean data = myAssetList.getResult();
                    if (data != null) {
                        binding.setData(data);
                        List<MyAssetList.ResultBean.DataBean> list = data.getData();
                        if (list != null && list.size() > 0) {
                            datas.addAll(list);
                            for (int i = 0; i < list.size(); i++) {
                                MyAssetList.ResultBean.DataBean dataBean = list.get(i);
                                assetMap.put(dataBean.getProductNumber(), i);
                            }
                            assetListAdapter.notifyDataSetChanged();
                        }
                    }
                }
        );
    }


    public void selectDate(int periodType) {
        this.periodType = periodType;
        binding.setSelectPosition(periodType);
        refreshData(1);
    }

    @Override
    public void querryByStatus(int status) {
        this.status = status;
        refreshData(1);
    }
}
