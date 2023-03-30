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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setObserver()
        clickEvents()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_current_gigs_listview
    }

    private fun setupViews() {
        newGigsListViewAdapter = CurrentGigsListViewAdapter(requireContext(), ArrayList())
        getBinding().recyclerViewGigs.adapter = newGigsListViewAdapter
    }

    override fun getViewModel(): CurrentGigsViewModel {
        return newGigViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.currentGigsVM
    }

    private fun setObserver() {
        lifecycleScope.launch {
            newGigViewModel.gigsList.collect {
                newGigsListViewAdapter.submitList(it)
            }
        }
    }

    @Override
    fun onBackPressed() {
        if (parentFragmentManager.backStackEntryCount > 0) {
            parentFragmentManager.popBackStack()
        } else {
            onBackPressed()
        }
    }

    private fun clickEvents() {
        getBinding().cardView.setSafeOnClickListener {
            onBackPressed()
        }
    }


}