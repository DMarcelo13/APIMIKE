package com.example.apimike.intent

sealed class Intent {
    object GetFoxEvent: Intent()
    object None: Intent()
}