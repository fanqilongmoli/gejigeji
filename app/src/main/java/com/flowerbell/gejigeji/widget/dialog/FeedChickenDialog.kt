package com.flowerbell.gejigeji.widget.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.chuangxincheng.commlibrary.sys.DeviceUtils
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.dialog_feed_chicken.view.*

/**
 * Created by fanqilong on 2018/3/4.
 * 喂食
 */
class FeedChickenDialog(context: Context?) : LinearLayout(context) {
    private var mDialog: Dialog? = null
    init {
        LayoutInflater.from(context).inflate(R.layout.dialog_feed_chicken,this@FeedChickenDialog)

        mDialog = Dialog(context, R.style.AlertDialogStyle)
        mDialog!!.setContentView(this)

        llRoot.layoutParams = LayoutParams((DeviceUtils.getScreenWidth(context) * 0.8f).toInt(), LayoutParams.WRAP_CONTENT)

        tv_feed.setOnClickListener {
            mDialog?.dismiss()
        }
    }


    fun show() {
        mDialog!!.show()
    }
}