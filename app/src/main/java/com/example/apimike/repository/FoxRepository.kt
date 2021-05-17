package com.example.apimike.repository

import android.util.Log
import com.example.apimike.retrofit.FoxRetrofit
import com.example.apimike.retrofit.NetworkMapper
import com.example.apimike.room.CacheMapper
import com.example.apimike.room.FoxDao
import com.example.apimike.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FoxRepository constructor(
        private val foxDao: FoxDao,
        private val foxRetrofit: FoxRetrofit,
        private val cacheMapper: CacheMapper,
        private val networkMapper: NetworkMapper
) {
    suspend fun getFoxs(): Flow<DataState> = flow {
        emit(DataState.Loading)
        try {
            val foxData = foxRetrofit.get()
            /*val catMap = networkMapper.mapFromEntityList(catData)
            for (tempCat in catMap){
                foxDao.insert(cacheMapper.mapToEntity(tempCat))
            }*/

            val foxMap = networkMapper.mapFromEntity(foxData)
            foxDao.insert(cacheMapper.mapToEntity(foxMap))

            val cacheCat = foxDao.get()
            Log.i("FoxRepository", cacheCat.toString())
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
        }catch (e: Exception){

            Log.i("FoxRepository", "An exception has risen")
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }
}