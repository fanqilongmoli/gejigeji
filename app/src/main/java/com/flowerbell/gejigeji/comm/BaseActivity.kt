package com.flowerbell.gejigeji.comm

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by MIT on 2018/2/6.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId())
        initView()
        initData()
        initListener()
    }

    /**
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 设置lis
     */
    abstract fun initListener()

    /**
     * 打卡软键盘
     */
    fun openKeyBord(mEditText: EditText, mContext: Context) {
        val inputMethodManager = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN)
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * 关闭软键盘
     */
    fun closeKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }


}