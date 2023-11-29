package com.example.homework13.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework13.Data.ItemModel
import com.example.homework13.databinding.OuterItemBinding

class OuterAdapter(
    private val outerList: List<List<ItemModel>>
) : RecyclerView.Adapter<OuterAdapter.OuterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = OuterItemBinding.inflate(inflater, parent, false)
        return OuterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        holder.bind(outerList[position])
    }

    override fun getItemCount(): Int = outerList.size

    inner class OuterViewHolder(private val binding: OuterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(innerList: List<ItemModel>) {
            binding.recyclerview.adapter = InnerAdapter(innerList)

            Log.d("ragaca", "outer adapter on bind")
            // Set layout manager for inner RecyclerView (linear, grid, etc.)
            binding.recyclerview.layoutManager = LinearLayoutManager(itemView.context)
        }
    }

}