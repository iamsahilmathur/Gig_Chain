package com.gigchain.soft.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(
    private val fragmentActivity: FragmentActivity, private val fragmentList: List<Fragment>
) : FragmentStateAdapter(fragmentActivity) {

    // fragment counts
    override fun getItemCount(): Int {
        return fragmentList.size
    }
     // setting up fragment
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}