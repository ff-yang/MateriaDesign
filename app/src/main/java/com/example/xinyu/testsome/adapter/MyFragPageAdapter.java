package com.example.xinyu.testsome.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xinyu.testsome.fragment.TabChildFragment;

import java.util.List;

/**
 * Created by xinyu on 2016/10/20.
 */
public class MyFragPageAdapter extends FragmentStatePagerAdapter{
    private List<String> title;
    private Context mContext;
    public MyFragPageAdapter(FragmentManager fm, Context context, List<String> title) {
        super(fm);
        this.title = title;
        this.mContext = context;
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString(" ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return title.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        TabChildFragment tabChildFragment =new TabChildFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        tabChildFragment.setArguments(bundle);
        return tabChildFragment;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }
}
