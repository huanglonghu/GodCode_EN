package com.example.godcode.ui.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.bean.RefreshDiviceToken;
import com.example.godcode.bean.WsHeart;
import com.example.godcode.databinding.ActivityMainBinding;
import com.example.godcode.greendao.option.FriendOption;
import com.example.godcode.greendao.option.VersionMsgOption;
import com.example.godcode.handler.ActivityResultHandler;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.service.WebSocketService;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.fragment.auth.SelectAuthWay;
import com.example.godcode.ui.fragment.bindproduct.BindProductFragment;
import com.example.godcode.ui.fragment.deatailFragment.AddBankCardFragment;
import com.example.godcode.ui.fragment.deatailFragment.MobileRechargeFragment;
import com.example.godcode.ui.fragment.deatailFragment.OrderDetailFragment;
import com.example.godcode.ui.fragment.deatailFragment.PaySuccessFragment;
import com.example.godcode.ui.fragment.deatailFragment.PresonalFragment;
import com.example.godcode.ui.fragment.deatailFragment.RechargeFragment;
import com.example.godcode.ui.fragment.deatailFragment.TransationRecordDetailFragment;
import com.example.godcode.ui.fragment.deatailFragment.TransferAccountDetailFragment;
import com.example.godcode.ui.fragment.deatailFragment.TxFragment;
import com.example.godcode.ui.fragment.deatailFragment.YSJLDetailFragment;
import com.example.godcode.ui.fragment.mainActivity.HomeFragment;
import com.example.godcode.ui.fragment.mainActivity.MainFragment;
import com.example.godcode.ui.fragment.pwd.ResetPwd;
import com.example.godcode.ui.view.PsdPopupWindow;
import com.example.godcode.ui.view.UpdateDialog;
import com.example.godcode.utils.PayPwdSetting;
import com.example.godcode.utils.SharepreferenceUtil;
import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private FragmentManager supportFragmentManager;
    private WebSocketService.MyBinder myBinder;
    private DeviceTokenReceiver deviceTokenReceiver;

    @Override
    public void init() {
        HttpUtil.getInstance().init(this);
        changeAppLanguage();
        PayPwdSetting.getInstance().initContext(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainFragment mainFragment = new MainFragment();
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.addOnBackStackChangedListener(getListener());
        Presenter.getInstance().initFragmentManager(this, supportFragmentManager, 1);
        supportFragmentManager.beginTransaction().replace(R.id.mainActivity_fragmentContainer, mainFragment).addToBackStack("main").commit();
        //开启websocket服务
        Intent intent = new Intent(this, WebSocketService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        if (deviceTokenReceiver == null) {
            deviceTokenReceiver = new DeviceTokenReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("refreshDeviceToken");
            registerReceiver(deviceTokenReceiver, intentFilter);
        }
        RxBus.getInstance().toObservable(RxEvent.class).subscribe(new Observer<RxEvent>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(RxEvent rxEvent) {

                switch (rxEvent.getEventType()) {
                    case EventType.EVENTTYPE_ADDFRIEND_SUCCESS:
                        Flowable.intervalRange(0, 2, 0, 500, TimeUnit.MILLISECONDS)
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnComplete(new Action() {
                                    @Override
                                    public void run() throws Exception {
                                        FriendOption.getInstance(MainActivity.this).querryFriendList(1, true);
                                    }
                                })
                                .subscribe();

                        break;
                    case EventType.EVENTTYPE_EXIT:
                        Presenter.getInstance().exit(MainActivity.this);
                        break;
                    case EventType.EVENTTYPE_DELETE_FRIEND:
                        FriendOption.getInstance(MainActivity.this).deleteFriend(rxEvent.getId());
                        break;
                    case EventType.EVENTTYPE_ADDFRIEND:
                        Presenter.getInstance().showNew(1);
                        break;
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


    private FragmentManager.OnBackStackChangedListener getListener() {
        FragmentManager.OnBackStackChangedListener result = new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                FragmentManager manager = getSupportFragmentManager();
                if (manager != null) {
                    BaseFragment currFrag = (BaseFragment) manager.findFragmentById(R.id.mainActivity_fragmentContainer);
                    if (currFrag instanceof MainFragment) {
                        MainFragment mainFragment = (MainFragment) currFrag;
                        int position = mainFragment.getBinding().getPosition();
                        if (position == 0) {
                            HomeFragment homeFragment = (HomeFragment) Presenter.getInstance().getFragments().get(0);
                            homeFragment.refreshDivideIncome();
                        }

                    }
                }
            }
        };

        return result;
    }

    private void createUpdateDialog(WsHeart wsHeart) {
        wsHeart.getData().getAndroidVerDes();
        String androidVerDes = wsHeart.getData().getAndroidVerDes();
        String androidVer = wsHeart.getData().getAndroidVer();
        VersionMsgOption.getInstance().updateVersion(androidVer, androidVerDes);
        UpdateDialog updateDialog = new UpdateDialog(this);
        updateDialog.show();
        String updateAddress = wsHeart.getData().getUpdateAddress();
        SharepreferenceUtil.getInstance().setUpdateAddress(updateAddress);
        updateDialog.setDescibe(androidVerDes, androidVer);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (myBinder == null) {
                myBinder = (WebSocketService.MyBinder) service;
            }
            myBinder.connectWebSocket(MainActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        BaseFragment fragment = (BaseFragment) supportFragmentManager.findFragmentById(R.id.mainActivity_fragmentContainer);
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (fragment instanceof MainFragment) {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
                return true;
            } else if (fragment instanceof RechargeFragment || fragment instanceof AddBankCardFragment
                    || fragment instanceof TxFragment || fragment instanceof TransferAccountDetailFragment
                    || fragment instanceof OrderDetailFragment || fragment instanceof YSJLDetailFragment
                    || fragment instanceof PresonalFragment || fragment instanceof OrderDetailFragment
                    || fragment instanceof PaySuccessFragment || fragment instanceof MobileRechargeFragment
                    || fragment instanceof BindProductFragment || fragment instanceof SelectAuthWay || fragment instanceof ResetPwd) {
                fragment.onKeyDown();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        new ActivityResultHandler.Builder().build2(this);
        ActivityResultHandler.getInstance().handler(requestCode, resultCode, data);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (PsdPopupWindow.getInstance(this) != null && PsdPopupWindow.getInstance(this).isShowing()) {
            return false;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int message = intent.getIntExtra("message", 0);
        switch (message) {
            case 0:
//                Presenter.getInstance().togglePager(2);
//                Bundle bundle0 = intent.getExtras();
//                String noticeId = bundle0.getString("noticeId");
//                NoticeDetailFragment noticeDetailFragment = new NoticeDetailFragment();
//                bundle0.putInt("noticeId", Integer.parseInt(noticeId));
//                noticeDetailFragment.setArguments(bundle0);
//                Presenter.getInstance().step2Fragment(noticeDetailFragment, "noticeDetail");
                break;
            case 1:
                step2transtaion(intent);
                break;
            case 2:
                Presenter.getInstance().step2Fragment("newFriend");
                break;
            case 3:
                Toast.makeText(this, "Your account is logged on other devices, please pay attention to account security", Toast.LENGTH_SHORT).show();
                break;
            case 4:
//                ContactDetailFragment cdf = new ContactDetailFragment();
//                //cdf.initData(friend);
//                Presenter.getInstance().step2Fragment(cdf, "cdf");
                break;
            case 5:
                step2transtaion(intent);
                break;
            case 6:
                step2transtaion(intent);
                break;
            case 7:
                step2transtaion(intent);
                break;
        }
    }

    private void step2transtaion(Intent intent) {
        TransationRecordDetailFragment trdf1 = new TransationRecordDetailFragment();
        Bundle extras1 = intent.getExtras();
        trdf1.setArguments(extras1);
        Presenter.getInstance().step2Fragment(trdf1, "transationDetail");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (deviceTokenReceiver != null) {
            unregisterReceiver(deviceTokenReceiver);
        }
    }

    class DeviceTokenReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("refreshDeviceToken")) {
                RefreshDiviceToken refreshDiviceToken = new RefreshDiviceToken();
                refreshDiviceToken.setDeviceToken(Constant.diviceToken);
                refreshDiviceToken.setUserID(Constant.userId);
                HttpUtil.getInstance().refreshDiviceToken(refreshDiviceToken).subscribe();
            }
        }
    }
}
