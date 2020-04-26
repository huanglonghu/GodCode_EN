package com.example.godcode.ui.fragment.newui.main;

import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godcode.R;
import com.example.godcode.bean.User;
import com.example.godcode.bean.WsHeart;
import com.example.godcode.catche.Loader.RxImageLoader;
import com.example.godcode.databinding.FragmentMineBinding;
import com.example.godcode.greendao.option.LoginResultOption;
import com.example.godcode.greendao.option.UserOption;
import com.example.godcode.greendao.option.VersionMsgOption;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.base.GodCodeApplication;
import com.example.godcode.ui.fragment.newui.PresonalFragment;
import com.example.godcode.ui.fragment.newui.SettingFragment;
import com.example.godcode.ui.fragment.newui.YSJLFragment;
import com.example.godcode.utils.ImagUtil;

public class MineFragment extends BaseFragment {
    private View view;
    private FragmentMineBinding binding;
    private User.ResultBean result;
    private com.example.godcode.greendao.entity.User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initListener();
        }
        initData();
        return view;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initData() {
        user = UserOption.getInstance().querryUser(Constant.userId);
        binding.setUser(user);
        initHead();
    }


    public void initListener() {
        binding.presenal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PresonalFragment presonalFragment = new PresonalFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("mine", result);
                presonalFragment.setArguments(bundle);
                presenter.step2Fragment(presonalFragment, "presonal");
            }
        });

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtil.getInstance().exit(Constant.userId, Constant.uniquenessToken).subscribe(
                        exitStr -> {

                        }
                );
                LoginResultOption.getInstance().exit();
                System.exit(0);
            }
        });


        RxBus.getInstance().toObservable(RxEvent.class).subscribe(
                rxEvent -> {
                    switch (rxEvent.getEventType()) {
                        case EventType.EVENTTYPE_HEART:
                            WsHeart wsHeart = (WsHeart) rxEvent.getBundle().getSerializable("heart");
                            String androidVer = wsHeart.getData().getAndroidVer();
                            try {
                                String versionName = GodCodeApplication.getInstance().getPackageManager().getPackageInfo(GodCodeApplication.getInstance().getPackageName(), 0).versionName;
                                int version1 = Integer.parseInt(versionName.replace(".", ""));
                                int version2 = Integer.parseInt(androidVer.replace(".", ""));
                                if (version2 > version1) {
                                    String androidVerDes = wsHeart.getData().getAndroidVerDes();
                                    VersionMsgOption.getInstance().updateVersion(androidVer, androidVerDes);
                                    MainFragment main = (MainFragment) getParentFragment();
                                    main.getBinding().setUpdate(true);
                                }
                            } catch (PackageManager.NameNotFoundException e1) {
                                e1.printStackTrace();
                            }
                            break;
                    }
                }
        );

        binding.ysfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YSJLFragment ysjlFragment = new YSJLFragment();
                Presenter.getInstance().step2Fragment(ysjlFragment, "ysjl");
            }
        });

        binding.setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingFragment settingFragment = new SettingFragment();
                Presenter.getInstance().step2Fragment(settingFragment, "setting");
            }
        });


    }


    private void initHead() {
        if (user != null) {
            String headImageUrl = user.getHeadImageUrl();
            String url = ImagUtil.handleUrl(headImageUrl);
            if (!TextUtils.isEmpty(url)) {
                RxImageLoader.with(activity).getBitmap(headImageUrl).subscribe(
                        imageBean -> {
                            if (imageBean.getBitmap() != null) {
                                Bitmap bitmap = imageBean.getBitmap();
                                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                                roundedBitmapDrawable.setCircular(true);
                                binding.ivUser.setImageDrawable(roundedBitmapDrawable);
                            }
                        }
                );
            } else {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.contact_normal);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                roundedBitmapDrawable.setCircular(true);
                binding.ivUser.setImageDrawable(roundedBitmapDrawable);
            }
        }
    }


}
