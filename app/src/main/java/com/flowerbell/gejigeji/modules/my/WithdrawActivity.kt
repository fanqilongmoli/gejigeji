package com.flowerbell.gejigeji.modules.my

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chuangxincheng.commlibrary.sys.StatusBarUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity

/**
 * 提现
 */
class WithdrawActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_withdraw
    }

    override fun initView() {
        StatusBarUtil.immersive(this)
    }

    override fun initData() {
    }

    override fun initListener() {
    }

}
