package com.dr_recyclerviewdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public abstract class ScrollBottomListener extends  RecyclerView.OnScrollListener{

    private int scrollState;
    private int allChildCount;
    private int visibleChildCount;
    private int scrollCount;

    LinearLayoutManager mLinearLayoutManager;
    public ScrollBottomListener(LinearLayoutManager mLinearLayoutManager)
    {
        this.mLinearLayoutManager = mLinearLayoutManager;

    }
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        scrollState = newState;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleChildCount = recyclerView.getChildCount();
        allChildCount = mLinearLayoutManager.getItemCount();

//        if(scrollState = RecyclerView.SCROLL_STATE_DRAGGING){
//
//        }

        int lastVisibleChildPosition = mLinearLayoutManager.findLastVisibleItemPosition();

        //最底部
        if(lastVisibleChildPosition+1 == allChildCount){
            LoadMore();
        }


    }

    /**
     * 加载更多的抽象方法
     */
    public abstract void LoadMore();
}
