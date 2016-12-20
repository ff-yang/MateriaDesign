package com.example.xinyu.testsome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.xinyu.testsome.MaterialDesignApp;
import com.example.xinyu.testsome.NewsDetails;
import com.example.xinyu.testsome.R;
import com.example.xinyu.testsome.adapter.RecyclerDemoAdapter;
import com.example.xinyu.testsome.entity.NewsEntity;
import com.example.xinyu.testsome.event.LoadMoreListener;
import com.example.xinyu.testsome.event.RecyclerViewListener;
import com.example.xinyu.testsome.view.RecyclerViewDivider;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/10/22.
 */
public class DemoFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private NewsEntity mEntity;
    private LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout mRefreshLayout;
    private String path = "http://news-at.zhihu.com/api/4/news/latest";
    private RecyclerDemoAdapter mAdapter;
    private LoadMoreListener mLoadMoreListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.frag_demo, container, false);
        initView(v);
        return v;
    }

    private void initData(final boolean isLoad) {
        StringRequest mRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                mEntity = gson.fromJson(response, NewsEntity.class);
                mProgressBar.setVisibility(View.GONE);
                if (mAdapter != null) {
                    if (isLoad) {
                        mAdapter.addData(mEntity);
                        mAdapter.setOnFinsh();
                    } else {
                        mAdapter.updateData(mEntity);
                        mRefreshLayout.setRefreshing(false);
                    }
                } else {
                    mAdapter = new RecyclerDemoAdapter(getActivity(), mEntity);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MaterialDesignApp.mQueue.add(mRequest);

    }

    private void initView(View v) {
        mRecyclerView = (RecyclerView) v.findViewById(R.id.rv_demo);
        mProgressBar = (ProgressBar) v.findViewById(R.id.pb_demo);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(), RecyclerViewDivider.VERTICAL_LIST));
        mRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.refresh_demo);
        mRefreshLayout.setColorSchemeResources(R.color.google_blue, R.color.google_green,
                R.color.google_red, R.color.google_yellow);
        mRecyclerView.addOnItemTouchListener(new RecyclerViewListener(mRecyclerView, new RecyclerViewListener.OnItemClickListener() {
            @Override
            public void setOnItemClick(View v, int position) {
                Toast.makeText(getActivity(), "ghj" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),NewsDetails.class));
            }

            @Override
            public void setOnLongClickListener(View v, int position) {

            }
        }));
        mRefreshLayout.setOnRefreshListener(this);
        mLoadMoreListener = new LoadMoreListener(mLayoutManager) {
            @Override
            protected void onLoadMore() {
                Log.i("ff", "in current page ----------------------------------------");
                path = "http://news-at.zhihu.com/api/4/news/before/20161026";
                initData(true);
                setLoad(true);
            }
        };
        mRecyclerView.addOnScrollListener(mLoadMoreListener);
        initData(false);
    }

    @Override
    public void onRefresh() {
        path = "http://news-at.zhihu.com/api/4/news/before/20161029";
        initData(false);
    }
}
