package com.example.apimike.di

import com.example.apimike.repository.FoxRepository
import com.example.apimike.retrofit.FoxRetrofit
import com.example.apimike.retrofit.NetworkMapper
import com.example.apimike.room.CacheMapper
import com.example.apimike.room.FoxDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFoxRepository(
        foxDao: FoxDao,
        foxRetrofit: FoxRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): FoxRepository {
        return FoxRepository(foxDao, foxRetrofit, cacheMapper, networkMapper)
    }
}