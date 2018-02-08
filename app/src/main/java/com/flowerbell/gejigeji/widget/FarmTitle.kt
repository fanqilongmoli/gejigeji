package com.flowerbell.gejigeji.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.view_farm_title.view.*

/**
 * Created by MIT on 2018/2/8.
 */
class FarmTitle(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs), View.OnClickListener {

    private var farmTitleListener: FarmTitleListener? = null

    fun setFarmTitleListener(lis: FarmTitleListener) {
        farmTitleListener = lis
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_farm_title, this)
        ivMessage.setOnClickListener(this)
        ivAuto.setOnClickListener(this)
        ivCinema.setOnClickListener(this)

    }

    /**
     * 设置数量
     */
    fun setNum(num: String) {
        tvNum.text = num
    }

    fun noBuildChickenRoom() {
        llNum.visibility = View.GONE
        ivCinema.visibility = View.GONE
    }

    fun noChicken() {
        llNum.visibility = View.VISIBLE
        ivCinema.visibility = View.VISIBLE
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ivMessage -> {
                farmTitleListener!!.messageClick()
            }
            R.id.ivAuto -> {
                farmTitleListener!!.autoClick()
            }
            R.id.ivCinema -> {
                farmTitleListener!!.cinemaClick()
            }

        }
    }

    interface FarmTitleListener {
        fun messageClick()
        fun autoClick()
        fun cinemaClick()
    }
}