package com.gc.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public MyAdapter(Context context,List<String> datas) {
        this.context = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_textview, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_item.setText(mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tv_item;

    public MyViewHolder(View itemView) {
        super(itemView);

        tv_item = (TextView) itemView.findViewById(R.id.tv_item);
    }
}
