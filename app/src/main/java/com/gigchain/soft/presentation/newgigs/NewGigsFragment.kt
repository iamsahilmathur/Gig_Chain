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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        clickEvents()
        setMapView(getBinding().mapView.id)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_new_gigs
    }

    private fun setupViews() {
        newGigsAdapter = NewGigsAdapter(requireContext())
        getBinding().viewPager2.adapter = newGigsAdapter
    }


    override fun getBindingVariable(): Int {
        return BR.newGigsVM
    }

    private fun clickEvents() {

        getBinding().apply {
            imageViewForward.setSafeOnClickListener {
                viewPager2.currentItem = viewPager2.currentItem + 1
            }
            imageViewPrevious.setSafeOnClickListener {
                viewPager2.currentItem = viewPager2.currentItem - 1
            }
            cardViewList.setSafeOnClickListener {
                replaceFragment(NewGigsListViewFragment(), conataner.id)
            }
        }


    }



    override fun getViewModel(): NewGigsViewModel {
        return newGigViewModel
    }


}




