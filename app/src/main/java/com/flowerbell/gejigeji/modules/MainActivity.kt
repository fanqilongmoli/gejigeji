package com.flowerbell.gejigeji.modules


import android.support.v4.app.FragmentTransaction
import com.chuangxincheng.commlibrary.sys.StatusBarUtil
import com.flowerbell.gejigeji.R
import com.flowerbell.gejigeji.comm.BaseActivity
import com.flowerbell.gejigeji.modules.main.fragment.ExchangeFragment
import com.flowerbell.gejigeji.modules.main.fragment.FarmFragment
import com.flowerbell.gejigeji.modules.main.fragment.MyFragment
import com.flowerbell.gejigeji.widget.TabBar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主界面
 */
class MainActivity : BaseActivity() {

    private var mIndex = -1
    private var mFarmFragment: FarmFragment? = null
    private var mExchangeFragment: ExchangeFragment? = null
    private var mMyFragment: MyFragment? = null

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        StatusBarUtil.immersive(this)

    }

    override fun initData() {

        tabBar.setTabBarSelectListener(object : TabBar.TabBarSelectListener{
            override fun tabSelect(position: Int) {
                if (position != mIndex)
                    switchFragment(position)
            }
        })
        tabBar.setCurrentTab(0)


    }



    override fun initListener() {

    }


    private fun switchFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (index){
            0->
                mFarmFragment?.let {
                    transaction.show(it)
                }?:FarmFragment.getInstance().let {
                    mFarmFragment = it
                    transaction.add(R.id.flContainer,it)
                }
            1->
                mExchangeFragment?.let {
                    transaction.show(it)
                }?:ExchangeFragment.getInstance().let {
                    mExchangeFragment = it
                    transaction.add(R.id.flContainer,it)
                }

            2->
                mMyFragment?.let {
                    transaction.show(it)
                }?:MyFragment.getInstance().let {
                    mMyFragment = it
                    transaction.add(R.id.flContainer,it)
                }

        }
        mIndex = index
        transaction.commitAllowingStateLoss()
    }

    private fun hideFragments(transaction: FragmentTransaction) {

        mFarmFragment?.let { transaction.hide(it) }
        mExchangeFragment?.let { transaction.hide(it) }
        mMyFragment?.let { transaction.hide(it) }
    }


}
