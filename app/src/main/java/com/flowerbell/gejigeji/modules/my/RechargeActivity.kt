package com.flowerbell.gejigeji.modules.my

import com.chuangxincheng.commlibrary.sys.StatusBarUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity

/**
 * 充值
 */
class RechargeActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_recharge
    }

    override fun initView() {
        StatusBarUtil.immersive(this)
    }

    override fun initData() {
    }

    override fun initListener() {
    }


}
