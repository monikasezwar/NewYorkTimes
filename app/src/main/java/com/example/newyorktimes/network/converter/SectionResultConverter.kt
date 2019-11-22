package com.example.newyorktimes.network.converter

import androidx.room.TypeConverter
import com.example.newyorktimes.network.response.SectionResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SectionResultConverter {
    @TypeConverter
    fun stringToObject(data: String?): SectionResult? {
        if (data == null) {
            return null
        }
        val listType = object : TypeToken<SectionResult>() {}.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun objectToString(result: SectionResult?): String {
        return Gson().toJson(result)
    }
}