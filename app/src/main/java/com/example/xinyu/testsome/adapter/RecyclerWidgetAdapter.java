package com.example.xinyu.testsome.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xinyu.testsome.R;

/**
 * Created by Administrator on 2016/10/22.
 */

public class RecyclerWidgetAdapter extends RecyclerView.Adapter {
    private String[] mData;
    private Context mContext;
    private LayoutInflater mInflater;
    public RecyclerWidgetAdapter(String[] mData, Context mContext){
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.item_frag_wiget, parent, false);
//        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_frag_wiget, parent, false);

        final MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
//            ((MyViewHolder)holder).tv.setText("=======");
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.tv.setText(mData[position]);
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
     class MyViewHolder extends RecyclerView.ViewHolder {
         TextView tv;
         public MyViewHolder(View itemView) {
             super(itemView);
             tv = (TextView) itemView.findViewById(R.id.item_tv__fg_widget);
         }
     }


}
