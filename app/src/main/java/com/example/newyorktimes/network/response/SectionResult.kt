package com.example.newyorktimes.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.newyorktimes.network.converter.MultimediaConverter


@Entity(tableName = "result")
data class SectionResult(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val `abstract`: String,
    val byline: String,
    val created_date: String,
    val des_facet: List<String>,
    val geo_facet: List<Any>,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    @TypeConverters(MultimediaConverter::class)
    val multimedia: List<Multimedia>,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String,
    val section: String,
    val short_url: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val url: String
)