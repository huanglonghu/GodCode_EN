package com.example.godcode_en.ui.fragment.newui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.godcode_en.R;
import com.example.godcode_en.bean.YSRecord;
import com.example.godcode_en.databinding.FragmentYsjlDetailBinding;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.utils.DateUtil;
import com.example.godcode_en.utils.FormatUtil;

public class YSJLDetailFragment extends BaseFragment {
    private FragmentYsjlDetailBinding binding;
    private View view;
    private YSRecord.ResultBean.DataBean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ysjl_detail, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initData();
            initView();
            initListener();
        }
        return view;
    }


    public void initListener() {

    }


    public void initData() {
        bean = (YSRecord.ResultBean.DataBean) getArguments().getSerializable("ysjlItem");
        binding.setBean(bean);
        binding.orderMoney.setText(FormatUtil.getInstance().get2double(bean.getSumOrder()));
        binding.divideMoney.setText(FormatUtil.getInstance().get2double(bean.getDivideMoney()));
        String time = DateUtil.getInstance().formatDate(bean.getOrderDate());
        binding.ysjlDetailDate.setText(time);
    }


    public void initView() {
        if (!bean.isIsCapableRefund() || bean.isIsRefund() || !Constant.syNum.equals(bean.getProductOwnerName())) {
            binding.tk.setVisibility(View.GONE);
        }
    }


    @Override
    public void onKeyDown() {
        presenter.back();

    }


}
