package com.example.newyorktimes.database

import android.content.Context
import androidx.room.RoomDatabase
import com.example.newyorktimes.database.dao.SectionDao
import androidx.room.Room
import androidx.room.Database
import androidx.room.TypeConverters
import com.example.newyorktimes.network.converter.MultimediaConverter
import com.example.newyorktimes.network.converter.SectionResultConverter
import com.example.newyorktimes.network.response.Multimedia
import com.example.newyorktimes.network.response.SectionResponse
import com.example.newyorktimes.network.response.SectionResult


@Database(entities = [SectionResponse::class, SectionResult::class,Multimedia::class], version = 1, exportSchema = false)

@TypeConverters(SectionResultConverter::class,MultimediaConverter::class)

abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun sectionDao(): SectionDao

    companion object {

        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "newyorktimes-database"
                ).build()
            }
            return INSTANCE as AppRoomDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}