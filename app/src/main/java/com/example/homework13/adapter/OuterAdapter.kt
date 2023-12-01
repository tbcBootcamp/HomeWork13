package com.example.homework13.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework13.data.ItemModel
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
        private lateinit var adapter: InnerAdapter

        fun bind(innerList: List<ItemModel>) {
            adapter = InnerAdapter(innerList)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager = LinearLayoutManager(itemView.context)

        }

        fun getFieldValues(): MutableMap<Int, String> {
            val innerList = adapter.getList()
            val innerFieldMap: MutableMap<Int, String> = mutableMapOf()
            innerList.forEachIndexed { index, fieldItem ->
                val fieldValue = (binding.recyclerview.findViewHolderForAdapterPosition(
                    index
                ) as InnerAdapter.InnerViewHolder).getFieldValue()
                innerFieldMap[fieldItem.fieldId] = fieldValue
            }
            return innerFieldMap
        }
    }

    fun getList() = outerList

}