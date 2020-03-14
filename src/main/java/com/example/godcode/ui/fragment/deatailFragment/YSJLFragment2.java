package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.CoinDivideRecord;
import com.example.godcode.databinding.FragmentCoinDivideBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.ui.adapter.CoinDivideListAdapter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.MyListView;
import com.example.godcode.utils.DateUtil;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class YSJLFragment2 extends BaseFragment implements MyListView.RefreshData, SelectTimeFragment.TimeSelect {
    private FragmentCoinDivideBinding binding;
    private View view;
    private List<CoinDivideRecord.ResultBean.DataBean> data;
    private CoinDivideListAdapter coinDivideListAdapter;
    private CompositeDisposable compositeDisposable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_coin_divide, null, false);
            binding.setPresenter(presenter);
            binding.lvYsjl.setRefreshData(this);
            view = binding.getRoot();
            data = new ArrayList<>();
            initView();
            initData();
            initListener();
            refreshData(1);
        }
        return view;
    }

    private void initView() {
        binding.tvDate1.setText(time1);
        binding.tvDate2.setText(time2);
        String title = StringUtil.getString(activity, R.string.totalYs);
        binding.setTitle(title);
        coinDivideListAdapter = new CoinDivideListAdapter(activity, data, R.layout.item_lv_coindivide);
        binding.lvYsjl.setAdapter(coinDivideListAdapter);
    }

    private void initListener() {
        binding.calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeFragment selectTimeFragment = new SelectTimeFragment();
                selectTimeFragment.setTimeSelect(YSJLFragment2.this);
                presenter.step2Fragment(selectTimeFragment, "selectTime");
            }
        });
        compositeDisposable = new CompositeDisposable();
        RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(RxEvent rxEvent) {
                //处理事件
                if (rxEvent.getEventType() == EventType.EVENTTYPE_DIVIDE_MSG || rxEvent.getEventType() == EventType.EVENTTYPE_REFRESH_YSJL) {
                    data.clear();
                    coinDivideListAdapter.clearView();
                    binding.lvYsjl.setState(2);
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

    }


    @Override
    protected void lazyLoad() {
    }

    private String time1;
    private String time2;

    public void initData() {
        time1 = DateUtil.getInstance().getToday();
        time2 = time1;
        binding.tvDate1.setText(time1);
        binding.tvDate2.setText(time2);
    }

    @Override
    public void refreshData(int page) {
        HttpUtil.getInstance().getCoinDivide(time1, time2, page).subscribe(
                str -> {
                    CoinDivideRecord coinDivideRecord = GsonUtil.fromJson(str, CoinDivideRecord.class);
                    CoinDivideRecord.ResultBean result = coinDivideRecord.getResult();
                    if (result != null) {
                        double currentIncome = result.getCurrentIncome();
                        double frontIncome = result.getFrontIncome();
                        binding.dqsy.setText(currentIncome + "");
                        binding.sqsy.setText(frontIncome + "");
                        double sumIncome = result.getSumIncome();
                        binding.sz.setText(sumIncome + "");
                        List<CoinDivideRecord.ResultBean.DataBean> list = result.getData();
                        if (list != null && list.size() > 0) {
                            data.addAll(list);
                            coinDivideListAdapter.notifyDataSetChanged();
                            binding.lvYsjl.setState(0);
                        } else {
                            binding.lvYsjl.setState(1);
                        }
                    }
                }
        );
    }

    @Override
    public void setDate(String date1, String date2) {
        this.time1 = date1;
        this.time2 = date2;
        binding.tvDate1.setText(time1);
        binding.tvDate2.setText(time2);
        data.clear();
        coinDivideListAdapter.clearView();
        binding.lvYsjl.setState(2);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
