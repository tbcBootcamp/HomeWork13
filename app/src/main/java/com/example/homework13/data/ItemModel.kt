package com.example.homework13.data

import com.google.gson.annotations.SerializedName

data class ItemModel(
    @SerializedName("field_id")
    val fieldId: Int,
    val hint: String,
    @SerializedName("field_type")
    val fieldType: String,
    val keyboard: String,
    val required: Boolean,
    @SerializedName("is_active")
    val isActive: Boolean,
    val icon: String
)