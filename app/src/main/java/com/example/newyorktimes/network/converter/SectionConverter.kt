package com.example.newyorktimes.network.converter

import androidx.room.TypeConverter
import com.example.newyorktimes.network.response.SectionResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SectionConverter {
    @TypeConverter
    fun stringToObject(data: String?): SectionResponse? {
        if (data == null) {
            return null
        }
        val listType = object : TypeToken<SectionResponse>() {}.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun objectToString(section: SectionResponse?): String {
        return Gson().toJson(section)
    }
}