package com.flowerbell.gejigeji.modules.main.fragment


import com.chuangxincheng.commlibrary.ToastUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseFragment
import com.flowerbell.gejigeji.widget.FarmTitle
import com.flowerbell.gejigeji.widget.dialog.GoToStoreDialog
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

    override fun getLayoutId(): Int {
        return R.layout.fragment_farm
    }

    override fun initView() {
        noBuildChickenRoom()

        farmTitle.setFarmTitleListener(object :FarmTitle.FarmTitleListener{
            override fun messageClick() {
                ToastUtil.showShort(context, "消息点击")
            }

            override fun autoClick() {
                ToastUtil.showShort(context, "自动点击")
            }

            override fun cinemaClick() {
                ToastUtil.showShort(context, "相机点击")
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
            noBuildChickenRoom()
    }


    /**
     * 没有建鸡舍
     */
    private fun noBuildChickenRoom() {
        llRoot.setBackgroundResource(R.drawable.none_bg)
        farmTitle.noBuildChickenRoom()
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
        llRoot.setBackgroundResource(R.drawable.bg_img)
        farmTitle.noChicken()
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
        llRoot.setBackgroundResource(R.drawable.bg_img)

    }

}
