package com.example.apimike.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "zorrito")
class FoxCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "link")
    var link: String,

)