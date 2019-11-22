package com.example.newyorktimes.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "multimedia")
data class Multimedia(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val caption: String,
    val copyright: String,
    val format: String,
    val height: Int,
    val subtype: String,
    val type: String,
    val url: String,
    val width: Int
)