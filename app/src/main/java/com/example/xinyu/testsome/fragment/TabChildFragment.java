package com.example.xinyu.testsome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.xinyu.testsome.R;

/**
 * Created by xinyu on 2016/10/20.
 */
public class TabChildFragment extends Fragment {

    private static final int[] DRAWABLE = { R.drawable.f, R.drawable.s, R.drawable.t, R.drawable.fo,
            R.drawable.fi, R.drawable.fi, R.drawable.fi, R.drawable.fi };
    private int position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position=getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(params);
        frameLayout.setBackgroundResource(DRAWABLE[position]);
        TextView tv = new TextView(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(layoutParams);

        tv.setGravity(Gravity.CENTER);
        tv.setText("fragment" + (position + 1));
        frameLayout.addView(tv);
        return frameLayout;
    }
}






