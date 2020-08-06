package com.axxess.imageloader.utils

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NetworkUtils(
    val status: Int = -1,
    @Expose
    @SerializedName("statusCode")
    val statusCode: String = "-1",
    @Expose
    @SerializedName("message")
    val message: String = "Something went wrong"
)