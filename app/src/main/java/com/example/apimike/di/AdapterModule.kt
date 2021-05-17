package com.example.apimike.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import com.example.apimike.utils.AdapterFoxs
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterFoxs {
        return AdapterFoxs()
    }
}