package com.flowerbell.gejigeji.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.view_comm_title.view.*

/**
 * Created by fanqilong on 2018/3/6.
 * 通用的title
 */
class CommTitleBar: LinearLayout {

    init {
        LayoutInflater
                .from(context)
                .inflate(R.layout.view_comm_title, this)

        iv_return.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
    }

    constructor(context: Context) : this(context,null)

    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr:Int) :super(context,attrs,defStyleAttr){
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        attrs?.let {
            val array = context.obtainStyledAttributes(it, R.styleable.CommTitleBar)
            val title = array.getString(R.styleable.CommTitleBar_CommTitleBarTitle)

            tv_name.text = title

            array.recycle()
        }
    }
}