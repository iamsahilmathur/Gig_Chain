package com.gigchain.soft.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gigchain.soft.R
import com.gigchain.soft.databinding.ActivityMainBinding
import com.gigchain.soft.presentation.currentgigs.CurrentGigsFragment
import com.gigchain.soft.presentation.home.HomeFragment
import com.gigchain.soft.presentation.newgigs.NewGigsFragment
import com.gigchain.soft.presentation.utilities.Constants
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    // setting up views
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragList = generateViewList()
        val viewPagerAdapter = MainViewPagerAdapter(this, fragList)

        // init TabViews
        mainBinding.apply {
            pager.adapter = viewPagerAdapter
            TabLayoutMediator(
                tabs, pager
            ) { tab, position ->

                setTabTitle(tab, position)

            }.attach()
        }

    }

    // setting up Tab names
    private fun setTabTitle(tab: TabLayout.Tab, pos: Int) {
        var title = ""
        title = when (pos) {
            0 -> Constants.HOME_TITLE_CONSTANT
            1 -> Constants.NEWGIGS_TITLE_CONSTANT
            else -> Constants.CURRENTGIGS_TITLE_CONSTANTS
        }
        tab.text = title
    }

    // creating fragment list
    private fun generateViewList(): List<Fragment> {
        val fragmentList = mutableListOf<Fragment>()
        fragmentList.add(HomeFragment())
        fragmentList.add(NewGigsFragment())
        fragmentList.add(CurrentGigsFragment())
        return fragmentList
    }

}