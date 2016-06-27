package com.gc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

//        //设置RecyclerView的Item间的分割线
//        rv_recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void initViews() {
        rv_recyclerView = (RecyclerView) findViewById(R.id.rv_RecyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_listview:
                rv_recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                break;
            case R.id.action_gridview:
                rv_recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_hor_gridview:
                rv_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
