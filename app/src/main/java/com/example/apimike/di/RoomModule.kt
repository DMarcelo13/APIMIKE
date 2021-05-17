package com.example.apimike.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.apimike.room.FoxDao
import com.example.apimike.room.FoxDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideFoxDb(@ApplicationContext context: Context): FoxDatabase {
        return Room
            .databaseBuilder(context, FoxDatabase::class.java, FoxDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideFoxDao(foxDatabase: FoxDatabase): FoxDao {
        return foxDatabase.foxDao()
    }
}