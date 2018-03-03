package com.flowerbell.gejigeji.modules.my

import android.support.v7.widget.LinearLayoutManager
import com.chuangxincheng.commlibrary.sys.StatusBarUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity
import com.flowerbell.gejigeji.modules.my.adapter.ConsumeAdapter
import kotlinx.android.synthetic.main.activity_my_wallet.*

class MyWalletActivity : BaseActivity() {

    private var consumeAdapter: ConsumeAdapter?=null

    override fun layoutId(): Int {
        return R.layout.activity_my_wallet
    }

    override fun initView() {
        StatusBarUtil.immersive(this)

        consumeAdapter = ConsumeAdapter(recyclerView,R.layout.item_consume)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = consumeAdapter


    }

    override fun initData() {

        var temp:ArrayList<String> = ArrayList()
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        temp.add("a")
        consumeAdapter?.data = temp
    }

    override fun initListener() {
    }
}
