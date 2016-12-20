package com.example.xinyu.testsome.event;


import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/10/27.
 */

public class RecyclerViewListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;
    private GestureDetectorCompat mGestureDetector;
    public interface OnItemClickListener{
        void setOnItemClick(View v,int position);
        void setOnLongClickListener(View v,int position);
    }

    public RecyclerViewListener( final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetectorCompat(recyclerView.getContext(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        Log.i("ff", "onSingleTapUp in GestureDetectorCompat");
                        View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (childView != null && mListener != null ) {
                            mListener.setOnItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                        }
                        return true;

                    }


                    @Override
                    public void onLongPress(MotionEvent e) {
                        Log.i("ff", "on long click in GestureDetectorCompat");
                        View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (childView != null && mListener != null ) {
                            mListener.setOnLongClickListener(childView,
                                    recyclerView.getChildAdapterPosition(childView));
                        }
                    }
                });
    }



    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//        Log.e("ff", "in listener intercepte event");/
        boolean b = mGestureDetector.onTouchEvent(e);//MotionEvent交给GestureDetector
//        * 来分析是否有合适的callback函数来处理用户的手势
        Log.e("ff", "mGestureDetector boolean" + b);
//        View childView = rv.findChildViewUnder(e.getX(), e.getY());
//        if (childView != null && mListener != null) {
//            mListener.setOnItemClick(childView,rv.getChildAdapterPosition(childView));
//        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
