package com.example.xinyu.testsome.event;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.xinyu.testsome.utils.MyUtils;

/**
 * Created by Administrator on 2016/11/1.
 */

public abstract class LoadMoreListener extends RecyclerView.OnScrollListener {
    private boolean isLoad;
    private RecyclerView.LayoutManager mLayoutManager;

    public LoadMoreListener(LinearLayoutManager mLayoutManager) {
        this.mLayoutManager = mLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        /*
      visibleItemCount 当前界面显示的个数
      totalItemCount 总共的item的数量
      firstVisibleItem 当前显示第一个的是哪一个
     */
        int visibleItemCount = mLayoutManager.getChildCount();
        int totalItemCount = mLayoutManager.getItemCount();
        int lastVisibleItemPosition;
        if (mLayoutManager instanceof GridLayoutManager) {
            lastVisibleItemPosition = ((GridLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        } else if (mLayoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastVisibleItem = ((StaggeredGridLayoutManager) mLayoutManager).
                    findLastVisibleItemPositions(new int[((StaggeredGridLayoutManager) mLayoutManager).getSpanCount()]);
            lastVisibleItemPosition = MyUtils.getMaxValue(lastVisibleItem);
        } else {
            lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        }

        Log.i("ff", "lastVisibleItemPosition is: " + lastVisibleItemPosition);
        Log.i("ff", "totalItemCount is: " + totalItemCount);
        Log.i("ff", "visibleItemCount is: " + visibleItemCount);
        if (visibleItemCount > 0 && lastVisibleItemPosition >= totalItemCount - 1
                && totalItemCount > visibleItemCount ) {
            if (!isLoad) {
                isLoad = true;
                onLoadMore();
            }
        }
        Log.i("ff", isLoad + "================================");
    }
    public void setLoad(boolean load) {
        isLoad = load;

    }


    protected abstract void onLoadMore();

}
