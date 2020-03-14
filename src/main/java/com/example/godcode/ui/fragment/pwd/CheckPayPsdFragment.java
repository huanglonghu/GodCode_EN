package com.example.godcode.ui.fragment.pwd;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.godcode.R;
import com.example.godcode.bean.CheckPsd;
import com.example.godcode.databinding.FragmentCheckpaypsdBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.constant.Constant;
import com.example.godcode.ui.view.KeyBoard;
import com.example.godcode.utils.LogUtil;

public class CheckPayPsdFragment extends BaseFragment {
    private FragmentCheckpaypsdBinding binding;
    private View view;
    private KeyBoard keyBoard;
    private int eventType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_checkpaypsd, container, false);
        binding.setPresenter(presenter);
        view = binding.getRoot();
        eventType = getArguments().getInt("eventType");
        initView();
        initListener();
        return view;
    }

    private void initListener() {

        binding.checkPsdPsdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!keyBoard.isShowing()) {
                    keyBoard.show(view);
                }
            }
        });
    }

    public void initView() {
        keyBoard = new KeyBoard(activity, new ClickSureListener() {
            @SuppressLint("CheckResult")
            @Override
            public void checkPwd(String pwd) {
                CheckPsd checkPsd = new CheckPsd();
                checkPsd.setFK_UserID(Constant.userId);
                checkPsd.setPayPass(pwd);
                HttpUtil.getInstance().checkPsyPsd(checkPsd).subscribe(
                        back -> {
                            if (back.contains("\"success\":false")) {
                                keyBoard.clearPsd();
                                binding.checkPsdPsdView.setPsLength(0);
                                Toast.makeText(activity, "The password was entered incorrectly, please re-enter it", Toast.LENGTH_SHORT).show();
                            } else {
                                LogUtil.log("===============EventType============"+eventType);
                                presenter.back();
                                RxEvent rxEvent = new RxEvent(eventType);
                                Bundle bundle = new Bundle();
                                bundle.putString("OriginalPayPass",pwd);
                                rxEvent.setBundle(bundle);
                                RxBus.getInstance().post(rxEvent);
                            }
                        }
                );
            }
        });
        keyBoard.setRefreshPsd(binding.checkPsdPsdView);
        keyBoard.show(view);
    }

    @Override
    protected void lazyLoad() {
    }

    @Override
    public void onStop() {
        super.onStop();
        if (keyBoard != null) {
            keyBoard.dismiss();
        }
    }
}
