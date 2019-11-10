package com.mufeng.fragmentlazydemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/10 13:31
 * @描述
 */
class BaseViewPagerAdapter(fm: FragmentManager, val fragments: List<Fragment>) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}