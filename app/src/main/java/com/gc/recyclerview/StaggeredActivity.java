package com.gc.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class StaggeredActivity extends AppCompatActivity {

    private ArrayList<String> mDatas;
    private RecyclerView rv_recyclerView;
    private StaggeredAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();

        myAdapter = new StaggeredAdapter(this, mDatas);
        rv_recyclerView.setAdapter(myAdapter);

        //设置RecyclerView的布局管理
        rv_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        //设置添加删除动画
        rv_recyclerView.setItemAnimator(new DefaultItemAnimator());

//        //设置RecyclerView的Item间的分割线
//        rv_recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


        myAdapter.setOnClickListener(new StaggeredAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this,"点击" + mDatas.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this,"长按" + mDatas.get(position),Toast.LENGTH_SHORT).show();
            }
        });
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
            case R.id.action_add:
                myAdapter.addData(1);
                break;
            case R.id.action_del:
                myAdapter.deleteData(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
