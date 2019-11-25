package com.example.newyorktimes.network.converter

import androidx.room.TypeConverter
import com.example.newyorktimes.network.response.SectionResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SectionResultConverter {
    @TypeConverter
    fun stringToObject(data: String?): List<SectionResponse.SectionResult> {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<SectionResponse.SectionResult>>() {}.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun objectToString(result: List<SectionResponse.SectionResult>): String {
        return Gson().toJson(result)
    }
}