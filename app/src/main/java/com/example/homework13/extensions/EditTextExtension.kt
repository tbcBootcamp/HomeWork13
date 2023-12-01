package com.example.homework13.extensions

import android.app.DatePickerDialog
import android.widget.EditText
import java.util.Calendar

fun EditText.showDatePicker() {
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        this.context,
        { _, year, month, dayOfMonth ->
            val selectedDate = "$year-${month + 1}-$dayOfMonth"
            this.setText(selectedDate)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    datePickerDialog.show()
}