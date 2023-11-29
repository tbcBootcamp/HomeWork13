package com.example.homework13.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework13.Data.ItemModel
import com.example.homework13.R
import com.example.homework13.databinding.RecyclerItemFieldBinding

//class FieldAdapter(private val fields: List<List<ItemModel>>) :
//    RecyclerView.Adapter<FieldAdapter.FieldViewHolder>() {
//
//    inner class FieldViewHolder(private val binding: RecyclerItemFieldBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(field: ItemModel) {
//            binding.etField.hint = field.hint
//            binding.ivIcon.setImageResource(R.drawable.ic_launcher_foreground)
//
//
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = RecyclerItemFieldBinding.inflate(inflater, parent, false)
//        return FieldViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: FieldViewHolder, position: Int) {
//        val fieldList = fields[position]
//        fieldList.forEach { field ->
//            holder.bind(field)
//        }
//    }
//
//    override fun getItemCount(): Int = fields.size
//}