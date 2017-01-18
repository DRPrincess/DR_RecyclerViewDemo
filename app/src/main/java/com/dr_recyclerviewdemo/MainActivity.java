package com.dr_recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_recyclerView).setOnClickListener(this);
        findViewById(R.id.btn_swipeLayout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId())
        {

            case R.id.btn_recyclerView:
                intent = new Intent(this,NormalRecyclerViewActivity.class);
                break;
            case R.id.btn_swipeLayout:
                intent = new Intent(this,SwipeRefreshLayoutRecyclerViewActivity.class);
                break;

        }

        if(intent != null)
        {
            startActivity(intent);
        }

    }
}
