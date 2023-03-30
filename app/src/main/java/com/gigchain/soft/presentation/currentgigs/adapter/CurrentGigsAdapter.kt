package com.gigchain.soft.presentation.currentgigs.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gigchain.soft.R
import com.gigchain.soft.databinding.ItemCurrentGigsBinding
import com.gigchain.soft.domain.models.NewGigsModel

class CurrentGigsAdapter(var context: Context) :
    RecyclerView.Adapter<CurrentGigsAdapter.CurrentGigsRowViewHolder>() {

    // Creating views
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrentGigsRowViewHolder {
        val binding = DataBindingUtil.inflate<ItemCurrentGigsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_current_gigs, parent, false
        )
        return CurrentGigsRowViewHolder(binding)
    }

    // Bind data with View
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CurrentGigsRowViewHolder, position: Int) {
    }

    // Item count
    override fun getItemCount(): Int {
        return 10
    }

    // ViewHolder class
    class CurrentGigsRowViewHolder(private val itemBinding: ItemCurrentGigsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }
}