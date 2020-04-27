package com.example.godcode_en.greendao.option;

import com.example.godcode_en.greendao.entity.LoginResult;
import com.example.godcode_en.greendao.gen.LoginResultDao;
import com.example.godcode_en.ui.base.GodCodeApplication;
import java.util.List;

public class LoginResultOption {
    private static LoginResultOption defaultInstane;

    private LoginResultOption() {
    }

    public static LoginResultOption getInstance() {
        LoginResultOption loginResultOption = defaultInstane;
        if (defaultInstane == null) {
            synchronized (LoginResultOption.class) {
                if (defaultInstane == null) {
                    loginResultOption = new LoginResultOption();
                    defaultInstane = loginResultOption;
                }
            }
        }
        return loginResultOption;
    }

    public void insertLoginResult(LoginResult loginResult) {
        LoginResultDao loginResultDao = GodCodeApplication.getInstance().getDaoSession().getLoginResultDao();
        LoginResult result = querryLoginResult(loginResult.getUniquenessToken());
        if (result != null) {
            loginResultDao.delete(result);
        }
        loginResultDao.insert(loginResult);
    }

    public LoginResult querryLoginResult(String uniquenessToken) {
        LoginResultDao loginResultDao = GodCodeApplication.getInstance().getDaoSession().getLoginResultDao();
        LoginResult loginResult = loginResultDao.queryBuilder().where(LoginResultDao.Properties.UniquenessToken.eq(uniquenessToken)).unique();
        return loginResult;
    }

    public LoginResult getLoginResult() {
        LoginResultDao loginResultDao = GodCodeApplication.getInstance().getDaoSession().getLoginResultDao();
        List<LoginResult> loginResults = loginResultDao.loadAll();
        if (loginResults.size() == 0) {
            return null;
        } else {
            return loginResults.get(0);
        }
    }


    public void exit() {
        LoginResultDao loginResultDao = GodCodeApplication.getInstance().getDaoSession().getLoginResultDao();
        loginResultDao.deleteAll();
    }
}
