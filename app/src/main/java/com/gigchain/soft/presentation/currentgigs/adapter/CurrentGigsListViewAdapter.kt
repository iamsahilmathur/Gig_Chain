package com.gigchain.soft.presentation.currentgigs.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gigchain.soft.R
import com.gigchain.soft.databinding.ItemCurrentGigsListViewBinding
import com.gigchain.soft.domain.models.NewGigsModel

class CurrentGigsListViewAdapter(var context: Context, var gigsList: ArrayList<NewGigsModel>) :
    RecyclerView.Adapter<CurrentGigsListViewAdapter.CurrentGigsListViewRowViewHolder>() {

    // Creating views
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrentGigsListViewRowViewHolder {
        val binding = DataBindingUtil.inflate<ItemCurrentGigsListViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_current_gigs_list_view, parent, false
        )
        return CurrentGigsListViewRowViewHolder(binding)
    }

    // Bind data with View
    override fun onBindViewHolder(holder: CurrentGigsListViewRowViewHolder, position: Int) {
        holder.bind(gigsList[position])
    }

    // Item count
    override fun getItemCount(): Int {
        return gigsList.size
    }

    // Add data to list and update RecyclerView
    fun submitList(it: List<NewGigsModel>) {
        gigsList.clear()
        gigsList.addAll(it)
        notifyDataSetChanged()
    }


    // ViewHolder class
    class CurrentGigsListViewRowViewHolder(private val itemBinding: ItemCurrentGigsListViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: NewGigsModel) {
            item.logo?.let { itemBinding.imageLogo.setImageResource(it) }
            itemBinding.textViewTitle.text = item.name
            itemBinding.textViewLocation.text = item.address
            itemBinding.linearLayoutIcon.setBackgroundColor(Color.parseColor(item.color))
        }
    }
}