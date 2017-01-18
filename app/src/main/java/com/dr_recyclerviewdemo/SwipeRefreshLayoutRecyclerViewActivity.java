package com.dr_recyclerviewdemo;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dr_recyclerviewdemo.adapter.RecyclerViewAdapter;
import com.dr_recyclerviewdemo.model.AuthorInfo;
import com.dr_recyclerviewdemo.view.MyItemDecoration;

import java.util.ArrayList;

public class SwipeRefreshLayoutRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    RecyclerViewAdapter mAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ArrayList<AuthorInfo> array;
    Context context;
    //假设总页数为5
    int allPage = 5;
    int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout_recycler_view);
        context = this;
        initRecyclerView();
        initSwipeRefreshLayout();
        loadData(0);

        //设置为正在刷新状态
        mSwipeRefreshLayout.setRefreshing(true);
        //触发监听的onRefresh()方法
        onRefreshListener.onRefresh();

    }

    private void loadData(int page)
    {

        currentPage = page;
        if(page == 0)
        {
            if(array == null){
                array = new ArrayList<>();

            }else{
                array.clear();
                AuthorInfo authorInfo = new AuthorInfo();
                authorInfo.setName("DRPrincess");
                authorInfo.setMotto("这是上拉刷新出来的新数据 ");
                array.add(0,authorInfo);
            }

            for(int i = 0; i<6; i++)
            {
                AuthorInfo authorInfo = new AuthorInfo();
                authorInfo.setName("DRPrincess");
                authorInfo.setMotto("The One Who Wants to Wear a Crown Must Bear the Weight ");
                array.add(authorInfo);
            }


        }else{
            if(page < allPage){
                page++;
                AuthorInfo authorInfo = new AuthorInfo();
                authorInfo.setName("DRPrincess");
                authorInfo.setMotto("这是一条新数据 ");
                array.add(authorInfo);
            }
        }

        if(mAdapter == null){
            mAdapter = new RecyclerViewAdapter(this,array);
            mRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }

        //关闭刷新
        if(mSwipeRefreshLayout != null &&mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }



    }
    private void initSwipeRefreshLayout(){
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
    }
    public SwipeRefreshLayout.OnRefreshListener  onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            loadData(0);
        }
    };

    private void initRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //添加item之间的分割线
        mRecyclerView.addItemDecoration(new MyItemDecoration(this, LinearLayoutManager.VERTICAL));

        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View itemView, int position) {
                    Toast.makeText(context, "行单击事件" + position, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemLongClick(View itemView, int position) {
                    Toast.makeText(context, "行长按事件" + position, Toast.LENGTH_SHORT).show();

                }
            });

        }

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleChildCount = recyclerView.getChildCount();
                int allChildCount = mLayoutManager.getItemCount();
                int lastVisiblePosition = mLayoutManager.findLastVisibleItemPosition();
                Log.d("test","visibleChildCount=="+visibleChildCount+"----lastVisiblePosition=="+lastVisiblePosition+"------allChildCount=="+allChildCount);
            }
        });

//        //添加上拉加载更多的监听事件
//        mRecyclerView.setOnScrollListener(new ScrollBottomListener(mLayoutManager) {
//            @Override
//            public void LoadMore() {
//                if(currentPage == allPage){
//                    //mAdapter.removeFooter();
//                    Toast.makeText(context,"已经是最后一页了",Toast.LENGTH_SHORT).show();
//                }else{
//                    loadData(currentPage++);
//                }
//            }
//        });
    }


}
