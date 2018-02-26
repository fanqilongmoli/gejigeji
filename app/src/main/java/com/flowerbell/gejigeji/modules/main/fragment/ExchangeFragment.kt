package com.flowerbell.gejigeji.modules.main.fragment


import android.view.View
import com.chuangxincheng.commlibrary.ToastUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.comm.CommonPagerAdapter
import com.flowerbell.gejigeji.modules.exchange.AuctionHouseFragment
import com.flowerbell.gejigeji.modules.exchange.StoreFragment
import kotlinx.android.synthetic.main.fragment_exchange.*


/**
 * 交易所
 */
class ExchangeFragment : BaseFragment(), View.OnClickListener {

    private var fragments: ArrayList<BaseFragment> = ArrayList()

    companion object {
        fun getInstance(): ExchangeFragment {
            return ExchangeFragment()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_exchange
    }

    override fun initView() {
        ll_auction_house.setOnClickListener(this)
        ll_store.setOnClickListener(this)

        fragments.add(StoreFragment())
        fragments.add(AuctionHouseFragment())

        noScrollViewPager.adapter = CommonPagerAdapter(fragmentManager, fragments)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ll_auction_house -> {
                ToastUtil.showShort(context, "点击交易所")
                tv_store.setInnerOuterColor(resources.getColor(R.color.color_ffefae), resources.getColor(R.color.color_7b492a), true)
                tv_store_line.setInnerOuterColor(resources.getColor(R.color.color_ffefae), resources.getColor(R.color.color_7b492a), true)

                tv_auction_house.setInnerOuterColor(resources.getColor(R.color.color_fdd329), resources.getColor(R.color.color_7b492a), true)
                tv_auction_house_line.setInnerOuterColor(resources.getColor(R.color.color_fdd329), resources.getColor(R.color.color_7b492a), true)

            }
            R.id.ll_store -> {
                ToastUtil.showShort(context, "点击商店")

                tv_store.setInnerOuterColor(resources.getColor(R.color.color_fdd329), resources.getColor(R.color.color_7b492a), true)
                tv_store_line.setInnerOuterColor(resources.getColor(R.color.color_fdd329), resources.getColor(R.color.color_7b492a), true)

                tv_auction_house.setInnerOuterColor(resources.getColor(R.color.color_ffefae), resources.getColor(R.color.color_7b492a), true)
                tv_auction_house_line.setInnerOuterColor(resources.getColor(R.color.color_ffefae), resources.getColor(R.color.color_7b492a), true)
            }
        }
    }


}
