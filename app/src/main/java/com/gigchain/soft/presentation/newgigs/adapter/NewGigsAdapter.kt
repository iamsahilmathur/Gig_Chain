package com.gigchain.soft.presentation.newgigs.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gigchain.soft.R
import com.gigchain.soft.databinding.ItemNewGigsBinding
import com.gigchain.soft.domain.models.NewGigsModel

class NewGigsAdapter(var context: Context) :
    RecyclerView.Adapter<NewGigsAdapter.QuestionOptionsRowViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): QuestionOptionsRowViewHolder {
        val binding = DataBindingUtil.inflate<ItemNewGigsBinding>(
            LayoutInflater.from(parent.context), R.layout.item_new_gigs, parent, false
        )
        return QuestionOptionsRowViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: QuestionOptionsRowViewHolder, position: Int) {
//        holder.bind(optionsArrayList[position])
    }

    override fun getItemCount(): Int {
        return 10
    }

    class QuestionOptionsRowViewHolder(private val itemBinding: ItemNewGigsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: NewGigsModel) {
            //  itemBinding.options.text = item.name
        }
    }
}