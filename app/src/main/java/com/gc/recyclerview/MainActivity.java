package com.gc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mDatas;
    private RecyclerView rv_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();

        MyAdapter myAdapter = new MyAdapter(this, mDatas);
        rv_recyclerView.setAdapter(myAdapter);

        //设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_recyclerView.setLayoutManager(linearLayoutManager);

        //设置RecyclerView的Item间的分割线
        rv_recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A' ; i <= 'z' ; i++){
            mDatas.add("" + (char)i);
        }
    }

    private void initViews() {
        rv_recyclerView = (RecyclerView) findViewById(R.id.rv_RecyclerView);

    }
}
