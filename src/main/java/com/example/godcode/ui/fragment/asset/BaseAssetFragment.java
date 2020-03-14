package com.example.godcode.ui.fragment.asset;

import com.example.godcode.bean.GroupMsg;
import com.example.godcode.http.HttpUtil;
import com.example.godcode.ui.base.BaseFragment;
import com.example.godcode.utils.GsonUtil;

public abstract class BaseAssetFragment extends BaseFragment {


    public abstract void selectDate(int periodType);


    public void querryByStatus(int status) {}


}
