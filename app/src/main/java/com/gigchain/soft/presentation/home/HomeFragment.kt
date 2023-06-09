package com.gigchain.soft.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.gigchain.soft.BR
import com.gigchain.soft.R
import com.gigchain.soft.databinding.FragmentHomeBinding
import com.gigchain.soft.presentation.baseviews.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), View.OnClickListener {

    private val homeViewModel: HomeViewModel by viewModels()

    // View is setting up
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBinding().goImg.setOnClickListener(this)
        getBinding().stopCL.setOnClickListener(this)
    }

    // setting up Layout Id
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    // setting up ViewModel instance
    override fun getViewModel(): HomeViewModel {
        return homeViewModel
    }

    // setting up binding variable
    override fun getBindingVariable(): Int {
        return BR.homeViewModel
    }

    // Click events
    override fun onClick(p0: View?) {
        getBinding().apply {
            when (p0) {
                goImg -> {
                    goCL.visibility = View.GONE
                    pStopCL.visibility = View.VISIBLE
                }
                stopCL -> {
                    goCL.visibility = View.VISIBLE
                    pStopCL.visibility = View.GONE
                }
            }
        }

    }


}