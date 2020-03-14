package com.example.godcode.ui.fragment.dm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.godcode.R;
import com.example.godcode.bean.UnLockMc;
import com.example.godcode.bean.UnLockMcResponse;
import com.example.godcode.databinding.ParameterchangeBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.ClickSureListener;
import com.example.godcode.observable.EventType;
import com.example.godcode.observable.RxBus;
import com.example.godcode.observable.RxEvent;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.GsonUtil;
import com.example.godcode.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class ParameterChange extends BaseFragment {

    private ParameterchangeBinding binding;
    private String[] array1;
    private String[] array2;
    private String[] array3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.parameterchange, container, false);
        binding.setPresenter(Presenter.getInstance());
        binding.setScore(score);
        binding.productNum.setText("机台号:" + unLockMc.getMcProductNumber());
        initlisten();
        return binding.getRoot();
    }

    private int runTime = -1;
    private int gameGrade = -1;
    private int currencyValue = -1;

    private void initlisten() {
        array1 = new String[]{"1天", "7天", "10天", "15天", "30天", "60天", "永久"};
        array2 = new String[]{"99", "98", "97", "96", "95", "94", "93", "92", "91", "90"};
        array3 = new String[]{"一币1分", "一币2分", "一币5分", "一币10分", "一币20分", "一币50分", "一币100分",
                "一币200分", "一币500分", "一币1000分", "一币2000分", "一币5000分",
                "一币10000分", "一币20000分", "一币50000分"};
        binding.runTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectWindow timeSelectWindow = new TimeSelectWindow();
                timeSelectWindow.show(getContext(), array1, new ClickSureListener() {
                    @Override
                    public void click(int position) {
                        binding.runTime.setText(array1[position]);
                        if (position == array1.length - 1) {
                            unLockMc.setIsUnlock("1");
                            unLockMc.setRunTime("-1");
                        } else {
                            runTime = position;
                            unLockMc.setRunTime(runTime + "");
                            unLockMc.setIsUnlock("0");
                        }
                    }
                }, v);
            }
        });

        binding.jltz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectWindow timeSelectWindow = new TimeSelectWindow();
                timeSelectWindow.show(getContext(), array2, new ClickSureListener() {
                    @Override
                    public void click(int position) {
                        binding.jltz.setText(array2[position]);
                        gameGrade = position;
                        unLockMc.setGameGrade(gameGrade + "");
                    }
                }, v);
            }
        });

        binding.ybfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeSelectWindow timeSelectWindow = new TimeSelectWindow();
                timeSelectWindow.show(getContext(), array3, new ClickSureListener() {
                    @Override
                    public void click(int position) {
                        binding.ybfs.setText(array3[position]);
                        currencyValue = position;
                        unLockMc.setCurrencyValue(currencyValue + "");
                    }
                }, v);
            }
        });

        binding.look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtil.getInstance().look(unLockMc.getMcProductNumber(), unLockMc.getCurrentProfit(), unLockMc.getVerifyCode()).subscribe(
                        str -> {
                            if (str.contains("\"success\":true")) {
                                JSONObject jsonObject = new JSONObject(str);
                                String result = jsonObject.getString("result");
                                if (!TextUtils.isEmpty(result)) {
                                    String[] split = result.split("\\|");
                                    gameGrade = Integer.parseInt(split[0]);
                                    if (!TextUtils.isEmpty(array2[gameGrade])) {
                                        binding.jltz.setText(array2[gameGrade]);
                                    }
                                    runTime = Integer.parseInt(split[1]);
                                    if (!TextUtils.isEmpty(array1[runTime])) {
                                        binding.runTime.setText(array1[runTime]);
                                    }
                                    currencyValue = Integer.parseInt(split[2]);
                                    if (!TextUtils.isEmpty(array3[currencyValue])) {
                                        binding.ybfs.setText(array3[currencyValue]);
                                    }

                                }
                            } else {
                                try {
                                    JSONObject jb = new JSONObject(str);
                                    JSONObject error = jb.getJSONObject("error");
                                    String message = error.getString("message");
                                    ToastUtil.getInstance().showToast(message, 1000, getContext());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                );
            }
        });

        binding.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String runTime = unLockMc.getRunTime();
                if(TextUtils.isEmpty(runTime)){
                    unLockMc.setRunTime("0");
                }
                String gameGrade = unLockMc.getGameGrade();
                if(TextUtils.isEmpty(gameGrade)){
                    unLockMc.setCurrencyValue("0");
                }
                String currencyValue = unLockMc.getCurrencyValue();
                if(TextUtils.isEmpty(currencyValue)){
                    unLockMc.setCurrencyValue("0");
                }
                HttpUtil.getInstance().unLockMc(unLockMc).subscribe(
                        str -> {
                            if (str.contains("success\":true")) {
                                ToastUtil.getInstance().showToast("打码成功", 1000, getContext());
                                UnLockMcResponse unLockMcResponse = GsonUtil.fromJson(str, UnLockMcResponse.class);
                                UnLockMcResponse.ResultBean result = unLockMcResponse.getResult();
                                score = score - Integer.parseInt(unLockMc.getCurrentProfit());
                                binding.setScore(score);
                                if (result != null) {
                                    String password = result.getPassword();
                                    RxEvent rxEvent = new RxEvent(EventType.EVENTTYPE_DM_SUCCESSED);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("psw",password);
                                    rxEvent.setBundle(bundle);
                                    RxBus.getInstance().post(rxEvent);
                                    Presenter.getInstance().back();
                                }
                            } else {
                                try {
                                    JSONObject jb = new JSONObject(str);
                                    JSONObject error = jb.getJSONObject("error");
                                    String message = error.getString("message");
                                    ToastUtil.getInstance().showToast(message, 1000, getContext());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                );
            }
        });

    }

    @Override
    protected void lazyLoad() {

    }


    private UnLockMc unLockMc;
    private Integer score;

    public void setData(UnLockMc unLockMc, Integer socre) {
        this.unLockMc = unLockMc;
        this.score = socre;
    }


    private class TimeSelectWindow extends PopupWindow {

        public TimeSelectWindow() {
            setFocusable(true);
            setOutsideTouchable(true);
        }

        public void show(Context context, String[] timeArray, ClickSureListener clickSureListener, View view) {
            ListView listView = new ListView(context);
            listView.setBackgroundColor(Color.WHITE);
            AbsListView.LayoutParams layoutParams = new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
            listView.setLayoutParams(layoutParams);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, timeArray);
            listView.setAdapter(adapter);
            setContentView(listView);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    clickSureListener.click(position);
                    dismiss();
                }
            });
            setWidth(view.getWidth());
            setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            showAsDropDown(view, 0, 5);
            WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
            lp.alpha = 0.7f;
            getActivity().getWindow().setAttributes(lp);
            setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss() {
                    WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                    lp.alpha = 1f;
                    getActivity().getWindow().setAttributes(lp);
                }
            });
        }
    }


}
