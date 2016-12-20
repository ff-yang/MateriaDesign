package com.example.xinyu.testsome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xinyu.testsome.CardViewActivity;
import com.example.xinyu.testsome.R;
import com.example.xinyu.testsome.adapter.RecyclerWidgetAdapter;
import com.example.xinyu.testsome.event.RecyclerViewListener;
import com.example.xinyu.testsome.view.RecyclerViewDivider;

/**
 * Created by Administrator on 2016/10/22.
 */
public class WidgetFragment extends Fragment {
    private RecyclerView mRecyclerView;
    String[] mData = {"RecyclerView", "CardView", "TextInPutLayout", "AppBar"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_widget, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_widget);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(), RecyclerViewDivider.VERTICAL_LIST,R.drawable.ic_line));
        final RecyclerWidgetAdapter adapter = new RecyclerWidgetAdapter(mData, getActivity());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewListener(mRecyclerView, new RecyclerViewListener.OnItemClickListener() {
            @Override
            public void setOnItemClick(View v, int position) {
                Log.i("ff", "in the widget click");
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), CardViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), CardViewActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), CardViewActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), CardViewActivity.class));
                        break;

                }
            }

            @Override
            public void setOnLongClickListener(View v, int position) {
                Log.i("ff", "in the widget long click");
                startActivity(new Intent(getActivity(), CardViewActivity.class));
            }
        }));
    }
}
