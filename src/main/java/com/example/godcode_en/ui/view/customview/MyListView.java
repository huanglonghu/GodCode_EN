package com.example.godcode_en.ui.view.customview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.example.godcode_en.R;
import com.example.godcode_en.databinding.ListFootBinding;
import com.example.godcode_en.utils.LogUtil;

public class MyListView extends ListView implements AbsListView.OnScrollListener {

    private ListFootBinding listFootBinding;
    private int page=1;
    private View footView;

    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        listFootBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_foot, null, false);
        footView = listFootBinding.getRoot();
        setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
            if (currentState != STATE_LOADCOMPLETE) {
                View lastVisibleItemView = getChildAt(getChildCount() - 1);
                if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == getHeight()) {
                    LogUtil.log(page + "==============滑动到底了=========" + currentState);
                    if (currentState == STATE_LOADING && getFooterViewsCount() == 0) {
                        addFooterView(footView);
                        listFootBinding.setIsLoading(true);
                    }
                    refreshData.refreshData(page);
                    return;
                }
            }

        }

    }


    private int currentState;

    private final int STATE_LOADING = 0;

    private final int STATE_LOADCOMPLETE = 1;

    private final int STATE_LOADREFRESH = 2;

    public void setState(int currentState) {
        this.currentState = currentState;
        switch (currentState) {
            case STATE_LOADING:
                page++;
                break;
            case STATE_LOADCOMPLETE:
                listFootBinding.setIsLoading(false);
                break;
            case STATE_LOADREFRESH:
                //移除已加载的所有内容
                // 清空 footview
                removeFooterView(footView);
                page = 1;
                refreshData.refreshData(page);
                break;
        }

    }

    public interface RefreshData {
        void refreshData(int page);
    }

    private RefreshData refreshData;

    public void setRefreshData(RefreshData refreshData) {
        this.refreshData = refreshData;
    }


}
