package com.example.godcode_en.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import com.example.godcode_en.bean.LoginBody;
import com.example.godcode_en.bean.LoginResponse;
import com.example.godcode_en.bean.RegisterBody;
import com.example.godcode_en.bean.WxDlMsg;
import com.example.godcode_en.greendao.entity.LoginResult;
import com.example.godcode_en.greendao.option.LoginResultOption;
import com.example.godcode_en.http.HttpUtil;
import com.example.godcode_en.presenter.Presenter;
import com.example.godcode_en.ui.activity.MainActivity;
import com.example.godcode_en.constant.Constant;
import com.example.godcode_en.ui.fragment.newui.login.RegisterFragment;
import com.example.godcode_en.utils.LogUtil;
import com.example.godcode_en.utils.SharepreferenceUtil;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    public int WX_LOGIN = 1;
    private IWXAPI iwxapi;
    private SendAuth.Resp resp;
    private String APP_ID = "wxf145d2ce67346702";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        iwxapi = WXAPIFactory.createWXAPI(this, APP_ID, true);
        iwxapi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {}

    //请求回调结果处理
    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == WX_LOGIN) {
            resp = (SendAuth.Resp) baseResp;
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    String code = String.valueOf(resp.code);
                    //获取用户信息
                    getAccessToken(code);
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                    Toast.makeText(WXEntryActivity.this, "用户拒绝授权", Toast.LENGTH_LONG).show();
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                    Toast.makeText(WXEntryActivity.this, "用户取消登录", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
        finish();
    }

    private void getAccessToken(String code) {
        //获取openid
        HttpUtil.getInstance().getOpenId(code).subscribe(
                wxdlStr -> {
                    LogUtil.log("=========wxdlstr========="+wxdlStr);
                    WxDlMsg wxDlMsg = new Gson().fromJson(wxdlStr, WxDlMsg.class);
                    WxDlMsg.DataBean data = wxDlMsg.getData();
                    LoginBody loginBody = new LoginBody();
                    loginBody.setOpenID(data.getOpenid());
                    loginBody.setDeviceToken(Constant.diviceToken);
                    HttpUtil.getInstance().login(loginBody).subscribe(
                            loginStr -> {
                                if (loginStr.contains("\"success\":false")) {
                                    //将注册信息传递过去
                                    RegisterFragment register = new RegisterFragment();
                                    RegisterBody registerBody = new RegisterBody();
                                    registerBody.setNickName(data.getNickname());
                                    registerBody.setHeadImgUrl(data.getHeadimgurl());
                                    registerBody.setOpenID(data.getOpenid());
                                    registerBody.setSex(data.getSex() + "");
                                    register.initData(registerBody);
                                    Presenter.getInstance().step2Fragment(register, "register");
                                } else {
                                    LoginResponse loginResponse = new Gson().fromJson(loginStr, LoginResponse.class);
                                    LoginResponse.ResultBean result = loginResponse.getResult();
                                    LoginResult loginResult = new LoginResult(Constant.uniquenessToken, result.getPayServerUrl(), result.getUserId());
                                    Constant.uniquenessToken = result.getUniquenessToken();
                                    Constant.balances = result.getBalances();
                                    Constant.toDayMoney = result.getToDayMoney();
                                    Constant.yesterDayMoney = result.getYesterDayMoney();
                                    loginResult.setUniquenessToken(Constant.uniquenessToken);
                                    LoginResultOption.getInstance().insertLoginResult(loginResult);
                                    Constant.userId = result.getUserId();
                                    long time = System.currentTimeMillis();
                                    SharepreferenceUtil.getInstance().saveAccessToken(result.getAccessToken(), Constant.uniquenessToken, time);
                                    Constant.payUrl = result.getPayServerUrl();
                                    Constant.expireInSeconds = result.getExpireInSeconds();
                                    Intent intent = new Intent(this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                    );
                }
        );
    }
}