package com.example.godcode.ui.fragment.dm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.godcode.R;
import com.example.godcode.bean.BatchReturn;
import com.example.godcode.bean.BatchTransfer;
import com.example.godcode.bean.DmGroupMsg;
import com.example.godcode.bean.FrcationOption;
import com.example.godcode.bean.GetFractionRecord;
import com.example.godcode.bean.GroupItemDetail;
import com.example.godcode.bean.PriceScale;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.GroupItemBinding;
import com.example.godcode.databinding.LayoutSearchBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.adapter.GroupItemListAdapter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.fragment.deatailFragment.TransferAccountFragment;
import com.example.godcode.ui.view.MyListView;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GroupItem extends BaseFragment implements MyListView.RefreshData {

    private GroupItemBinding binding;
    private ArrayList<GroupItemDetail.ResultBean.DataBean> datas;
    private GroupItemListAdapter groupItemListAdapter;
    private int groupId;
    private DmGroupMsg.ResultBean.DataBean dataBean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.group_item, container, false);
            binding.setPresenter(presenter);
            binding.lvGroupItem.setRefreshData(this);
            iniView();
            initData();
            initListen();
        }
        return binding.getRoot();
    }

    private int option;
    private int friendId;

    private void initListen() {
        binding.transferMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransferAccountFragment transferAccountFragment = new TransferAccountFragment();
                transferAccountFragment.setType(2);
                presenter.step2Fragment(transferAccountFragment, "transferAccount");
            }
        });

        binding.groupItemTitleBar.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchWindow searchWindow = new SearchWindow(getContext(), new ClickSureListener() {
                    @Override
                    public void click(String str) {
                        productNum = str;
                        datas.clear();
                        groupItemListAdapter.clearView();
                        binding.lvGroupItem.setState(2);
                    }
                });
                searchWindow.showAsDropDown(v, 0, 20);
            }
        });


        binding.returnMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option = 2;
                groupItemListAdapter.batchOprion(2);
            }
        });

        binding.sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> idList = groupItemListAdapter.getIdList();
                if (idList.size() == 0) {
                    ToastUtil.getInstance().showToast("请勾选产品", 1000, getContext());
                    return;
                }
                if (option == 1) {
                    BatchTransfer batchTransfer = new BatchTransfer();
                    batchTransfer.setUserID(groupId);
                    batchTransfer.setToUserID(friendId);
                    batchTransfer.setMcProductIDList(idList);
                    HttpUtil.getInstance().batchTransfer(batchTransfer).subscribe(
                            str -> {
                                ToastUtil.getInstance().showToast("移交成功", 1000, getContext());
                            }
                    );
                } else if (option == 2) {
                    BatchReturn batchReturn = new BatchReturn();
                    batchReturn.setUserID(groupId);
                    batchReturn.setMcProductIDList(idList);
                    HttpUtil.getInstance().batchReturn(batchReturn).subscribe(
                            str -> {
                                ToastUtil.getInstance().showToast("返还成功", 1000, getContext());
                                datas.clear();
                                groupItemListAdapter.clearView();
                                binding.lvGroupItem.setState(2);
                            }
                    );
                }

            }
        });


        binding.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                McDetail mcDetail = new McDetail();
                Bundle bundle = new Bundle();
                bundle.putInt("userId", dataBean.getFK_UserID());
                mcDetail.setArguments(bundle);
                Presenter.getInstance().step2Fragment(mcDetail, "mcDetail");
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
                    requetRecord();
                } else if (rxEvent.getEventType() == EventType.EVENTTYPE_REFRESH_SCORE) {
                    //刷新积分
                    requestFrcation();
                } else if (rxEvent.getEventType() == EventType.EVENTTYPE_SELECT_FRIEND) {
                    option = 1;
                    friendId = rxEvent.getId();
                    groupItemListAdapter.batchOprion(option);
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });


        binding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrcationOption frcationOption = new FrcationOption();
                frcationOption.setChangeFraction((int) binding.getApplyBean().getFraction());
                frcationOption.setIsConcur(true);
                frcationOption.setUserID(Constant.userId);
                frcationOption.setMcFractionRecordID(binding.getApplyBean().getId());
                HttpUtil.getInstance().frcationOption(frcationOption).subscribe(
                        str -> {
                            dataBean.setOverMCFration(dataBean.getOverMCFration() + binding.getApplyBean().getFraction());
                            binding.setDataBean(dataBean);
                            binding.setApplyBean(null);
                        }
                );
            }
        });
        binding.refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrcationOption frcationOption = new FrcationOption();
                frcationOption.setChangeFraction((int) binding.getApplyBean().getFraction());
                frcationOption.setIsConcur(false);
                frcationOption.setUserID(Constant.userId);
                frcationOption.setMcFractionRecordID(binding.getApplyBean().getId());
                HttpUtil.getInstance().frcationOption(frcationOption).subscribe(
                        str -> {
                            binding.setApplyBean(null);
                        }
                );
            }
        });

        binding.confirmReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrcationOption frcationOption = new FrcationOption();
                frcationOption.setIsConcur(true);
                frcationOption.setUserID(Constant.userId);
                frcationOption.setMcFractionRecordID(binding.getReturnBean().getId());
                HttpUtil.getInstance().frcationOption(frcationOption).subscribe(
                        str -> {
                            datas.clear();
                            dataBean.setOverMCFration(dataBean.getOverMCFration() - binding.getReturnBean().getFraction());
                            binding.setDataBean(dataBean);
                            binding.setReturnBean(null);
                        }
                );
            }
        });

        binding.refuseReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrcationOption frcationOption = new FrcationOption();
                frcationOption.setIsConcur(false);
                frcationOption.setUserID(Constant.userId);
                frcationOption.setMcFractionRecordID(binding.getReturnBean().getId());
                HttpUtil.getInstance().frcationOption(frcationOption).subscribe(
                        str -> {
                            binding.setReturnBean(null);
                        }
                );
            }
        });

    }


    private void requestFrcation() {
        HttpUtil.getInstance().getDmMsg(groupId).subscribe(
                str -> {
                    DmGroupMsg dmGroupMsg = GsonUtil.fromJson(str, DmGroupMsg.class);
                    DmGroupMsg.ResultBean result = dmGroupMsg.getResult();
                    if (result != null) {
                        double mcFraction = result.getMcFraction();
                        binding.score.setText(mcFraction + "");
                    }
                }
        );
    }

    private void requetRecord() {
        HttpUtil.getInstance().getFractionRecord().subscribe(
                str -> {
                    GetFractionRecord getFractionRecord = GsonUtil.fromJson(str, GetFractionRecord.class);
                    List<GetFractionRecord.ResultBean> result = getFractionRecord.getResult();
                    if (result != null && result.size() > 0) {
                        for (int i = 0; i < result.size(); i++) {
                            GetFractionRecord.ResultBean resultBean = result.get(i);
                            if (resultBean.getFK_UserID() == groupId) {
                                if (resultBean.getType() == 1) {
                                    binding.setApplyBean(resultBean);
                                } else if (resultBean.getType() == 2) {
                                    binding.setReturnBean(resultBean);
                                }
                            }
                        }
                    }
                }
        );
    }


    private void iniView() {
        Bundle bundle = getArguments();
        dataBean = (DmGroupMsg.ResultBean.DataBean) bundle.getSerializable("groupMsg");
        binding.setDataBean(dataBean);
        groupId = dataBean.getFK_UserID();
        datas = new ArrayList<>();
        groupItemListAdapter = new GroupItemListAdapter(getContext(), datas, R.layout.groupitem_item, groupId);
        binding.lvGroupItem.setAdapter(groupItemListAdapter);
        if (Constant.userId == groupId) {
            binding.setOption(true);
        } else {
            binding.setOption(false);
        }
    }

    private void initData() {
        refreshData(1);
        requetRecord();
    }


    @Override
    protected void lazyLoad() {

    }

    private String productNum;

    @Override
    public void refreshData(int page) {
        HttpUtil.getInstance().getDmMsgDetail(Constant.userId, groupId, page, productNum).subscribe(
                str -> {
                    GroupItemDetail groupItemDetail = GsonUtil.fromJson(str, GroupItemDetail.class);
                    GroupItemDetail.ResultBean result = groupItemDetail.getResult();
                    if (result != null) {
                        binding.count.setText(result.getCount() + "");
                        List<GroupItemDetail.ResultBean.DataBean> data = result.getData();
                        if (data != null && data.size() > 0) {
                            binding.lvGroupItem.setState(0);
                            datas.addAll(data);
                            groupItemListAdapter.notifyDataSetChanged();
                        } else {
                            binding.lvGroupItem.setState(1);
                            if (!TextUtils.isEmpty(productNum)) {
                                ToastUtil.getInstance().showToast("未搜索到相关内容", 1000, getContext());
                            }
                        }
                    }
                }
        );
    }

    private class SearchWindow extends PopupWindow {

        public SearchWindow(Context context, ClickSureListener clickSureListener) {
            setWidth(WindowManager.LayoutParams.MATCH_PARENT);
            setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            setFocusable(true);
            setOutsideTouchable(true);
            LayoutSearchBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_search, null, false);
            setContentView(binding.getRoot());
            binding.search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String searchStr = binding.searchEt.getText().toString();
                    if (TextUtils.isEmpty(searchStr)) {
                        ToastUtil.getInstance().showToast("请输入搜索内容", 1000, context);
                        return;
                    }
                    clickSureListener.click(searchStr);
                }
            });

        }


    }

}
