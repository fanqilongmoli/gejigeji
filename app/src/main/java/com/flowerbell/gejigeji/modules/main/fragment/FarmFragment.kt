package com.flowerbell.gejigeji.modules.main.fragment


import com.chuangxincheng.commlibrary.ToastUtil
import com.chuangxincheng.commlibrary.app.ActivityDelegate
import com.chuangxincheng.commlibrary.log.LogUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.comm.network.OnModel
import com.flowerbell.gejigeji.modules.farm.MessageActivity
import com.flowerbell.gejigeji.widget.FarmTitle
import com.flowerbell.gejigeji.widget.FarmView
import com.flowerbell.gejigeji.widget.dialog.FeedChickenDialog
import com.flowerbell.gejigeji.widget.dialog.GoToStoreDialog
import com.flowerbell.gejigeji.widget.dialog.TrusteeshipDialog
import kotlinx.android.synthetic.main.fragment_farm.*


/**
 * 农场
 */
class FarmFragment : BaseFragment() {
    companion object {
        fun getInstance(): FarmFragment {
            return FarmFragment()
        }
    }

    private val onModel by lazy {
        OnModel()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_farm
    }

    override fun initView() {
        noChicken()

        farmTitle.setFarmTitleListener(object :FarmTitle.FarmTitleListener{
            override fun messageClick() {
                ActivityDelegate.create(MessageActivity::class.java).open(context)
            }

            override fun autoClick() {
                val trusteeshipDialog = TrusteeshipDialog(context)
                trusteeshipDialog.show()
            }

            override fun cinemaClick() {
                ToastUtil.showShort(context, "相机点击")
            }

        })
        //喂食点击
        farmView.setFeedListener(object :FarmView.FeedListener{
            override fun feedClick() {
                val feedChickenDialog = FeedChickenDialog(context)
                feedChickenDialog.setFeedListener(object :FeedChickenDialog.FeedChickenDialogListener{
                    override fun feedClick() {
                        //=======
                        var subscribe = onModel.on().subscribe({
                            issue ->
                            LogUtil.d(issue.toString())
                        },{
                            throwable ->
                            LogUtil.d(throwable.message)
                        })
                    }
                })
                feedChickenDialog.show()
            }

        })


    }



    /**
     * Fragment显示隐藏的时候会调用
     * Fragment中的onHiddenChanged方法在这里可以更新界面数据
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden)
            hasChicken()
    }


    /**
     * 没有建鸡舍
     */
    private fun noBuildChickenRoom() {
        farmTitle.noBuildChickenRoom()
        farmView.noBuildChickenRoom()
        val goToStoreDialog = GoToStoreDialog(context)
        goToStoreDialog.setMessage("尚未建设鸡舍,赶紧去商店看看吧!")
        goToStoreDialog.setGoToStoreDialogListener(object : GoToStoreDialog.GoToStoreDialogListener {
            override fun goToStoreClick() {
                ToastUtil.showShort(context, "点击去商店")
            }

        })
        goToStoreDialog.show()
    }

    /**
     * 没有小鸡
     */
    private fun noChicken() {
        farmTitle.noChicken()
        farmView.noChicken()
        val goToStoreDialog = GoToStoreDialog(context)
        goToStoreDialog.setMessage("鸡舍中没有小鸡入住呢,赶紧去商店看看吧!")
        goToStoreDialog.setGoToStoreDialogListener(object : GoToStoreDialog.GoToStoreDialogListener {
            override fun goToStoreClick() {
                ToastUtil.showShort(context, "点击去商店")
            }

        })
        goToStoreDialog.show()
    }

    private fun hasChicken(){
        farmView.noEgg()
    }

}
