package com.example.godcode.ui.base;
import android.content.Context;
import android.support.v4.app.Fragment;
import com.example.godcode.presenter.Presenter;
import com.example.godcode.ui.activity.BaseActivity;

public abstract class BaseFragment extends Fragment {

    public Presenter presenter;
    public BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) getActivity();
        presenter = Presenter.getInstance();
    }


    //在onCreate方法之前调用，用来判断Fragment的UI是否是可见的

    /**
     * 视图可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 自定义抽象加载数据方法
     */
    protected  void lazyLoad(){};



    public void onKeyDown() {

    }


}
