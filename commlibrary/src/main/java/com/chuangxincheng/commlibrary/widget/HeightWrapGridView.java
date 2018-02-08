package com.chuangxincheng.commlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by fanqilong on 2017/7/7.
 */

public class HeightWrapGridView extends GridView {

    public HeightWrapGridView(Context context) {
        this(context, null);
    }

    public HeightWrapGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeightWrapGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setSelector(android.R.color.transparent);
        setOverScrollMode(OVER_SCROLL_NEVER);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
