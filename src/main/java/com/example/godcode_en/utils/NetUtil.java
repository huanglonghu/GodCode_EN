package com.example.godcode_en.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.widget.Toast;

import com.example.godcode_en.ui.base.GodCodeApplication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class NetUtil {


    public String getWIFISSID() {
        String ssid = "unknown id";
        if (Build.VERSION.SDK_INT <= 26 || Build.VERSION.SDK_INT == 28) {
            WifiManager mWifiManager = (WifiManager) GodCodeApplication.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            assert mWifiManager != null;
            WifiInfo info = mWifiManager.getConnectionInfo();
            if (Build.VERSION.SDK_INT < 19) {
                return info.getSSID();
            } else {
                return info.getSSID().replace("\"", "");
            }
        } else if (Build.VERSION.SDK_INT == 27) {
            ConnectivityManager connManager = (ConnectivityManager) GodCodeApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            assert connManager != null;
            NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
            if (networkInfo.isConnected()) {
                if (networkInfo.getExtraInfo() != null) {
                    return networkInfo.getExtraInfo().replace("\"", "");
                }
            }
        }
        return ssid;
    }


    public String getIp() {
        WifiManager wifiManager = (WifiManager) GodCodeApplication.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        return intToIp(wifiManager.getConnectionInfo().getIpAddress());
    }

    private String intToIp(int i) {
        return (i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }


    public void airKissConfig(Context context, String ssid, String password) {
        new AirKissTask(context, new AirKissEncoder(ssid, password)).execute();
    }

    private class AirKissTask extends AsyncTask<Void, Void, Void> implements DialogInterface.OnDismissListener {
        private static final int PORT = 10000;
        private final byte DUMMY_DATA[] = new byte[1500];
        private ProgressDialog mDialog;
        private Context mContext;
        private DatagramSocket mSocket;
        private AirKissEncoder mAirKissEncoder;
        private volatile boolean isConfig;

        private volatile boolean mDone = false;

        public AirKissTask(Context context, AirKissEncoder encoder) {
            mContext = context;
            mDialog = new ProgressDialog(mContext);
            mDialog.setCancelable(false);
            mDialog.setOnDismissListener(this);
            mAirKissEncoder = encoder;
        }

        @Override
        protected void onPreExecute() {
            this.mDialog.setMessage("正在配置...");
            mDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "停止", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    isConfig = false;
                }
            });
            this.mDialog.show();
            isConfig = true;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        DatagramSocket ds = new DatagramSocket(10000);
                        ds.setSoTimeout(2000);
                        byte[] b = new byte[1024];
                        DatagramPacket dp = new DatagramPacket(b, b.length);
                        String localIp = getIp();
                        String remoteIp = "";
                        while (isConfig) {
                            if (getStatus() == Status.FINISHED)
                                break;
                            try {
                                ds.receive(dp);
                                remoteIp = dp.getAddress().toString().replace("/", "");
                                if (!remoteIp.equals(localIp)) {
                                    LogUtil.log("==========配置成功========");
                                    if (wifiCOnfigResponse != null) {
                                        wifiCOnfigResponse.suceess(true);
                                    }
                                    mDone = true;
                                    break;
                                }
                            } catch (SocketTimeoutException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        ds.close();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        private void sendPacketAndSleep(int length) {
            try {
                DatagramPacket pkg = new DatagramPacket(DUMMY_DATA,
                        length,
                        InetAddress.getByName("255.255.255.255"),
                        PORT);
                mSocket.send(pkg);
                Thread.sleep(4);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                mSocket = new DatagramSocket();
                mSocket.setBroadcast(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int encoded_data[] = mAirKissEncoder.getEncodedData();
            for (int i = 0; i < encoded_data.length; ++i) {
                sendPacketAndSleep(encoded_data[i]);
                if (i % 200 == 0) {
                    if (isCancelled() || mDone)
                        return null;
                }
            }

            return null;
        }

        @Override
        protected void onCancelled(Void params) {
            Toast.makeText(mContext, "配网取消", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Void params) {
            if (mDialog.isShowing()) {
                mDialog.dismiss();
            }
            String result;
            if (mDone) {
                result = "wifi配置成功";
            } else {
                result = "wifi配置超时";
            }
            isConfig=false;
            Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            if (mDone)
                return;

            this.cancel(true);
        }
    }


    public interface WifiCOnfigResponse {
        void suceess(boolean isSuccess);
    }

    private WifiCOnfigResponse wifiCOnfigResponse;


    public void setWifiCOnfigResponse(WifiCOnfigResponse wifiCOnfigResponse) {
        this.wifiCOnfigResponse = wifiCOnfigResponse;
    }
}
