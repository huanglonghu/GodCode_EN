package com.example.godcode.ui.fragment.mainActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;

import com.example.godcode.R;
import com.example.godcode.bean.Notices;
import com.example.godcode.databinding.FragmentDiscoveryBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.adapter.DiscoveryListAdapter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.fragment.deatailFragment.NoticeDetailFragment;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryFragment extends BaseFragment {
    private FragmentDiscoveryBinding binding;
    private View view;
    private DiscoveryListAdapter discoveryListAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discovery, container, false);
            view = binding.getRoot();
            initView();
            initListener();
            registerReceiver();
        }
        return view;
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.godcode.service.noticeUpdate");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                data.clear();
                HttpUtil.getInstance().getAllNotice(1, 100).subscribe(
                        noticesStr -> {
                            Notices notices = GsonUtil.getInstance().fromJson(noticesStr, Notices.class);
                            List<Notices.DataBean> data = notices.getData();
                            if (data.size() == 0) {
                                binding.noNews.setVisibility(View.VISIBLE);
                            } else {
                                binding.noNews.setVisibility(View.GONE);
                                DiscoveryFragment.this.data.addAll(data);
                                discoveryListAdapter.notifyDataSetChanged();
                            }

                        }
                );
            }
        };
        activity.registerReceiver(receiver, filter);
    }

    private void initListener() {
        binding.lvDiscovery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int noticeId = data.get(position).getId();
                NoticeDetailFragment noticeDetailFragment = new NoticeDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("noticeId", noticeId);
                noticeDetailFragment.setArguments(bundle);
                presenter.step2Fragment(noticeDetailFragment, "noticeDetail");
            }
        });
    }


    private List<Notices.DataBean> data;

    public void initView() {

    }


    @Override
    protected void lazyLoad() {
        loadData();

    }

    private void loadData() {
        if (data == null) {
            data = new ArrayList<>();
            discoveryListAdapter = new DiscoveryListAdapter(activity, data);
            binding.lvDiscovery.setAdapter(discoveryListAdapter);
            HttpUtil.getInstance().getAllNotice(1, 10).subscribe(
                    noticesStr -> {
                        Notices notices = GsonUtil.getInstance().fromJson(noticesStr, Notices.class);
                        data.addAll(notices.getData());
                        discoveryListAdapter.notifyDataSetChanged();
                    }
            );
        }
    }


}
