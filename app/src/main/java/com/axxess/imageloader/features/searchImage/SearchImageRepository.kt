package com.axxess.imageloader.features.searchImage

import com.axxess.imageloader.models.ImageDataResponse
import com.axxess.imageloader.mvvmbase.network.NetworkService
import retrofit2.Response
import javax.inject.Inject

class SearchImageRepository @Inject constructor(
    private val networkService: NetworkService
) {

    suspend fun getSearchedImage(searchedKeyWord: String): Response<ImageDataResponse> {
        return networkService.getSearchedImage(searchedKeyWord)
    }
}