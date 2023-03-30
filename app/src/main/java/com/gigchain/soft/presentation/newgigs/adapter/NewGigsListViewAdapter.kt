package com.gigchain.soft.presentation.newgigs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gigchain.soft.R
import com.gigchain.soft.databinding.ItemNewGigsListViewBinding
import com.gigchain.soft.domain.models.NewGigsModel

class NewGigsListViewAdapter(var context: Context, var gigsList: ArrayList<NewGigsModel>) :
    RecyclerView.Adapter<NewGigsListViewAdapter.NewGigsListViewRowViewHolder>() {

    // setting up views
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): NewGigsListViewRowViewHolder {
        val binding = DataBindingUtil.inflate<ItemNewGigsListViewBinding>(
            LayoutInflater.from(parent.context), R.layout.item_new_gigs_list_view, parent, false
        )
        return NewGigsListViewRowViewHolder(binding)
    }

    // binding data with views
    override fun onBindViewHolder(holder: NewGigsListViewRowViewHolder, position: Int) {
        holder.bind(gigsList[position])
    }

    // item counts
    override fun getItemCount(): Int {
        return gigsList.size
    }

    // updating list and recyclerview
    fun submitList(it: List<NewGigsModel>) {
        gigsList.clear()
        gigsList.addAll(it)
        notifyDataSetChanged()
    }

    // ViewHolder class
    class NewGigsListViewRowViewHolder(private val itemBinding: ItemNewGigsListViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: NewGigsModel) {
            item.logo?.let { itemBinding.imageLogo.setImageResource(it) }
            itemBinding.textViewTitle.text = item.name
            itemBinding.textViewLocation.text = item.address

        }
    }
}