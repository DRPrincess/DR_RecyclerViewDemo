package com.dr_recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dr_recyclerviewdemo.adapter.RecyclerViewAdapter;
import com.dr_recyclerviewdemo.model.AuthorInfo;
<<<<<<< HEAD
import com.dr_recyclerviewdemo.view.MyItemDecoration;
=======
>>>>>>> 038c6a5a149a0001b9979ba6ce50bb99753142f3

import java.util.ArrayList;

public class NormalRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);
<<<<<<< HEAD
        initRecyclerView();
    }


    private void initRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //添加item之间的分割线
        mRecyclerView.addItemDecoration(new MyItemDecoration(this,LinearLayoutManager.VERTICAL));


        ArrayList<AuthorInfo> array = new ArrayList<>();
=======

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initRecyclerView();



    }

    private void initRecyclerView() {
        ArrayList<AuthorInfo> array = new ArrayList<>();

>>>>>>> 038c6a5a149a0001b9979ba6ce50bb99753142f3
        for(int i = 0; i<20; i++)
        {
            AuthorInfo authorInfo = new AuthorInfo();
            authorInfo.setName("DRPrincess");
            authorInfo.setMotto("The One Who Wants to Wear a Crown Must Bear the Weight ");
            array.add(authorInfo);
        }
<<<<<<< HEAD
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,array);
        mRecyclerView.setAdapter(adapter);

=======


        //创建默认的线性LayoutManager

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

       //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能

        mRecyclerView.setHasFixedSize(true);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,array);

        mRecyclerView.setAdapter(adapter);
>>>>>>> 038c6a5a149a0001b9979ba6ce50bb99753142f3

        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(NormalRecyclerViewActivity.this,"行单击事件"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View itemView, int position) {
                Toast.makeText(NormalRecyclerViewActivity.this,"行长按事件"+position,Toast.LENGTH_SHORT).show();

            }
        });



    }


}
