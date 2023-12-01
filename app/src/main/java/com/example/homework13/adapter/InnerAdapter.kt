package com.example.homework13.adapter

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework13.data.FieldInputType
import com.example.homework13.data.FieldType
import com.example.homework13.data.ItemModel
import com.example.homework13.databinding.RecyclerItemFieldBinding
import com.example.homework13.extensions.setImage
import com.example.homework13.extensions.showDatePicker

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
        private var isRequired: Boolean? = null
        fun bind(item: ItemModel) {
            isRequired = item.required
            binding.etField.hint = item.hint
            binding.ivIcon.setImage(item.icon)
            binding.ivIcon.setOnClickListener {
                if (item.fieldType == FieldType.chooser.name) {
                    binding.etField.showDatePicker()
                }
            }
            // Set inputType based on keyboard property
            binding.etField.inputType = getInputType(item.keyboard)
        }

        fun getFieldValue(): String {
            binding.etField.text.let {
                return if (it.isNullOrEmpty() && isRequired == true) {
                    binding.etField.hint.toString() + " should not be empty"
                } else {
                    it.toString()
                }
            }
        }
    }

    fun getList() = innerList

    private fun getInputType(keyboard: String?): Int {
        return when (keyboard) {
            FieldInputType.text.name -> InputType.TYPE_CLASS_TEXT
            FieldInputType.number.name -> InputType.TYPE_CLASS_NUMBER
            else -> InputType.TYPE_CLASS_TEXT
        }
    }
}