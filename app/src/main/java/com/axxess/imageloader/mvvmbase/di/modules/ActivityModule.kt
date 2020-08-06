package com.axxess.imageloader.mvvmbase.di.modules

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.axxess.imageloader.features.imageDetails.ImageDetailsRepository
import com.axxess.imageloader.features.imageDetails.ImageDetailsViewModel
import com.axxess.imageloader.features.searchImage.SearchImageRepository
import com.axxess.imageloader.features.searchImage.SearchImageViewModel
import com.axxess.imageloader.mvvmbase.base.BaseActivity
import com.axxess.imageloader.mvvmbase.base.ViewModelProviderFactory
import com.axxess.imageloader.mvvmbase.rx.SchedulerProvider
import com.axxess.imageloader.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSearchImageViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper, searchImageRepository: SearchImageRepository
    ): SearchImageViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SearchImageViewModel::class) {
            SearchImageViewModel(
                schedulerProvider,
                compositeDisposable,
                networkHelper,
                searchImageRepository
            )
        }).get(SearchImageViewModel::class.java)

    @Provides
    fun provideImageDetailsViewModel(
        imageDetailsRepository: ImageDetailsRepository
    ): ImageDetailsViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(ImageDetailsViewModel::class) {
            ImageDetailsViewModel(
                imageDetailsRepository
            )
        }).get(ImageDetailsViewModel::class.java)

}