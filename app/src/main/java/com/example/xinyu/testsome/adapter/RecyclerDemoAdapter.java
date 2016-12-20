package com.example.xinyu.testsome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyu.testsome.R;
import com.example.xinyu.testsome.entity.NewsEntity;
import com.example.xinyu.testsome.utils.MyUtils;

/**
 * Created by Administrator on 2016/10/28.
 */

public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private NewsEntity mNewsEntity;
    private LayoutInflater mInflater;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public RecyclerDemoAdapter(Context context, NewsEntity entity) {
        this.mNewsEntity = entity;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_frag_demo, parent, false);
            Holder mHolder = new Holder(v);
            return mHolder;
        } else if (viewType == TYPE_FOOTER) {
            footView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false);
            FooterHolder mHolder = new FooterHolder(footView);

            return mHolder;
        }
        return null;
    }
    private View footView;
    public void setOnFinsh(){
        if (footView != null) {
            footView.setVisibility(View.GONE);
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerDemoAdapter.Holder) {
           Holder mHolder = (Holder) holder;
            mHolder.tv.setText(mNewsEntity.getStories().get(position).getTitle());
            Log.i("ff", "the mNewsEntity title is " + mNewsEntity.getStories().get(position).getTitle());
            MyUtils.setImage(mNewsEntity.getStories().get(position).getImages().get(0),mHolder.iv);
        }
    }

    public void updateData(NewsEntity entity) {
        this.mNewsEntity = entity;
        notifyDataSetChanged();
    }
    public void addData(NewsEntity entity){
        this.mNewsEntity.getStories().addAll(entity.getStories());
        this.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        Log.i("ff", "mNewsEntity is: " + mNewsEntity.getStories().get(0).getTitle());

        Log.i("ff", "mNewsEntity size is: " + mNewsEntity.getStories().size());
        return mNewsEntity.getStories().size();
    }

     class Holder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        public Holder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_tv_demo);
            iv = (ImageView) itemView.findViewById(R.id.item_iv_demo);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public FooterHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_tv_foot);
        }
    }

}
