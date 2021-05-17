package com.example.apimike.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoxDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(FoxEntity: FoxCacheEntity): Long
    @Query("select * from zorrito")
    suspend fun get(): List<FoxCacheEntity>
}