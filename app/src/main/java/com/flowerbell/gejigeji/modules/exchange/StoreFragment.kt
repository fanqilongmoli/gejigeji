package com.flowerbell.gejigeji.modules.exchange


import android.view.View
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.modules.exchange.adapter.StoreChickenAdapter
import kotlinx.android.synthetic.main.fragment_store.*


/**
 * 商店
 */
class StoreFragment : BaseFragment(), View.OnClickListener {

    private var storeChickenAdapter: StoreChickenAdapter?=null


    override fun getLayoutId(): Int {
        return R.layout.fragment_store
    }

    override fun initView() {


        rl_chicken.setOnClickListener(this)
        rl_fodder.setOnClickListener(this)

        storeChickenAdapter = StoreChickenAdapter(context,R.layout.item_store_chicken)
        heightWrapGridView.adapter = storeChickenAdapter

        val temp :ArrayList<String> = ArrayList()
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")
        temp.add("1")

        storeChickenAdapter!!.data = temp
    }




    override fun onClick(v: View?) {
        when (v!!.id) {
             R.id.rl_chicken-> {
                 //鸡点击
                 rl_chicken.setBackgroundDrawable(context.resources.getDrawable(R.drawable.chicken_bg))
                 rl_fodder.setBackgroundDrawable(context.resources.getDrawable(R.drawable.fodder_bg_pre))
            }
            R.id.rl_fodder -> {
                //饲料点击
                rl_chicken.setBackgroundDrawable(context.resources.getDrawable(R.drawable.chicken_bg_pre))
                rl_fodder.setBackgroundDrawable(context.resources.getDrawable(R.drawable.fodder_bg))
            }
        }
    }

}
