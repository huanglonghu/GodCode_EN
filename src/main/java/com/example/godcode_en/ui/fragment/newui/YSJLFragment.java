package com.example.godcode_en.ui.fragment.newui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.example.godcode_en.R;
import com.example.godcode_en.bean.YSRecord;
import com.example.godcode_en.databinding.FragmentYsjlBinding;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.observable.EventType;
import com.example.godcode_en.observable.RxBus;
import com.example.godcode_en.observable.RxEvent;
import com.example.godcode_en.ui.fragment.newui.adapter.YsjlListAdapter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.ui.view.customview.MyListView;
import com.example.godcode_en.utils.FormatUtil;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class YSJLFragment extends BaseFragment implements MyListView.RefreshData, SelectTimeFragment.TimeSelect {
    private FragmentYsjlBinding binding;
    private View view;
    private List<YSRecord.ResultBean.DataBean> data;
    private YsjlListAdapter ysjlListAdapter;
    private CompositeDisposable compositeDisposable;
    private String currentDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_ysjl, null, false);
            binding.setPresenter(presenter);
            binding.lvYsjl.setRefreshData(this);
            binding.setYsjl(this);
            view = binding.getRoot();
            data = new ArrayList<>();
            initView();
            initData();
            initListener();
        }
        return view;
    }


    public void initView() {
        ysjlListAdapter = new YsjlListAdapter(activity, data, R.layout.item_lv_ysjl);
        binding.lvYsjl.setAdapter(ysjlListAdapter);
    }

    @Override
    public void initData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        currentDate = simpleDateFormat.format(date);
        time2 = currentDate;
        time1 = currentDate;
        refreshData(1);
    }


    public void initListener() {
        binding.lvYsjl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                YSJLDetailFragment ysjlDetailFragment = new YSJLDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("ysjlItem", data.get(position));
                ysjlDetailFragment.setArguments(bundle);
                presenter.step2Fragment(ysjlDetailFragment, "ysjl_detail");
            }
        });

        binding.calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeFragment selectTimeFragment = new SelectTimeFragment();
                selectTimeFragment.setTimeSelect(YSJLFragment.this);
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
                    ysjlListAdapter.clearView();
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

        binding.deleteDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.time1.setText("");
                binding.time2.setText("");
                binding.llDateFilter.setVisibility(View.GONE);
            }
        });

    }


    private String time1;
    private String time2;


    public void seleDate(int dateType) {

        switch (dateType) {
            case 1:
                time1 = "2018-1-1";
                time2 = currentDate;
                break;
            case 2:
                time1 = getDate1();
                time2 = currentDate;
                break;
            case 3:
                time1 = getDate2();
                time2 = currentDate;
                break;
        }
        refreshData(1);
    }


    private String getDate1() {
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        return y + "-" + m + "-1";
    }

    private String getDate2() {
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        return y + "-1" + "-1";
    }


    @Override
    public void refreshData(int page) {
        if (page == 1 && data.size() > 0) {
            data.clear();
            ysjlListAdapter.clearView();
            ysjlListAdapter.notifyDataSetChanged();
        }
        HttpUtil.getInstance().getYSRecord(time1, time2, page).subscribe(
                ysRecordStr -> {
                    YSRecord ysRecord = new Gson().fromJson(ysRecordStr, YSRecord.class);
                    List<YSRecord.ResultBean.DataBean> list = ysRecord.getResult().getData();
                    double allSumMoney = ysRecord.getResult().getAllSumMoney();
                    binding.divideIncomeTotal.setText(FormatUtil.getInstance().get2double(allSumMoney));
                    if (list != null && list.size() > 0) {
                        data.addAll(list);
                        ysjlListAdapter.notifyDataSetChanged();
                        binding.lvYsjl.setState(0);
                    } else {
                        binding.lvYsjl.setState(1);
                    }
                }
        );
    }

    @Override
    public void setDate(String date1, String date2) {
        this.time1 = date1;
        this.time2 = date2;
        binding.time1.setText(time1);
        binding.time2.setText(time2);
        binding.llDateFilter.setVisibility(View.VISIBLE);
        data.clear();
        ysjlListAdapter.clearView();
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
