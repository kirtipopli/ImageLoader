package com.axxess.imageloader.features.searchImage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.axxess.imageloader.models.ImageDataResponse
import com.axxess.imageloader.mvvmbase.base.BaseViewModel
import com.axxess.imageloader.mvvmbase.callback.Resource
import com.axxess.imageloader.mvvmbase.rx.SchedulerProvider
import com.axxess.imageloader.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response


class SearchImageViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val searchImageRepository: SearchImageRepository
) : BaseViewModel(
    schedulerProvider, compositeDisposable, networkHelper
) {

    var searchedImagesLD: MutableLiveData<Resource<ImageDataResponse>> = MutableLiveData()

    override fun onCreate() {}


    fun searchImageWithKeyword(keyword: String) = viewModelScope.launch {
        searchedImagesLD.postValue(Resource.loading())
        val response = searchImageRepository.getSearchedImage(keyword)
        searchedImagesLD.postValue(handleSearchImageResponse(response))
    }

    private fun handleSearchImageResponse(response: Response<ImageDataResponse>): Resource<ImageDataResponse> {
        if (response.isSuccessful) {
            response.body().let { resultResponse ->
                return Resource.success(resultResponse)
            }
        }
        return Resource.error(response.body())
    }

}