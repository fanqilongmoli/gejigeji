package com.flowerbell.gejigeji.comm

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by MIT on 2018/2/7.
 */
abstract class BaseFragment: Fragment() {
    /**
     * view 是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据时候加载过了
     */
    private var hasLoadData = false



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getLayoutId(),null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /**
     * 加载布局文件
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 初始化View
     */
    abstract fun initView()

    fun getFragmentTitle(): String {
        return "No title"
    }


}