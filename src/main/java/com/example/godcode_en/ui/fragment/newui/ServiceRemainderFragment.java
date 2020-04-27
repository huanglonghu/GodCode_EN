package com.example.godcode_en.ui.fragment.newui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.example.godcode_en.R;
import com.example.godcode_en.databinding.FragmentServicereaminderBinding;
import com.example.godcode_en.greendao.entity.Notification;
import com.example.godcode_en.greendao.option.NotificationOption;
import com.example.godcode_en.ui.fragment.newui.adapter.ServiceRemainderListAdapter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.constant.Constant;
import java.util.Collections;
import java.util.List;

public class ServiceRemainderFragment extends BaseFragment {
    private FragmentServicereaminderBinding binding;
    private View view;
    private List<Notification> notifications;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_servicereaminder, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initListener();
        }
        initView();
        return binding.getRoot();
    }

    public void initListener() {
        binding.lvServiceRemainder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Notification notification = notifications.get(position);
                int type = notification.getType();
                switch (type){
                    case 2:
                        presenter.step2Fragment("bankCard");
                        break;
                    case 3:

                        break;
                    case 4:
                        presenter.step2Fragment("myAsset");
                        break;

                }

            }
        });
    }

    public void initView() {
        notifications = NotificationOption.getInstance().getAllNotification(Constant.userId);
        Collections.reverse(notifications);
        ServiceRemainderListAdapter adapter = new ServiceRemainderListAdapter(notifications, activity);
        binding.lvServiceRemainder.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }

}
