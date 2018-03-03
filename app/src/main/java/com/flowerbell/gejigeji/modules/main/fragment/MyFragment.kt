package com.flowerbell.gejigeji.modules.main.fragment

import android.content.Intent
import android.view.View
import com.chuangxincheng.commlibrary.app.ActivityDelegate
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.modules.my.MyInfoActivity
import com.flowerbell.gejigeji.modules.my.MyWalletActivity
import com.flowerbell.gejigeji.modules.my.RechargeActivity
import com.flowerbell.gejigeji.modules.my.WithdrawActivity
import kotlinx.android.synthetic.main.fragment_my.*


/**
 * 我的界面
 */
class MyFragment : BaseFragment(), View.OnClickListener {


    companion object {
        fun getInstance():MyFragment{
            return MyFragment()
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }

    override fun initView() {
        iv_header.setOnClickListener(this)
        tv_wallet.setOnClickListener(this)
        tv_recharge.setOnClickListener(this)
        tv_withdraw.setOnClickListener(this)
    }




    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_header -> {
                ActivityDelegate.create(MyInfoActivity::class.java).open(context)
            }
            R.id.tv_wallet->{
                //钱包
                ActivityDelegate.create(MyWalletActivity::class.java).open(context)
            }
            R.id.tv_recharge->{
                //充值
                ActivityDelegate.create(RechargeActivity::class.java).open(context)
            }
            R.id.tv_withdraw->{
                //提现
                ActivityDelegate.create(WithdrawActivity::class.java).open(context)
            }
        }
    }
}
