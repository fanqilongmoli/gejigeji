package com.flowerbell.gejigeji.modules.exchange


import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment


/**
 * 商店
 */
class StoreFragment : BaseFragment() {

    companion object {
        fun getInstance(): StoreFragment {
            return StoreFragment()
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.fragment_store
    }

    override fun initView() {

    }

}
