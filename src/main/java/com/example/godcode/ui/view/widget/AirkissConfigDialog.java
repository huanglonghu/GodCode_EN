package com.example.godcode.ui.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.databinding.LayoutAirkissConfigBinding;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.GodCodeApplication;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.NetUtil;


public class AirkissConfigDialog extends Dialog implements NetUtil.WifiCOnfigResponse{
    private Context context;
    private LayoutAirkissConfigBinding binding;

    public AirkissConfigDialog(Context context) {
        super(context);
        this.context = context;
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
    }


    public void show() {
        super.show();
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_airkiss_config, null, false);
        NetUtil netUtil = new NetUtil();
        netUtil.setWifiCOnfigResponse(this);
        ConnectivityManager connManager = (ConnectivityManager) GodCodeApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        String wifiSsid = netUtil.getWIFISSID();
        binding.cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        binding.sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String psd = binding.wifiPsw.getText().toString();
                if (!networkInfo.isConnected()) {
                    Toast.makeText(context, "Please connect wifi first", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(psd)) {
                    Toast.makeText(context, "Please enter wifi password", Toast.LENGTH_SHORT).show();
                    return;
                }
                netUtil.airKissConfig(context, wifiSsid, psd);
            }
        });
        binding.wifiName.setText(wifiSsid);
        setContentView(binding.getRoot());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = Presenter.getInstance().getWindowWidth() * 8 / 10;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.6f;
        getWindow().setAttributes(layoutParams);
    }


    @Override
    public void suceess(boolean isSuccess) {
        dismiss();
    }
}
