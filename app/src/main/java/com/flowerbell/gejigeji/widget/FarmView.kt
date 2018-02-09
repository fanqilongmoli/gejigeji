package com.flowerbell.gejigeji.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.view_farm_view.view.*

/**
 * Created by MIT on 2018/2/9.
 */
class FarmView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_farm_view,this)
    }


    fun noEgg(){
        ivChicken.visibility = View.VISIBLE
        ivFood.visibility = View.VISIBLE
        ivEgg.visibility = View.INVISIBLE
    }

    fun noChicken(){
        ivChicken.visibility = View.INVISIBLE
        ivEgg.visibility = View.INVISIBLE
        ivFood.visibility = View.INVISIBLE
    }

    fun noBuildChickenRoom(){
        ivChicken.visibility = View.GONE
        ivEgg.visibility = View.GONE
        ivFood.visibility = View.GONE
        rlRoot.setBackgroundResource(R.drawable.none_bg)
    }

}