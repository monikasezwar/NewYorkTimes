package com.example.newyorktimes.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.newyorktimes.network.converter.SectionResultConverter

@Entity(tableName = "section_response")
data class SectionResponse(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    @TypeConverters(SectionResultConverter::class)
    val results: List<SectionResult>,
    val section: String,
    val status: String
)