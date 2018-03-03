package com.flowerbell.gejigeji.modules.my

import com.chuangxincheng.commlibrary.sys.StatusBarUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity

/**
 * 个人信息
 */
class MyInfoActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_my_info
    }

    override fun initView() {
        StatusBarUtil.immersive(this)
    }

    override fun initData() {
    }

    override fun initListener() {
    }

}
