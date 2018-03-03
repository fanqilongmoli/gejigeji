package com.flowerbell.gejigeji.modules.my

import android.support.v7.widget.LinearLayoutManager
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity
import com.flowerbell.gejigeji.modules.my.adapter.AddressAdapter
import kotlinx.android.synthetic.main.activity_address_manage.*

/**
 * 地址管理
 */
class AddressManageActivity : BaseActivity() {

    private var addressAdapter: AddressAdapter? = null

    override fun layoutId(): Int {
        return R.layout.activity_address_manage
    }

    override fun initView() {
        addressAdapter = AddressAdapter(recyclerView,R.layout.item_address)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = addressAdapter
    }

    override fun initData() {

        var temp:ArrayList<String> = ArrayList()
        temp.add("a")
        temp.add("a")
        temp.add("a")
        addressAdapter?.data = temp
    }

    override fun initListener() {
    }


}
