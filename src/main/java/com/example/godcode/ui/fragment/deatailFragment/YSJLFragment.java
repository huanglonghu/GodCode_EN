package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.example.godcode.R;
import com.example.godcode.bean.YSRecord;
import com.example.godcode.databinding.FragmentYsjlBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.ui.adapter.YsjlListAdapter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.MyListView;
import com.example.godcode.utils.DateUtil;
import com.example.godcode.utils.FormatUtil;
import com.example.godcode.utils.StringUtil;
import com.google.gson.Gson;
import java.util.ArrayList;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_ysjl, null, false);
            binding.setPresenter(presenter);
            binding.lvYsjl.setRefreshData(this);
            binding.setType(type);
            view = binding.getRoot();
            data = new ArrayList<>();
            initView();
            initListener();
            refreshData(1);
        }
        return view;
    }

    private void initView() {
        if (type == 1) {
            binding.ysjlToolbar.title.setText("今日扫码记录");
        } else if (type == 2) {
            binding.ysjlToolbar.title.setText("昨日扫码记录");
        } else if (type == 3) {
            String title = StringUtil.getString(activity, R.string.byys);
            binding.ysjlToolbar.title.setText(title);
        } else if (type == 4) {
            binding.tvDate1.setText(time1);
            binding.tvDate2.setText(time2);
            String title = StringUtil.getString(activity, R.string.totalYs);
            binding.setTitle(title);
        }
        ysjlListAdapter = new YsjlListAdapter(activity, data, R.layout.item_lv_ysjl);
        binding.lvYsjl.setAdapter(ysjlListAdapter);
    }


    private void initListener() {
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
            public void onNext(RxEvent rxEvent){
                //处理事件
                if (rxEvent.getEventType() == EventType.EVENTTYPE_DIVIDE_MSG || rxEvent.getEventType() == EventType.EVENTTYPE_REFRESH_YSJL) {
                    data.clear();
                    ysjlListAdapter.clearView();
                    binding.lvYsjl.setState(2);
                }
            }

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onComplete() {}
        });

    }


    @Override
    protected void lazyLoad() {
    }

    private String time1;
    private String time2;
    private int type;

    public void initData(int type) {
        switch (type) {
            case 1://今日记录
                time1 = DateUtil.getInstance().getToday();
                time2 = time1;
                break;
            case 2://昨日记录
                time1 = DateUtil.getInstance().getYesterDaty();
                time2 = time1;
                break;
            case 3://本月记录
                time1 = DateUtil.getInstance().getMonth();
                time2 = DateUtil.getInstance().getToday();
                break;
            case 4://总记录
                time1 = DateUtil.getInstance().getToday();
                time2 = time1;
                break;
        }
        this.type = type;
    }

    @Override
    public void refreshData(int page) {
        HttpUtil.getInstance().getYSRecord(time1, time2, page).subscribe(
                ysRecordStr -> {
                    YSRecord ysRecord = new Gson().fromJson(ysRecordStr, YSRecord.class);
                    List<YSRecord.ResultBean.DataBean> list = ysRecord.getResult().getData();
                    double allSumMoney = ysRecord.getResult().getAllSumMoney();
                    binding.divideIncomeTotal.setText(FormatUtil.getInstance().get2double(allSumMoney));
                    String incomeSumMoney = FormatUtil.getInstance().get2double(ysRecord.getResult().getIncomeSumMoney());
                    binding.sz.setText(incomeSumMoney);
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
        binding.tvDate1.setText(time1);
        binding.tvDate2.setText(time2);
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
