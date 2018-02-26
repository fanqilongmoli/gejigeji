package com.flowerbell.gejigeji.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView

import com.flowerbell.gejigeji.R

import java.lang.reflect.Field

/**
 * Created by MIT on 2018/2/3.
 */

class StrokeTextView @JvmOverloads constructor(private val mContext: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : android.support.v7.widget.AppCompatTextView(mContext, attrs, defStyleAttr) {

    //private var mTextPaint: TextPaint
    private var mInnerColor: Int
    private var mOuterColor: Int
    private var mHasBorder: Boolean
    private var outlineTextView: TextView? = null
    private var mStrokeWidth: Float

    init {

        val array = mContext.obtainStyledAttributes(attrs, R.styleable.StrokeTextView)
        mHasBorder = array.getBoolean(R.styleable.StrokeTextView_StrokeTextViewHasBorder, false)
        mInnerColor = array.getColor(R.styleable.StrokeTextView_StrokeTextViewInnerColor, mContext.resources.getColor(R.color.color_fff))
        mOuterColor = array.getColor(R.styleable.StrokeTextView_StrokeTextViewOuterColor, mContext.resources.getColor(R.color.color_7b492a))
        mStrokeWidth = array.getDimension(R.styleable.StrokeTextView_StrokeTextViewStroke, 4f)
        array.recycle()
        outlineTextView = TextView(mContext, attrs)

        initView()
    }

    private fun initView() {
        setTextColor(mInnerColor)
        val paint = outlineTextView!!.paint
        paint.strokeWidth = mStrokeWidth// 描边宽度
        paint.style = Paint.Style.STROKE
        if (mHasBorder) {
            outlineTextView!!.typeface = Typeface.createFromAsset(mContext.assets, "hylxjt.ttf")
            outlineTextView!!.setTextColor(mOuterColor)// 描边颜色
            outlineTextView!!.gravity = gravity
        }

    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams) {
        super.setLayoutParams(params)
        if (mHasBorder) {
            outlineTextView!!.layoutParams = params
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 设置轮廓文字
        if (mHasBorder) {
            val outlineText = outlineTextView?.text
            if (outlineText == null || outlineText != this.text) {
                outlineTextView?.text = text
                postInvalidate()
            }
            outlineTextView?.measure(widthMeasureSpec, heightMeasureSpec)
        }

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (mHasBorder) {
            outlineTextView!!.layout(left, top, right, bottom)
        }
    }

    override fun onDraw(canvas: Canvas) {
        //倾斜度45,上下左右居中
        //canvas.rotate(0, getMeasuredWidth(), getMeasuredHeight());
        if (mHasBorder) {
            outlineTextView!!.draw(canvas)
        }
        super.onDraw(canvas)
    }

    fun setInnerOuterColor(innerColor: Int, outerColor: Int, hasBorder: Boolean) {
        mInnerColor = innerColor
        mOuterColor = outerColor
        mHasBorder = hasBorder
        initView()
        invalidate()
        requestLayout()
    }


}
