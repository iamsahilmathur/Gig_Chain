package com.gigchain.soft.presentation.currentgigs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.gigchain.soft.BR

import com.gigchain.soft.R
import com.gigchain.soft.databinding.FragmentCurrentGigsListviewBinding
import com.gigchain.soft.presentation.baseviews.BaseFragment
import com.gigchain.soft.presentation.currentgigs.adapter.CurrentGigsListViewAdapter
import com.gigchain.soft.presentation.utilities.setSafeOnClickListener
import kotlinx.coroutines.launch


class CurrentGigsListViewFragment :
    BaseFragment<FragmentCurrentGigsListviewBinding, CurrentGigsViewModel>() {
    private val newGigViewModel: CurrentGigsViewModel by viewModels()
    lateinit var newGigsListViewAdapter: CurrentGigsListViewAdapter

    // Setting up views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setObserver()
        clickEvents()
    }

    // setting up layout id
    override fun getLayoutId(): Int {
        return R.layout.fragment_current_gigs_listview
    }

    // RecyclerView setting up
    private fun setupViews() {
        newGigsListViewAdapter = CurrentGigsListViewAdapter(requireContext(), ArrayList())
        getBinding().recyclerViewGigs.adapter = newGigsListViewAdapter
    }

    // setting up ViewModel instance
    override fun getViewModel(): CurrentGigsViewModel {
        return newGigViewModel
    }

    // setting up ViewModel binding variable
    override fun getBindingVariable(): Int {
        return BR.currentGigsVM
    }

    // getting data from ViewModel and updating RecyclerView
    private fun setObserver() {
        lifecycleScope.launch {
            newGigViewModel.gigsList.collect {
                newGigsListViewAdapter.submitList(it)
            }
        }
    }

    // Handling backpress for fragments and Activity
    @Override
    fun onBackPressed() {
        if (parentFragmentManager.backStackEntryCount > 0) {
            parentFragmentManager.popBackStack()
        } else {
            onBackPressed()
        }
    }

    // BackPress for Fragment
    private fun clickEvents() {
        getBinding().cardView.setSafeOnClickListener {
            onBackPressed()
        }
    }


}