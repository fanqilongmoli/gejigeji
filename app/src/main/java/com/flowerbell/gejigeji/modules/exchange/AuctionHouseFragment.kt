package com.flowerbell.gejigeji.modules.exchange


import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View


import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.modules.exchange.adapter.AuctionAdapter
import com.flowerbell.gejigeji.modules.exchange.adapter.BuyAdapter
import com.flowerbell.gejigeji.modules.main.fragment.ExchangeFragment
import com.flowerbell.gejigeji.widget.dialog.RecoveryDialog
import com.flowerbell.gejigeji.widget.dialog.ShangJiaDialog
import kotlinx.android.synthetic.main.fragment_auction_house.*


/**
 * 拍卖行
 */
class AuctionHouseFragment : BaseFragment(), View.OnClickListener {

    private var buyAdapter: BuyAdapter? = null
    private var auctionAdapter: AuctionAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_auction_house
    }

    override fun initView() {
        buyAdapter = BuyAdapter(recyclerView_buy,R.layout.item_buy)
        recyclerView_buy.layoutManager = LinearLayoutManager(context)
        recyclerView_buy.adapter = buyAdapter

        var temp :ArrayList<String> = ArrayList()
        temp.add("1")
        temp.add("1")
        temp.add("1")

        buyAdapter?.data =  temp

        auctionAdapter = AuctionAdapter(recyclerView_auction,R.layout.item_auction)
        recyclerView_auction.layoutManager = LinearLayoutManager(context)
        recyclerView_auction.adapter = auctionAdapter

        var temp2 :ArrayList<String> = ArrayList()
        temp2.add("1")
        temp2.add("1")
        temp2.add("1")

        auctionAdapter?.data =  temp2

        recyclerView_buy.visibility = View.VISIBLE
        recyclerView_auction.visibility = View.GONE

        rl_auction.setOnClickListener(this)
        rl_buy.setOnClickListener(this)
        tv_shangjia.setOnClickListener(this)
        tv_huishou.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rl_buy -> {
                // 购买
                rl_buy.setBackgroundDrawable(context.resources.getDrawable(R.drawable.buy_bg))
                rl_auction.setBackgroundDrawable(context.resources.getDrawable(R.drawable.auction_bg_pre))

                recyclerView_buy.visibility = View.VISIBLE
                recyclerView_auction.visibility = View.GONE
            }
            R.id.rl_auction -> {
                // 拍卖
                rl_buy.setBackgroundDrawable(context.resources.getDrawable(R.drawable.buy_bg_pre))
                rl_auction.setBackgroundDrawable(context.resources.getDrawable(R.drawable.auction_bg))

                recyclerView_buy.visibility = View.GONE
                recyclerView_auction.visibility = View.VISIBLE
            }
            R.id.tv_shangjia->{
                //上架
                val shangJiaDialog = ShangJiaDialog(context)
                shangJiaDialog.show()
            }
            R.id.tv_huishou->{
                //回收
                val recoveryDialog = RecoveryDialog(context)
                recoveryDialog.show()
            }


        }
    }

}
