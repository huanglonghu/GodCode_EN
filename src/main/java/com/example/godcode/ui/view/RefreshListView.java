package com.example.godcode.ui.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.godcode.R;
import com.example.godcode.databinding.ListFootBinding;
import com.example.godcode.utils.LogUtil;

public class RefreshListView extends ListView implements AbsListView.OnScrollListener {

    private ListFootBinding listFootBinding;
    private boolean isLoading;

    public RefreshListView(Context context) {
        this(context, null);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        listFootBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_foot, null, false);
        listFootBinding.setIsLoading(true);
        setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int page = 1;
        if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
            View lastVisibleItemView = getChildAt(getChildCount() - 1);
            if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == getHeight() && isLoading) {
                if (getFooterViewsCount() == 0) {
                    addFooterView(listFootBinding.getRoot());
                }
                listFootBinding.setIsLoading(false);
                listFootBinding.getRoot().setVisibility(View.VISIBLE);
                LogUtil.log("----滑动到底了----");
                page++;
                LogUtil.log("===============Page================"+page);
                refreshData.refreshData(page);
                return;
            }
        }

    }


    public interface RefreshData {
        void refreshData(int page);
    }

    private RefreshData refreshData;

    public void setRefreshData(RefreshData refreshData) {
        this.refreshData = refreshData;
    }


    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}
