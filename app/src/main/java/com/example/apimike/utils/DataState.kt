package com.example.apimike.utils

import com.example.apimike.model.Fox

sealed class DataState {
    object Idle: DataState()
    data class Success(val foxs: List<Fox>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()
}