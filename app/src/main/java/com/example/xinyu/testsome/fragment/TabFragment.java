package com.example.xinyu.testsome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xinyu.testsome.R;
import com.example.xinyu.testsome.adapter.MyFragPageAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/22.
 */

public class TabFragment extends Fragment {
    private ViewPager mViewPager;
    private TextView mTextView;
    private TabLayout mTabLayout;
    private final List<String> TITLE =new ArrayList<>();
    int i=5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_tab, container, false);
        mTextView = (TextView) v.findViewById(R.id.tv_frag_tab);
        mViewPager = (ViewPager) v.findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) v.findViewById(R.id.tabLayout);

        for (int a=0;a<4;a++){
            TITLE.add(""+a);
        }
       mTabLayout.setupWithViewPager(mViewPager);
        final MyFragPageAdapter myFragPageAdapter = new MyFragPageAdapter(this.getFragmentManager(), null, TITLE);
        mViewPager.setAdapter(myFragPageAdapter);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTabLayout.addTab(mTabLayout.newTab().setText(""+i).setIcon(R.mipmap.ic_launcher));

                TITLE.add(""+i);
                myFragPageAdapter.notifyDataSetChanged();
                if (i < 8) {
                    i++;
                } else {
                    Snackbar.make(v, "图片暂无", Snackbar.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }


}
