package com.flowerbell.gejigeji.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView

import com.flowerbell.gejigeji.R

/**
 * Created by MIT on 2018/2/3.
 */

class StrokeTextView (context: Context?, attrs: AttributeSet?) : android.support.v7.widget.AppCompatTextView(context, attrs) {

    //private var mTextPaint: TextPaint
    private var mInnerColor: Int
    private var mOuterColor: Int
    private var mHasBorder: Boolean
    private var outlineTextView: TextView? = null
    private var mStrokeWidth: Float

    // fongUrl是自定义字体分类的名称
    private val fontUrl = "fonts/hylxjt.ttf"
    //Typeface是字体，这里我们创建一个对象
    private var tf: Typeface? = null

    init {

        val array = context!!.obtainStyledAttributes(attrs, R.styleable.StrokeTextView)
        mHasBorder = array.getBoolean(R.styleable.StrokeTextView_StrokeTextViewHasBorder, false)
        mInnerColor = array.getColor(R.styleable.StrokeTextView_StrokeTextViewInnerColor, context.resources.getColor(R.color.color_fff))
        mOuterColor = array.getColor(R.styleable.StrokeTextView_StrokeTextViewOuterColor, context.resources.getColor(R.color.color_7b492a))
        mStrokeWidth = array.getDimension(R.styleable.StrokeTextView_StrokeTextViewStroke, 4f)
        array.recycle()
        outlineTextView = TextView(context, attrs)
        tf = Typeface.createFromAsset(context.assets,fontUrl)
        initView()
    }

    private fun initView() {
        setTextColor(mInnerColor)
        val paint = outlineTextView!!.paint
        paint.strokeWidth = mStrokeWidth// 描边宽度
        paint.style = Paint.Style.STROKE
        if (mHasBorder) {
            outlineTextView!!.typeface = tf
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
