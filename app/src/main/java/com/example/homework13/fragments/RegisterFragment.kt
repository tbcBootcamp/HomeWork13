package com.example.homework13.fragments


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework13.Data.FieldList
import com.example.homework13.adapter.OuterAdapter
import com.example.homework13.databinding.FragmentRegisterBinding


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val fieldList = FieldList().getFieldList()
    private val fieldMap: MutableMap<Int, String> = mutableMapOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = OuterAdapter(fieldList)
        Log.d("ragaca", "register fragment created")

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        binding.btnRegister.setOnClickListener {
            handleRegistration()
        }
    }

    private fun handleRegistration() {

        var validationFailed = false


        for (innerList in fieldList) {

            for (item in innerList) {

                val etValue = binding.recyclerview.findViewHolderForAdapterPosition(
                    fieldList.indexOf(innerList))?.itemView
                    ?.findViewById<EditText>(item.fieldId)?.text.toString()

                if (!checkValidation(etValue, item.required, item.hint)) {

                    validationFailed = true

                    // Show an error message for the specific field
                    Toast.makeText(
                        requireContext(),
                        "Field with hint: ${item.hint} is empty!!",
                        Toast.LENGTH_LONG
                    ).show()
                    break // Stop the inner loop if any field is not valid
                }


                fieldMap[item.fieldId] = etValue
            }

            if (validationFailed) {
                break
            }
        }


        if (!validationFailed) {

            Toast.makeText(
                requireContext(),
                "Registration successful!",
                Toast.LENGTH_LONG
            ).show()


        }
    }
    private fun checkValidation(text: String?, isRequired: Boolean, hint: String) =
        !(text.isNullOrEmpty() && isRequired).also {
            if (!it) {
                Toast.makeText(
                    requireContext(),
                    "Field with hint: $hint is empty!!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
}

