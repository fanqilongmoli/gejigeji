package com.flowerbell.gejigeji.modules.exchange


import android.view.View
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.modules.exchange.adapter.StoreChickenAdapter
import com.flowerbell.gejigeji.modules.exchange.adapter.StoreFoodAdapter
import kotlinx.android.synthetic.main.fragment_store.*


/**
 * 商店
 */
class StoreFragment : BaseFragment(), View.OnClickListener {

    private var storeChickenAdapter: StoreChickenAdapter? = null
    private var storeFoodAdapter: StoreFoodAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_store
    }

    override fun initView() {


        rl_chicken.setOnClickListener(this)
        rl_fodder.setOnClickListener(this)

        storeChickenAdapter = StoreChickenAdapter(context, R.layout.item_store_chicken)
        heightWrapGridView.adapter = storeChickenAdapter

        val temp: ArrayList<String> = ArrayList()
        temp.add("1")
        temp.add("1")
        temp.add("1")


        storeChickenAdapter!!.data = temp

        storeFoodAdapter = StoreFoodAdapter(context,R.layout.item_store_food)
        val temp2: ArrayList<String> = ArrayList()
        temp2.add("1")
        temp2.add("1")
        heightWrapGridView_food.adapter = storeFoodAdapter
        storeFoodAdapter?.data = temp2

        heightWrapGridView.visibility = View.VISIBLE
        heightWrapGridView_food.visibility = View.GONE

    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.rl_chicken -> {
                //鸡点击
                rl_chicken.setBackgroundDrawable(context.resources.getDrawable(R.drawable.chicken_bg))
                rl_fodder.setBackgroundDrawable(context.resources.getDrawable(R.drawable.fodder_bg_pre))

                heightWrapGridView.visibility = View.VISIBLE
                heightWrapGridView_food.visibility = View.GONE
            }
            R.id.rl_fodder -> {
                //饲料点击
                rl_chicken.setBackgroundDrawable(context.resources.getDrawable(R.drawable.chicken_bg_pre))
                rl_fodder.setBackgroundDrawable(context.resources.getDrawable(R.drawable.fodder_bg))

                heightWrapGridView.visibility = View.GONE
                heightWrapGridView_food.visibility = View.VISIBLE
            }
        }
    }

}
