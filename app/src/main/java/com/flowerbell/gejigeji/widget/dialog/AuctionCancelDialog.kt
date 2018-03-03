package com.flowerbell.gejigeji.widget.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.flowerbell.gejigeji.R

/**
 * Created by fanqilong on 2018/3/4.
 * 拍卖撤销
 */
class AuctionCancelDialog(context: Context?) : LinearLayout(context) {
    init {
        LayoutInflater.from(context).inflate(R.layout.dialog_auction_cancel,this@AuctionCancelDialog)
    }
}