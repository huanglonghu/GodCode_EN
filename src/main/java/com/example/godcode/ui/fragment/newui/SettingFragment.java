package com.example.godcode.ui.fragment.newui;

import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.databinding.FragmentSettingBinding;
import com.example.godcode.greendao.entity.VersionMsg;
import com.example.godcode.greendao.option.VersionMsgOption;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.base.GodCodeApplication;
import com.example.godcode.ui.view.widget.UpdateDialog;
import com.example.godcode.ui.view.widget.LanguageConfigDialog;

public class SettingFragment extends BaseFragment {
    private FragmentSettingBinding binding;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);
            binding.setPresenter(presenter);
            view = binding.getRoot();
            initView();
            initListener();
        }
        return view;
    }


    public void initListener() {

        binding.changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VersionMsg versionMsg = VersionMsgOption.getInstance().querryVersion();
                if (versionMsg != null) {
                    String versionCode = versionMsg.getVersionCode();
                    String versionDes = versionMsg.getVersionDes();
                    createUpdateDialog(versionDes, versionCode);
                } else {
                    Toast.makeText(activity, "The current version is the latest", Toast.LENGTH_SHORT).show();
                }
            }
        });


        binding.language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageConfigDialog languageConfigDialog = new LanguageConfigDialog(activity);
                languageConfigDialog.show();
            }
        });

    }

    private void createUpdateDialog(String des, String versionCode) {
        UpdateDialog updateDialog = new UpdateDialog(activity);
        updateDialog.show();
        updateDialog.setDescibe(des, versionCode);
    }

    public void initView() {
        try {
            String versionName = activity.getPackageManager().getPackageInfo(GodCodeApplication.getInstance().getPackageName(), 0).versionName;
            binding.versionCode.setText(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {

    }


}
