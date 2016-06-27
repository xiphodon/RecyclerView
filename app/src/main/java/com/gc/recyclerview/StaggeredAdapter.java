package com.gc.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 适配器
 */
public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHolder> {

    private Context context;
    private List<String> mDatas;
    private List<Integer> mHeight;
    private LayoutInflater mInflater;

    public StaggeredAdapter(Context context, List<String> datas) {
        this.context = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);

        mHeight = new ArrayList<>();
        for(int i = 0 ; i < mDatas.size() ; i++){
            mHeight.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public StaggeredAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_textview, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(StaggeredAdapter.MyViewHolder holder, int position) {
        holder.tv_item.setText(mDatas.get(position));

        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeight.get(position);
        holder.itemView.setLayoutParams(layoutParams);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int position){
        mDatas.add(position,"Insert One");
        notifyItemInserted(position);
    }

    public void deleteData(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }




    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_item;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_item = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}


