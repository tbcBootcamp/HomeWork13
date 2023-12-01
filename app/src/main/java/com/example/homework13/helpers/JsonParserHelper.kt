package com.example.homework13.helpers

import android.content.Context
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.lang.reflect.Type

inline fun <reified T> parseJsonFromAssets(jsonFileName: String, context: Context): T {
    val jsonString = context.assets.open(jsonFileName).bufferedReader().use {
        it.readText()
    }
    val gson = Gson()
    val type: Type = object : TypeToken<T>() {}.type
    return gson.fromJson(jsonString, type)
}