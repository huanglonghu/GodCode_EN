package com.example.godcode.ui.fragment.deatailFragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.godcode.R;
import com.example.godcode.bean.BankCard;
import com.example.godcode.bean.Tx;
import com.example.godcode.constant.Constant;
import com.example.godcode.databinding.FragmentTxFirstBinding;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.interface_.Strategy;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.ui.view.KeyBoard;
import com.example.godcode.ui.view.MyEditText;
import com.example.godcode.ui.view.PsdPopupWindow;
import com.example.godcode.ui.view.widget.TxReminderDialog;
import com.example.godcode.utils.FormatUtil;
import com.example.godcode.utils.LogUtil;
import com.example.godcode.utils.MoneyTextWatcher;
import com.example.godcode.utils.PayPsdSetting;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.utils.Log;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tx_firstFragment extends BaseFragment implements KeyBoard.PsdLengthWatcher, MyEditText.MoneyValueListener {

    private FragmentTxFirstBinding binding;
    private View view;
    private double money;
    private TxFragment parentFragment;
    private BankCard.ResultBean resultBean;
    private double rate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            parentFragment = (TxFragment) getParentFragment();
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tx_first, container, false);
            binding.etMoney.setMoneyValueListener(this);
            binding.setBalance(parentFragment.getBalance());
            view = binding.getRoot();
            initData();
            initView();
            initListener();
        }
        return view;
    }

    private void initData() {
        getBankList();
    }


    private void isEffectiveDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        String url = "http://tool.bitefu.net/jiari/" + "?d=" + date;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (s.equals("0")) {
                    tx();
                } else {
                    new TxReminderDialog(getContext(), new Strategy() {
                        @Override
                        public void sure() {
                            tx();
                        }
                    }).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                tx();
            }
        });
        requestQueue.add(stringRequest);
    }


    private void initListener() {
        binding.btnTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEffectiveDate();
            }
        });

        binding.txAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double balance = parentFragment.getBalance();
                double txf = 0;
                if (balance <= 100) {
                    if (balance <= 0.6) {
                        binding.btnTx.setEnabled(false);
                        binding.setTx(false);
                        binding.useBalance.setText("服务费0.6元,超过可用余额");
                    } else {
                        double value = balance - 0.6;
                        BigDecimal bg = new BigDecimal(value);
                        value = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        binding.etMoney.setText(value + "");
                    }
                } else {
                    txf = balance * rate;
                    BigDecimal bg = new BigDecimal(txf);
                    txf = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    if (balance > txf) {
                        BigDecimal bg1 = new BigDecimal(balance - txf);
                        double value = bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        binding.etMoney.setText(value + "");
                    }

                }
            }
        });

        binding.rlBankSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bankList.size() > 0) {
                    BankSelectFragment bankSelectFragment = new BankSelectFragment();
                    presenter.step2Fragment(bankSelectFragment, "bankSelect");
                } else {
                    presenter.step2Fragment("bankCard");
                }
            }
        });
    }

    private void tx() {
        if (bankList.size() == 0) {
            presenter.step2Fragment("bankCard");
        } else {
            money = Double.parseDouble(binding.etMoney.getText().toString());
            if (money > parentFragment.getBalance()) {
                Toast.makeText(activity, "超出本次可提现金额", Toast.LENGTH_SHORT).show();
            } else {
                PayPsdSetting.getInstance().isPayPsdSet("提现", money, view, Tx_firstFragment.this, 2);
            }
        }
    }

    public void initView() {
        binding.etMoney.addTextChangedListener(new MoneyTextWatcher(binding.etMoney));
        rate = parentFragment.getWithdrawRate();
        binding.txRate.setText("(收取" + FormatUtil.getInstance().get2double(rate * 100) + "%服务费)");
        binding.setTx(true);
        binding.useBalance.setText("可用余额" + parentFragment.getBalance());
    }

    private ArrayList<BankCard.ResultBean> bankList = new ArrayList<>();

    private void getBankList() {
        HttpUtil.getInstance().getBankCardsByUserID(Constant.userId).subscribe(
                bankListStr -> {
                    BankCard bankCard = new Gson().fromJson(bankListStr, BankCard.class);
                    List<BankCard.ResultBean> result = bankCard.getResult();
                    if (bankList.size() > 0) {
                        bankList.clear();
                    }
                    for (int i = 0; i < result.size(); i++) {
                        BankCard.ResultBean resultBean = result.get(i);
                        if (resultBean.getBindType() == 3) {
                            bankList.add(resultBean);
                        }
                    }
                    if (bankList.size() == 0) {
                        binding.txBank.setText("添加新卡提现");
                    } else {
                        resultBean = bankList.get(0);
                        String bankName = resultBean.getBankName();
                        String last4Num = FormatUtil.getInstance().getLast4Num(resultBean.getBankCardNumber());
                        binding.txBank.setText(bankName + "(" + last4Num + ")");
                    }
                }
        );
    }


    @Override
    protected void lazyLoad() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void toCheck(String psd) {
        Tx tx = new Tx();
        tx.setPassword(psd);
        Tx.PutMoneyDtoBean putMoneyDtoBean = new Tx.PutMoneyDtoBean();
        putMoneyDtoBean.setFeeType("CNY");
        putMoneyDtoBean.setFK_UserID(Constant.userId);
        putMoneyDtoBean.setSumTotal(money);
        putMoneyDtoBean.setFK_BankCardID(resultBean.getId());
        tx.setPutMoneyDto(putMoneyDtoBean);
        HttpUtil.getInstance().tx(tx).subscribe(
                txStr -> {
                    if (txStr.contains("\"success\":false")) {
                        PsdPopupWindow.getInstance(activity).clear();
                        Toast.makeText(activity, "密码输入错误，请重新输入", Toast.LENGTH_SHORT).show();
                    } else {
                        PsdPopupWindow.getInstance(activity).exit();
                        parentFragment.setMoney(Double.parseDouble(binding.etMoney.getText().toString()));
                        parentFragment.setBank(binding.txBank.getText().toString());
                        parentFragment.toggle(1);
                    }
                }
        );
    }

    @Override
    public void onKeyDown() {
        if (PsdPopupWindow.getInstance(activity) != null && PsdPopupWindow.getInstance(activity).isShowing()) {
            PsdPopupWindow.getInstance(activity).exit();
        } else {
            presenter.back();
        }

    }


    @Override
    public void setEnable(boolean enable, double money) {
        double txf = 0;
        double balance = parentFragment.getBalance();
        if (money <= 100) {
            if (enable) {
                txf = 0.6;
                if (money + txf <= parentFragment.getBalance()) {
                    binding.setTx(true);
                    binding.btnTx.setEnabled(true);
                    binding.useBalance.setText("服务费0.6元");
                } else {
                    binding.btnTx.setEnabled(false);
                    binding.setTx(false);
                    binding.useBalance.setText("超过可用余额");
                }
            } else {
                binding.setTx(true);
                binding.btnTx.setEnabled(false);
                binding.useBalance.setText("可用余额" + (parentFragment.getBalance()) + "");
            }
        } else {
            double a = balance * rate;
            BigDecimal bg = new BigDecimal(a);
            double v = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            BigDecimal bg3 = new BigDecimal(money + v);
            double v1 = bg3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (v1 < balance) {
                binding.btnTx.setEnabled(true);
                binding.setTx(true);
                txf = money * rate;
                BigDecimal bg2 = new BigDecimal(txf);
                txf = bg2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                binding.useBalance.setText("服务费" + txf + "元");
            } else if (v1 == balance) {
                binding.btnTx.setEnabled(true);
                binding.setTx(true);
                binding.useBalance.setText("服务费" + v + "元");
            } else {
                binding.btnTx.setEnabled(false);
                binding.setTx(false);
                binding.useBalance.setText("超过可用余额");
            }

        }


    }


}