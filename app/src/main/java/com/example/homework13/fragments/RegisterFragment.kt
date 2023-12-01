package com.example.homework13.fragments


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework13.adapter.OuterAdapter
import com.example.homework13.data.ItemModel
import com.example.homework13.databinding.FragmentRegisterBinding
import com.example.homework13.helpers.parseJsonFromAssets


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val fieldList: List<List<ItemModel>> by lazy {
        parseJsonFromAssets("List.json", requireContext())
    }
    private lateinit var adapter: OuterAdapter

    override fun setUp() {
        adapter = OuterAdapter(fieldList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.btnRegister.setOnClickListener {
            register()
        }

    }

    private fun register() {
        val fieldValuesFinal: MutableList<MutableMap<Int, String>> = mutableListOf()
        adapter.getList().forEachIndexed { index, innerList ->
            val fieldValues = (binding.recyclerview.findViewHolderForAdapterPosition(
                index
            ) as OuterAdapter.OuterViewHolder).getFieldValues()
            fieldValuesFinal.add(fieldValues)
        }
        binding.tvResultList.text = fieldValuesFinal.toString()
    }
}

