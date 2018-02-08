package com.flowerbell.gejigeji.widget.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.chuangxincheng.commlibrary.ToastUtil
import com.chuangxincheng.commlibrary.sys.DeviceUtils
import com.flowerbell.gejigeji.R
import kotlinx.android.synthetic.main.dialog_goto_store.view.*

/**
 * Created by MIT on 2018/2/8.
 * 点击去商店的dialog
 */
class GoToStoreDialog(context: Context?) : LinearLayout(context) {
    private var mDialog: Dialog? = null
    private var goToStoreDialogListener: GoToStoreDialogListener? = null

    fun setGoToStoreDialogListener(lis: GoToStoreDialogListener) {
        goToStoreDialogListener = lis
    }

    init {


        LayoutInflater.from(context).inflate(R.layout.dialog_goto_store, this)

        mDialog = Dialog(context, R.style.AlertDialogStyle)
        mDialog!!.setContentView(this)

        llRoot.layoutParams = LayoutParams((DeviceUtils.getScreenWidth(context) * 0.8f).toInt(), LayoutParams.WRAP_CONTENT)
        tvGoToStore.setOnClickListener({
            goToStoreDialogListener!!.goToStoreClick()
            mDialog!!.dismiss()
        })
    }

    fun show() {
        mDialog!!.show()
    }

    fun setMessage(message: String) {
        tvMessage.text = message
    }

    fun setCancelable(cancelable: Boolean) {
        mDialog!!.setCancelable(cancelable)
    }


    interface GoToStoreDialogListener {
        fun goToStoreClick()
    }
}