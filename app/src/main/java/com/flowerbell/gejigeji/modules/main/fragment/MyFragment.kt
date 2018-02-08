package com.flowerbell.gejigeji.modules.main.fragment

import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment


/**
 * 我的界面
 */
class MyFragment : BaseFragment() {
    companion object {
        fun getInstance():MyFragment{
            return MyFragment()
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }

    override fun initView() {

    }
}
