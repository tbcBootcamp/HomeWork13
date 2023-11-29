package com.example.homework13.Data

data class ItemModel(
    val fieldId: Int,
    val hint: String,
    val fieldType: String,
    val keyboard: String,
    val required: Boolean,
    val isActive: Boolean,
    val icon: String
)
