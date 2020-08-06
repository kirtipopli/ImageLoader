package com.axxess.imageloader.mvvmbase.network

import com.axxess.imageloader.models.ImageDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("gallery/search/1")
    suspend fun getSearchedImage(
        @Query("q") searchQuery: String
    ): Response<ImageDataResponse>

}