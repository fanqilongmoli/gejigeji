package com.flowerbell.gejigeji.modules.main.fragment


import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment


/**
 * 交易所
 */
class ExchangeFragment : BaseFragment() {

    companion object {
        fun getInstance():ExchangeFragment{
            return ExchangeFragment()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_exchange
    }

    override fun initView() {

    }



}
