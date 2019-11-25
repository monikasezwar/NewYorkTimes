package com.example.newyorktimes.network.converter

import androidx.room.TypeConverter
import com.example.newyorktimes.network.response.SectionResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MultimediaConverter {
    @TypeConverter
    fun stringToObject(data: String?): List<SectionResponse.SectionResult.Multimedia> {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<SectionResponse.SectionResult.Multimedia>>() {}.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun objectToString(multimedia: List<SectionResponse.SectionResult.Multimedia>): String {
        return Gson().toJson(multimedia)
    }
}