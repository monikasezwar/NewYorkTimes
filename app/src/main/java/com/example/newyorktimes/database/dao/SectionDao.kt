package com.example.newyorktimes.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newyorktimes.network.response.SectionResponse

@Dao
interface SectionDao {

    @Query("SELECT * FROM section_response")
    fun getAll(): List<SectionResponse>

    @Query("SELECT * FROM section_response WHERE section == :section")
    fun getSectionContentLive(section: String): LiveData<SectionResponse>

    @Insert
    fun insertAll(vararg section: SectionResponse)

    @Delete
    fun delete(section: SectionResponse)
}