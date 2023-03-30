package com.gigchain.soft.presentation.currentgigs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gigchain.soft.BR
import com.gigchain.soft.R
import com.gigchain.soft.databinding.FragmentCurrentGigsBinding
import com.gigchain.soft.presentation.baseviews.BaseFragment
import com.gigchain.soft.presentation.currentgigs.adapter.CurrentGigsAdapter
import com.gigchain.soft.presentation.utilities.setSafeOnClickListener


class CurrentGigsFragment : BaseFragment<FragmentCurrentGigsBinding, CurrentGigsViewModel>() {

    private val currentGigsViewModel: CurrentGigsViewModel by viewModels()
    private lateinit var currentGigsAdapter: CurrentGigsAdapter

    // Setting up views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        clickEvents()
        setMapView(getBinding().mapView.id)
    }

    // Slider view set up
    private fun setupViews() {
        currentGigsAdapter = CurrentGigsAdapter(requireContext())
        getBinding().viewPager2.adapter = currentGigsAdapter
    }

   // Click Events
    private fun clickEvents() {

        getBinding().apply {
            imageViewForward.setSafeOnClickListener {
                viewPager2.currentItem = viewPager2.currentItem + 1
            }
            imageViewPrevious.setSafeOnClickListener {
                viewPager2.currentItem = viewPager2.currentItem - 1
            }
            cardViewList.setSafeOnClickListener {
                replaceFragment(CurrentGigsListViewFragment(), conataner.id)
            }
        }


    }

   // setting up layout id
    override fun getLayoutId(): Int {
        return R.layout.fragment_current_gigs
    }

    // setting up ViewModel instance
    override fun getViewModel(): CurrentGigsViewModel {
        return currentGigsViewModel
    }

    // setting up ViewModel binding variable
    override fun getBindingVariable(): Int {
        return BR.currentGigsVM
    }


}