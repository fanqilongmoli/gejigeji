package com.chuangxincheng.commlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by fanqilong on 2017/6/6.
 * 无限长的listView
 */

public class HeightWrapListView extends ListView {

    public HeightWrapListView(Context context) {
        super(context);
    }

    public HeightWrapListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeightWrapListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
