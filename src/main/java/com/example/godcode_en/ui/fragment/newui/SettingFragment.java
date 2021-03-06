package com.example.godcode_en.ui.fragment.newui;

import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode_en.R;
import com.example.godcode_en.databinding.FragmentSettingBinding;
import com.example.godcode_en.greendao.entity.VersionMsg;
import com.example.godcode_en.greendao.option.VersionMsgOption;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.base.BaseFragment;
import com.example.godcode_en.ui.base.GodCodeApplication;
import com.example.godcode_en.ui.fragment.newui.login.ForgotPassword;
import com.example.godcode_en.ui.view.widget.UpdateDialog;

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

            }
        });


        binding.changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotPassword forgotPassword = new ForgotPassword();
                Presenter.getInstance().step2Fragment(forgotPassword,"forgotpwd");
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
