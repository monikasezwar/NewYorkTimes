package com.example.newyorktimes.network.converter

import androidx.room.TypeConverter
import com.example.newyorktimes.network.response.Multimedia
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MultimediaConverter {
    @TypeConverter
    fun stringToObject(data: String?): Multimedia? {
        if (data == null) {
            return null
        }
        val listType = object : TypeToken<Multimedia>() {}.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun objectToString(multimedia: Multimedia?): String {
        return Gson().toJson(multimedia)
    }
}