package com.gigchain.soft.presentation.newgigs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.gigchain.soft.BR
import com.gigchain.soft.R
import com.gigchain.soft.databinding.FragmentNewGigsListviewBinding
import com.gigchain.soft.presentation.baseviews.BaseFragment
import com.gigchain.soft.presentation.newgigs.adapter.NewGigsListViewAdapter
import com.gigchain.soft.presentation.utilities.setSafeOnClickListener
import kotlinx.coroutines.launch


class NewGigsListViewFragment : BaseFragment<FragmentNewGigsListviewBinding, NewGigsViewModel>() {
    private val newGigViewModel: NewGigsViewModel by viewModels()
    lateinit var newGigsListViewAdapter: NewGigsListViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setObserver()
        clickEvents()
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_new_gigs_listview
    }


    private fun setupViews() {
        newGigsListViewAdapter = NewGigsListViewAdapter(requireContext(), ArrayList())
        getBinding().recyclerViewGigs.adapter = newGigsListViewAdapter
    }

    override fun getViewModel(): NewGigsViewModel {
        return newGigViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.newGigsVM
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