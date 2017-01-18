package com.dr_recyclerviewdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.w3c.dom.Attr;

/**
 * RecycleView的item的分割线
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    Context context;
    private int mOrientation;
    private int HORIZONTAL = LinearLayoutManager.HORIZONTAL;
    private int VERTICAL = LinearLayoutManager.VERTICAL;
    private Drawable mDevider;

    //我们通过获取系统属性中的listDivider来添加，在系统中的AppTheme中设置
    private int[] ATRRS  = new int[]{
            android.R.attr.listDivider
    };

    public MyItemDecoration( Context context,int orientation) {
        super();
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(ATRRS);
        mDevider = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(orientation);

    }

    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOrientation == HORIZONTAL)
        {
            drawVerticalDevider(c,parent,state);

        }else if(mOrientation == VERTICAL){

            drawHorizontalDevider(c,parent,state);

        }
    }

    /**
     * 画水平线
     * @param c
     * @param parent
     * @param state
     */
    private void drawHorizontalDevider(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int left = parent.getLeft()+parent.getPaddingLeft();
        int right  = parent.getWidth() - parent.getPaddingRight();

        for(int i = 0; i < parent.getChildCount(); i++)
        {
            View child = parent.getChildAt(i);

            //画在child的下面
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDevider.getIntrinsicHeight();

            mDevider.setBounds(left,top,right,bottom);
            mDevider.draw(c);

        }



    }

    /**
     * 画竖线
     * @param c
     * @param parent
     * @param state
     */
    private void drawVerticalDevider(Canvas c, RecyclerView parent, RecyclerView.State state){

        int top = parent.getTop()+ parent.getPaddingTop();
        int bottom  = parent.getBottom()- parent.getPaddingRight();

        for(int i = 0; i < parent.getChildCount(); i++)
        {
            View child = parent.getChildAt(i);

            //画在child的右边
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int right = left + mDevider.getIntrinsicWidth();

            mDevider.setBounds(left,top,right,bottom);
            mDevider.draw(c);

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(mOrientation == HORIZONTAL){
            outRect.set(0,0,mDevider.getIntrinsicWidth(),0);
        }else if(mOrientation == VERTICAL){
            outRect.set(0,0,0,mDevider.getIntrinsicHeight());
        }
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

    }
}
