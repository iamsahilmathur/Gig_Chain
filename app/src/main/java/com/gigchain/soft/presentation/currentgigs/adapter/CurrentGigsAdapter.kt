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

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CurrentGigsRowViewHolder, position: Int) {
//        holder.bind(optionsArrayList[position])
    }

    override fun getItemCount(): Int {
        return 10
    }

    class CurrentGigsRowViewHolder(private val itemBinding: ItemCurrentGigsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: NewGigsModel) {
            //  itemBinding.options.text = item.name
        }
    }
}