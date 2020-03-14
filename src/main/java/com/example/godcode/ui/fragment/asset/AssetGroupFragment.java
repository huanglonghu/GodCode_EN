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
import com.example.godcode.bean.GroupMsg;
import com.example.godcode.bean.WebSocketNews1;
import com.example.godcode.databinding.LayoutAssetGroupBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.adapter.GroupListAdapter;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.LogUtil;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AssetGroupFragment extends BaseAssetFragment {
    private GroupListAdapter groupListAdapter;
    private LayoutAssetGroupBinding binding;
    private AssetData assetData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(binding==null){
            binding = DataBindingUtil.inflate(inflater, R.layout.layout_asset_group, null, false);
            initView();
            initListener();
        }

        initData();
        return binding.getRoot();
    }


    private void initView() {
        groupListAdapter = new GroupListAdapter(activity, groupList);
        binding.lvGroup.setAdapter(groupListAdapter);
    }

    private void initData() {
        String[] fcArray = getResources().getStringArray(R.array.fcArray);
        String[] tbArray = getResources().getStringArray(R.array.tbArray);
        String[] zcArray = getResources().getStringArray(R.array.zcArray);
        binding.setFcArray(fcArray);
        binding.setTbArray(tbArray);
        binding.setZcArray(zcArray);
        assetData = new AssetData();
        binding.setAssetData(assetData);
        selectDate(1);
    }


    private void initListener() {
        binding.setFragment(this);
        binding.lvGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroupMsg.ResultBean.bean bean = groupList.get(position);
                int selectPosition = binding.getSelectPosition();
                Bundle bundle = new Bundle();
                bundle.putInt("groupId", bean.getFK_UserID());
                bundle.putInt("periodType", selectPosition);
                bundle.putString("groupName", bean.getUserName());
                AssetDetailFragment assetDetailFragment = new AssetDetailFragment();
                assetDetailFragment.setArguments(bundle);
                Presenter.getInstance().step2Fragment(assetDetailFragment, "assetDetail");
            }
        });

        RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable disposable) {
            }

            @Override
            public void onNext(RxEvent rxEvent) {
                if (rxEvent.getEventType() == EventType.EVENTTYPE_DIVIDE_MSG) {
                    WebSocketNews1.DataBean dataBean = (WebSocketNews1.DataBean) rxEvent.getBundle().getSerializable("dataBean");
                    double coinDivedeMoney = dataBean.getCoinDivedeMoney();
                    int coinCount = dataBean.getCoinCount();
                    double paperMoney = dataBean.getPaperMoney();
                    assetData.setCoin(assetData.getCoin() + coinCount);
                    LogUtil.log(assetData.getCoinDivide()+"========coin========"+coinDivedeMoney);
                    assetData.setCoinDivide(assetData.getCoinDivide() + coinDivedeMoney);
                    assetData.setPapaer(assetData.getPapaer() + paperMoney);
                    String merchantUserIds = dataBean.getMerchantUserIds();
                    if (!TextUtils.isEmpty(merchantUserIds)) {
                        if (merchantUserIds.contains("-")) {
                            String[] split = merchantUserIds.split("-");
                            for (int i = 0; i < split.length; i++) {
                                int id = Integer.parseInt(split[i]);
                                groupListAdapter.refreshDataByGroupId(id, coinCount, paperMoney);
                            }
                        } else {
                            int id = Integer.parseInt(merchantUserIds);
                            groupListAdapter.refreshDataByGroupId(id, coinCount, paperMoney);
                        }
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



        binding.asset1Toolbar.toolbar4Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Presenter.getInstance().back();
            }
        });
    }



    private ArrayList<GroupMsg.ResultBean.bean> groupList = new ArrayList<>();


    @Override
    public void selectDate(int periodType) {
        binding.setSelectPosition(periodType);
        HttpUtil.getInstance().getGroup(periodType).subscribe(
                groupStr -> {
                    GroupMsg groupMsg = GsonUtil.fromJson(groupStr, GroupMsg.class);
                    GroupMsg.ResultBean result = groupMsg.getResult();
                    int normalCount = result.getNormalCount();
                    int errorCount = result.getErrorCount();
                    assetData.setErrorCount(errorCount);
                    assetData.setNormalCount(normalCount);
                    assetData.setSumCount(errorCount+normalCount);
                    assetData.setCoin(result.getCoinCount());
                    assetData.setCoinDivide(result.getCoinDividedMoney());
                    assetData.setDivide(result.getDividedMoney());
                    assetData.setPapaer(result.getPaperCoinCount());
                    groupListAdapter.clearData(periodType);
                    Map<String, GroupMsg.ResultBean.bean> data = result.getData();
                    if (data != null && data.size() > 0) {
                        for (String a : data.keySet()) {
                            GroupMsg.ResultBean.bean bean = data.get(a);
                            bean.setUserName(a);
                            groupList.add(bean);
                        }
                        groupListAdapter.notifyDataSetChanged();
                    }
                }
        );
    }

}
