package com.gigchain.soft.presentation.newgigs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gigchain.soft.BR
import com.gigchain.soft.R
import com.gigchain.soft.databinding.FragmentCurrentGigsBinding
import com.gigchain.soft.databinding.FragmentNewGigsBinding
import com.gigchain.soft.presentation.baseviews.BaseFragment
import com.gigchain.soft.presentation.newgigs.adapter.NewGigsAdapter
import com.gigchain.soft.presentation.utilities.setSafeOnClickListener

class NewGigsFragment : BaseFragment<FragmentNewGigsBinding, NewGigsViewModel>() {
    private val newGigViewModel: NewGigsViewModel by viewModels()
    private lateinit var newGigsAdapter: NewGigsAdapter

    // setting up views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        clickEvents()
        setMapView(getBinding().mapView.id)
    }

    // setting up Layout Id
    override fun getLayoutId(): Int {
        return R.layout.fragment_new_gigs
    }

    // setting up slider
    private fun setupViews() {
        newGigsAdapter = NewGigsAdapter(requireContext())
        getBinding().viewPager2.adapter = newGigsAdapter
    }

    // setting up binding variable
    override fun getBindingVariable(): Int {
        return BR.newGigsVM
    }

    // click events
    private fun clickEvents() {

        getBinding().apply {
            // viewpager forward
            imageViewForward.setSafeOnClickListener {
                viewPager2.currentItem = viewPager2.currentItem + 1
            }
            // viewpager backward
            imageViewPrevious.setSafeOnClickListener {
                viewPager2.currentItem = viewPager2.currentItem - 1
            }
            // replacing MapView with ListView
            cardViewList.setSafeOnClickListener {
                replaceFragment(NewGigsListViewFragment(), conataner.id)
            }
        }


    }


    // setting up ViewModel instance
    override fun getViewModel(): NewGigsViewModel {
        return newGigViewModel
    }


}




