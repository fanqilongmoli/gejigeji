package com.flowerbell.gejigeji.widget.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.chuangxincheng.commlibrary.sys.DeviceUtils
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.widget.FarmView
import kotlinx.android.synthetic.main.dialog_feed_chicken.view.*

/**
 * Created by fanqilong on 2018/3/4.
 * 喂食
 */
class FeedChickenDialog(context: Context?) : LinearLayout(context), View.OnClickListener {


    private var feedChickenDialogListener:FeedChickenDialogListener? = null
    private var mDialog: Dialog? = null

    fun setFeedListener(lis: FeedChickenDialog.FeedChickenDialogListener) {
        feedChickenDialogListener = lis
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.dialog_feed_chicken, this@FeedChickenDialog)

        mDialog = Dialog(context, R.style.AlertDialogStyle)
        mDialog!!.setContentView(this)

        llRoot.layoutParams = LayoutParams((DeviceUtils.getScreenWidth(context) * 0.8f).toInt(), LayoutParams.WRAP_CONTENT)

        tv_feed.setOnClickListener {
            feedChickenDialogListener?.feedClick()
            mDialog?.dismiss()

        }
        ll_xiaomai.setOnClickListener(this)
        ll_xiaomi.setOnClickListener(this)
        ll_dami.setOnClickListener(this)
        ll_daogu.setOnClickListener(this)
    }


    fun show() {
        mDialog!!.show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_xiaomai -> {
                ll_xiaomai.background = context.resources.getDrawable(R.drawable.shape_feed_select)
                ll_xiaomi.background = null
                ll_dami.background = null
                ll_daogu.background = null
            }
            R.id.ll_xiaomi -> {
                ll_xiaomai.background = null
                ll_xiaomi.background = context.resources.getDrawable(R.drawable.shape_feed_select)
                ll_dami.background = null
                ll_daogu.background = null
            }
            R.id.ll_dami -> {
                ll_xiaomai.background = null
                ll_xiaomi.background = null
                ll_dami.background = context.resources.getDrawable(R.drawable.shape_feed_select)
                ll_daogu.background = null
            }
            R.id.ll_daogu -> {
                ll_xiaomai.background = null
                ll_xiaomi.background = null
                ll_dami.background = null
                ll_daogu.background = context.resources.getDrawable(R.drawable.shape_feed_select)
            }
        }
    }

    interface FeedChickenDialogListener {
        fun feedClick()
    }
}