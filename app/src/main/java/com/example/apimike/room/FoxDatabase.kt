package com.example.apimike.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FoxCacheEntity::class], version = 1)
abstract class FoxDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "FoxDB"
    }
    abstract fun foxDao(): FoxDao
}