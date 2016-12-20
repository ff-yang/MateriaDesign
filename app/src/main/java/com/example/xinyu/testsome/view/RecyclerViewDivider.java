package com.example.xinyu.testsome.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/10/22.
 */

public class RecyclerViewDivider extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = {android.R.attr.listDivider};
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;
    private int mDividerHeight = 1;
    private int mOrientation;
    private Paint mPaint;

    /**
     * 默认分割线
     *
     * @param orientation recyclerView的方向
     * @param context
     */
    public RecyclerViewDivider(Context context, int orientation) {

        TypedArray mTypedArray = context.obtainStyledAttributes(ATTRS);
        mDivider = mTypedArray.getDrawable(0);
        mTypedArray.recycle();
        setOrientation(orientation);
    }

    /**
     * 自定义分割线
     * @param context
     * @param orientation
     * @param drawableID 分割线图片
     */
    public RecyclerViewDivider(Context context, int orientation, int drawableID) {
        this(context, orientation);
        mDivider = ContextCompat.getDrawable(context, drawableID);
        mDividerHeight = mDivider.getIntrinsicHeight();
    }

    /**
     * 自定义分割线
     * @param context
     * @param orientation  方向
     * @param dividerHeight 分割线的高度
     * @param dividerColor  分割线颜色
     */
    public RecyclerViewDivider(Context context,int orientation,int dividerHeight,int dividerColor) {
        this(context, orientation);
        mDividerHeight = dividerHeight;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(dividerColor);
        mPaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 设置方向如果方向设置错误抛出invalid orientation异常
     * @param orientation
     */
    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c,parent);
        }

    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int left = childView.getRight() + params.rightMargin;
            final int right = left + mDividerHeight;
            if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);

            }
            if (mPaint != null) {
                canvas.drawRect(left, top, right, bottom, mPaint);
            }


        }
    }

    /**
     * 画横线
     * @param c
     * @param parent
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int top = childView.getBottom() + params.bottomMargin;
//            Log.i("ff", "mDividerHeight is: " + mDivider.getIntrinsicHeight());
            final int bottom = top + mDividerHeight;
            if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
            if (mPaint != null) {
                c.drawRect(left,top,right,bottom,mPaint);
            }

        }

    }



    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        if(mOrientation == VERTICAL_LIST){
            Log.i("ff", "draw horizontal line");
            //画横线，就是往下偏移一个分割线的高度
            outRect.set(0, 0, 0, mDividerHeight);
        }else {
            Log.i("ff", "draw horizontal line");
            //画竖线，就是往右偏移一个分割线的宽度
            outRect.set(0, 0, mDividerHeight, 0);
        }

    }
}



