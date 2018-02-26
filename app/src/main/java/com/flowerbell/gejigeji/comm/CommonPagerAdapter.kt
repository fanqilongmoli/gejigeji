package com.flowerbell.gejigeji.comm

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by MIT on 2018/2/26.
 */
class CommonPagerAdapter(fm: FragmentManager, private val mFragments: List<BaseFragment>?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mFragments!![position]
    }

    override fun getCount(): Int {
        var ret = 0
        if (mFragments != null) {
            ret = mFragments.size
        }
        return ret
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragments!![position].getFragmentTitle()
    }
}