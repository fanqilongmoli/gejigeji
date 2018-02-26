package com.flowerbell.gejigeji.widget.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.flowerbell.gejigeji.R

/**
 * Created by MIT on 2018/2/9.
 * 托管dialog
 */
class TrusteeshipDialog(context: Context?) : LinearLayout(context) {


    init {
        LayoutInflater.from(context).inflate(R.layout.dialog_trusteeship_view,this@TrusteeshipDialog)

    }
}