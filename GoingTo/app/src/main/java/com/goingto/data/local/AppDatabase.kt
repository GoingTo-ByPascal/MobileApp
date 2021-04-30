package com.goingto.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.goingto.data.entities.Country

@Database(entities = [Country::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if(INSTANCE == null){
                INSTANCE =
                    Room.databaseBuilder(context, AppDatabase::class.java,"goingto.db").build()
            }
            return INSTANCE as AppDatabase
        }
    }
}