package com.example.godcode.ui.fragment.dm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.godcode.R;
import com.example.godcode.bean.DmGroupMsg;
import com.example.godcode.bean.GetFractionRecord;
import com.example.godcode.bean.PriceScale;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.MyscoreBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.adapter.MyScoreListAdapter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.GsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyScore extends BaseFragment {

    private MyscoreBinding binding;
    private ArrayList<DmGroupMsg.ResultBean.DataBean> datas;
    private MyScoreListAdapter myScoreListAdapter;
    private DmGroupMsg.ResultBean result;


    @Override
    protected void lazyLoad() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.myscore, container, false);
        binding.setPresenter(presenter);
        iniView();
        initData();
        getFrcation();
        initListener();
        return binding.getRoot();
    }

    private void initData() {
        HttpUtil.getInstance().getDmMsg(Constant.userId).subscribe(
                str -> {
                    DmGroupMsg dmGroupMsg = GsonUtil.fromJson(str, DmGroupMsg.class);
                    result = dmGroupMsg.getResult();
                    if (result != null) {
                        binding.setBean(result);
                        HashMap<String, DmGroupMsg.ResultBean.DataBean> data = result.getData();
                        if (data != null) {
                            if (data.size() > 0) {
                                for (String s : data.keySet()) {
                                    DmGroupMsg.ResultBean.DataBean dataBean = data.get(s);
                                    datas.add(dataBean);
                                }
                                myScoreListAdapter.notifyDataSetChanged();
                                requestRecord();
                            }
                        }
                    }
                }
        );

    }


    private void getFrcation() {
        HttpUtil.getInstance().getPriceScale(Constant.userId).subscribe(
                str -> {
                    PriceScale priceScale = GsonUtil.fromJson(str, PriceScale.class);
                    PriceScale.ResultBean result = priceScale.getResult();
                    if (result != null) {

                    }

                }
        );
    }

    private void initListener() {
        binding.unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnLock unLock = new UnLock();
                Bundle bundle = new Bundle();
                bundle.putInt("score", result.getMcFraction());
                unLock.setArguments(bundle);
                Presenter.getInstance().step2Fragment(unLock, "unlock");
            }
        });


        binding.backScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackScore backScore = new BackScore();
                Bundle bundle = new Bundle();
                bundle.putInt("jf", result.getMcFraction());
                backScore.setArguments(bundle);
                Presenter.getInstance().step2Fragment(backScore, "backScore");
            }
        });

        binding.getScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.getBean().isGeneralAgent()) {
                    GetScore getScore = new GetScore();
                    Bundle bundle = new Bundle();
                    bundle.putInt("jf", result.getMcFraction());
                    getScore.setArguments(bundle);
                    Presenter.getInstance().step2Fragment(getScore, "getScore");
                } else {
                    ApplyScore applyScore = new ApplyScore();
                    Bundle bundle = new Bundle();
                    bundle.putInt("jf", result.getMcFraction());
                    applyScore.setArguments(bundle);
                    Presenter.getInstance().step2Fragment(applyScore, "applyScore");
                }
            }
        });


        binding.lvScore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroupItem groupItem = new GroupItem();
                Bundle bundle = new Bundle();
                bundle.putSerializable("groupMsg", datas.get(position));
                groupItem.setArguments(bundle);
                Presenter.getInstance().step2Fragment(groupItem, "groupItem");
            }
        });

        binding.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreOptionDetail scoreOptionDetail = new ScoreOptionDetail();
                Presenter.getInstance().step2Fragment(scoreOptionDetail, "scoreOptionDetail");
            }
        });


        RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(RxEvent rxEvent) {
                //收到积分申请通知
                if (rxEvent.getEventType() == EventType.EVENTTYPE_APPLAY_SCORE) {
                    requestRecord();
                } else if (rxEvent.getEventType() == EventType.EVENTTYPE_REFRESH_SCORE) {
                    initData();
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

    private void requestRecord() {
        HttpUtil.getInstance().getFractionRecord().subscribe(
                str -> {
                    GetFractionRecord getFractionRecord = GsonUtil.fromJson(str, GetFractionRecord.class);
                    List<GetFractionRecord.ResultBean> result = getFractionRecord.getResult();
                    if (result != null && result.size() > 0) {
                        for (int i = 0; i < result.size(); i++) {
                            GetFractionRecord.ResultBean resultBean = result.get(i);
                            int fk_userID = resultBean.getFK_UserID();
                            myScoreListAdapter.notifyItem(fk_userID);
                        }


                    }
                }
        );
    }

    private void iniView() {
        datas = new ArrayList<>();
        myScoreListAdapter = new MyScoreListAdapter(getContext(), datas, R.layout.item_myscore);
        binding.lvScore.setAdapter(myScoreListAdapter);
    }


}
