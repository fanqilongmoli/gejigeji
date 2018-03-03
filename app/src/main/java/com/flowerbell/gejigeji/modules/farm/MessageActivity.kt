package com.flowerbell.gejigeji.modules.farm


import com.chuangxincheng.commlibrary.sys.StatusBarUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity

/**
 * 消息
 */
class MessageActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_message
    }

    override fun initView() {
        StatusBarUtil.immersive(this)
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}
