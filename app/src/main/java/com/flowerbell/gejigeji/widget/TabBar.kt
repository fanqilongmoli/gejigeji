package com.flowerbell.gejigeji.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.chuangxincheng.commlibrary.ToastUtil
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.view_layout_tab_bar.view.*

/**
 * Created by MIT on 2018/2/7.
 */
class TabBar(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs), View.OnClickListener {
    private var innerColor: Int = 0
    private var outerColor: Int = 0

    private var tabBarSelectListener: TabBarSelectListener? = null

    fun setTabBarSelectListener(lis: TabBarSelectListener) {
        tabBarSelectListener = lis
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_layout_tab_bar, this)


        initView()
    }

    private fun initView() {
        rlFarm!!.setOnClickListener(this)
        rlExchange!!.setOnClickListener(this)
        rlMine!!.setOnClickListener(this)

        innerColor = context.resources.getColor(R.color.color_fff)
        outerColor = context.resources.getColor(R.color.color_7b492a)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.rlFarm -> {
                backAllColor()
                tvFarm.setInnerOuterColor(innerColor, outerColor, true)
                ivFarm.setImageResource(R.drawable.farm_ic_pre)
                tabBarSelectListener?.tabSelect(0)
            }
            R.id.rlExchange -> {
                backAllColor()
                tvExchange.setInnerOuterColor(innerColor, outerColor, true)
                ivExchange.setImageResource(R.drawable.exchange_ic_pre)
                tabBarSelectListener?.tabSelect(1)
            }
            R.id.rlMine -> {
                backAllColor()
                tvMine.setInnerOuterColor(innerColor, outerColor, true)
                ivMine.setImageResource(R.drawable.mine_ic_pre)
                tabBarSelectListener?.tabSelect(2)
            }
        }
    }

    private fun backAllColor() {
        tvFarm.setInnerOuterColor(innerColor, innerColor, false)
        tvExchange.setInnerOuterColor(innerColor, innerColor, false)
        tvMine.setInnerOuterColor(innerColor, innerColor, false)

        ivFarm.setImageResource(R.drawable.farm_ic)
        ivExchange.setImageResource(R.drawable.exchange_ic)
        ivMine.setImageResource(R.drawable.mine_ic)
    }

    fun setCurrentTab(position: Int) {
        when (position) {
            0 -> {
                onClick(rlFarm)
            }
            1 -> {
                onClick(rlExchange)
            }
            2 -> {
                onClick(rlMine)
            }

        }
    }

    interface TabBarSelectListener {
        fun tabSelect(position: Int)
    }

}