package com.example.homework13.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework13.Data.ItemModel
import com.example.homework13.databinding.RecyclerItemFieldBinding
import com.example.homework13.extensions.Glide

class InnerAdapter(
    private val innerList: List<ItemModel>
) : RecyclerView.Adapter<InnerAdapter.InnerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemFieldBinding.inflate(inflater, parent, false)
        return InnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.bind(innerList[position])
    }

    override fun getItemCount(): Int = innerList.size

    inner class InnerViewHolder(private val binding: RecyclerItemFieldBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel) {
            // Bind data to inner item view
            Log.d("ragaca", "inner adapter on bind")
            binding.etField.hint = item.hint
            Glide().setImage(item.icon, binding.ivIcon)
        }
    }

}