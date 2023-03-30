package com.gigchain.soft.presentation.currentgigs

import androidx.lifecycle.ViewModel
import com.gigchain.soft.R
import com.gigchain.soft.domain.models.NewGigsModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CurrentGigsViewModel : ViewModel() {
    private val _gigsList = MutableStateFlow<List<NewGigsModel>>(listOf())
    val gigsList: StateFlow<List<NewGigsModel>>
        get() = _gigsList

    init {
        fetchGigsList()
    }

    private fun fetchGigsList() {
        val gig = NewGigsModel("Shop Onboarding", R.drawable.new_gigs_bg, "Nehru Place", "#4B48E1")
        val gig2 =
            NewGigsModel("Merchant Onboarding", R.drawable.image_gig_two, "Nehru Place", "#694AEE")
        val gig3 =
            NewGigsModel("Shop Auditing", R.drawable.image_gig_three, "Nehru Place", "#44A6D1")
        val arrayList = ArrayList<NewGigsModel>()
        arrayList.add(gig)
        arrayList.add(gig2)
        arrayList.add(gig3)
        _gigsList.value = arrayList
    }
}