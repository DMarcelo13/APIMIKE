package com.example.apimike.retrofit

import retrofit2.http.GET

interface FoxRetrofit {
    @GET("floof")
    suspend fun get(): FoxNetworkEntity
}