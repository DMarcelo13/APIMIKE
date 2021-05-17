package com.example.apimike.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FoxNetworkEntity(

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("link")
    @Expose
    var link: String,


)