package com.example.godcode.ui.fragment.newui.main;

import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode.R;
import com.example.godcode.bean.DivideIncome;
import com.example.godcode.databinding.FragmentHomeBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.EtStrategy;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.service.NetStateReceiver;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.view.widget.NetStateDialog;
import com.example.godcode.utils.GsonUtil;
import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HomeFragment extends BaseFragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
            binding.setPresenter(presenter);
            initListener();
            isMakeCode();
            RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
                @Override
                public void onSubscribe(Disposable disposable) {}
                @Override
                public void onNext(RxEvent rxEvent) {
                    int eventType = rxEvent.getEventType();
                    if (eventType == EventType.EVENTTYPE_REFRESH_NOTIFICATION || eventType == EventType.EVENTTYPE_BALANCE_CHANGE || eventType == EventType.EVENTTYPE_ADDFRIEND) {
                        refreshNotification();
                    }
                    if (eventType == EventType.EVENTTYPE_DIVIDE_MSG || eventType == EventType.EVENTTYPE_BALANCE_CHANGE) {
                        refreshDivideIncome();
                    }
                }

                @Override
                public void onError(Throwable throwable) {}

                @Override
                public void onComplete() {

                }
            });

        }
        initBalanceMsg();
        initView();
        return binding.getRoot();
    }

    private void initBalanceMsg() {
    }


    public void refreshDivideIncome() {
        HttpUtil.getInstance().getDivideIncome(Constant.userId).subscribe(
                divideStr -> {
                    DivideIncome divideIncome = GsonUtil.getInstance().fromJson(divideStr, DivideIncome.class);
                    DivideIncome.ResultBean result = divideIncome.getResult();
                    initBalanceMsg();
                }
        );
    }


    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    public void initListener() {
        NetStateReceiver netStateReceiver = new NetStateReceiver(new EtStrategy() {
            @Override
            public void netChange(boolean isConnect) {
                if (isConnect) {
                    refreshDivideIncome();
                } else {
                    NetStateDialog netStateDialog = new NetStateDialog(getContext());
                    netStateDialog.show();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getActivity().registerReceiver(netStateReceiver, intentFilter);
    }


    public void refreshNotification() {
        initView();
        binding.setShowNews(true);
    }


    public void isMakeCode() {
        HttpUtil.getInstance().getUserMsgById(Constant.userId).subscribe(
                personalStr -> {
                    com.example.godcode.bean.User mine = new Gson().fromJson(personalStr, com.example.godcode.bean.User.class);
                    com.example.godcode.bean.User.ResultBean result = mine.getResult();
                    if (result != null) {
                        boolean makeCode = result.isMakeCode();
                        binding.setIsMakeCode(makeCode);
                    }
                }
        );
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isVisible()) {
            isMakeCode();
            refreshDivideIncome();
        }
    }


}
