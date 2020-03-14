package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.TxSyBody;
import com.example.godcode.bean.TxsyResponse;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.FragmentTxsyBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.adapter.TxsyListAdapter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.MyListView;
import com.example.godcode.utils.DateUtil;
import com.example.godcode.utils.FormatUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TxSy extends BaseFragment implements SelectTimeFragment.TimeSelect, MyListView.RefreshData {

    private FragmentTxsyBinding binding;
    private String time1;
    private String time2;
    private TxsyListAdapter txsyListAdapter;
    private ArrayList<TxsyResponse.ResultBean.DataBean> datas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_txsy, container, false);
            binding.setPresenter(Presenter.getInstance());
            binding.lvTxsy.setRefreshData(this);
            initView();
            initData();
            initListen();
        }
        return binding.getRoot();
    }

    private void initView() {
        datas = new ArrayList<>();
        txsyListAdapter = new TxsyListAdapter(getContext(), datas, R.layout.item_lv_txsy);
        binding.lvTxsy.setAdapter(txsyListAdapter);
    }

    private void initListen() {
        binding.calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeFragment selectTimeFragment = new SelectTimeFragment();
                selectTimeFragment.setTimeSelect(TxSy.this);
                presenter.step2Fragment(selectTimeFragment, "selectTime");
            }
        });
    }

    private void initData() {
        time1 = DateUtil.getInstance().getToday();
        time2 = time1;
        binding.tvDate1.setText(time1);
        binding.tvDate2.setText(time2);
        refreshData(1);
    }

    @Override
    public void refreshData(int page) {
        TxSyBody txSyBody = new TxSyBody();
        txSyBody.setStratTime(time1);
        txSyBody.setEndTime(time2);
        txSyBody.setLimit(20);
        txSyBody.setPage(page);
        txSyBody.setUserID(Constant.userId);
        HttpUtil.getInstance().querryTxSy(txSyBody).subscribe(
                str -> {
                    TxsyResponse txsyResponse = new Gson().fromJson(str, TxsyResponse.class);
                    TxsyResponse.ResultBean result = txsyResponse.getResult();
                    if (result != null) {
                        double allSumMoney = result.getIncomeSumMoney();
                        List<TxsyResponse.ResultBean.DataBean> list = result.getData();
                        String incomeSumMoney = FormatUtil.getInstance().get2double(allSumMoney);
                        binding.sz.setText("收入¥  " + incomeSumMoney);
                        if (list != null && list.size() > 0) {
                            datas.addAll(list);
                            txsyListAdapter.notifyDataSetChanged();
                            binding.lvTxsy.setState(0);
                        } else {
                            binding.lvTxsy.setState(1);
                        }
                    }


                }
        );
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void setDate(String date1, String date2) {
        this.time1 = date1;
        this.time2 = date2;
        binding.tvDate1.setText(time1);
        binding.tvDate2.setText(time2);
        datas.clear();
        txsyListAdapter.clearView();
        binding.lvTxsy.setState(2);
    }


}
