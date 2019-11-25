package com.example.newyorktimes.network.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.newyorktimes.network.converter.MultimediaConverter
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
){
    data class SectionResult(
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
    ){
        data class Multimedia(
            val caption: String,
            val copyright: String,
            val format: String,
            val height: Int,
            val subtype: String,
            val type: String,
            val url: String,
            val width: Int
        )
    }
}