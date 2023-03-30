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

    // setting up views
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setObserver()
        clickEvents()
    }

    // setting up Layout Id
    override fun getLayoutId(): Int {
        return R.layout.fragment_new_gigs_listview
    }

    // Setting up views
    private fun setupViews() {
        newGigsListViewAdapter = NewGigsListViewAdapter(requireContext(), ArrayList())
        getBinding().recyclerViewGigs.adapter = newGigsListViewAdapter
    }

    // setting up ViewModel instance
    override fun getViewModel(): NewGigsViewModel {
        return newGigViewModel
    }

    // setting up binding variable
    override fun getBindingVariable(): Int {
        return BR.newGigsVM
    }

    // updating RecyclerView using data
    private fun setObserver() {
        lifecycleScope.launch {
            newGigViewModel.gigsList.collect {
                newGigsListViewAdapter.submitList(it)
            }
        }
    }

    // BackPress handling
    @Override
    fun onBackPressed() {
        if (parentFragmentManager.backStackEntryCount > 0) {
            parentFragmentManager.popBackStack()
        } else {
            onBackPressed()
        }
    }

    // BackPress click event
    private fun clickEvents() {
        getBinding().cardView.setSafeOnClickListener {
            onBackPressed()
        }
    }


}