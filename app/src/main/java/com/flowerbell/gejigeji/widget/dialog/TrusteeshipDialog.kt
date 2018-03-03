package com.flowerbell.gejigeji.widget.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.chuangxincheng.commlibrary.sys.DeviceUtils
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.dialog_trusteeship_view.view.*

/**
 * Created by MIT on 2018/2/9.
 * 托管dialog
 */
class TrusteeshipDialog(context: Context?) : LinearLayout(context) {
    private var mDialog: Dialog? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.dialog_trusteeship_view,this@TrusteeshipDialog)

        mDialog = Dialog(context, R.style.AlertDialogStyle)
        mDialog!!.setContentView(this)

        llRoot.layoutParams = LayoutParams((DeviceUtils.getScreenWidth(context) * 0.8f).toInt(), LayoutParams.WRAP_CONTENT)

        tv_close.setOnClickListener {
            mDialog!!.dismiss()
        }

        tv_ok.setOnClickListener {
            mDialog!!.dismiss()
        }
    }

    fun show() {
        mDialog!!.show()
    }
}