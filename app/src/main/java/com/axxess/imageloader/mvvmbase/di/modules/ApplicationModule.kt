package com.axxess.imageloader.mvvmbase.di.modules

import android.app.Application
import android.content.Context
import com.axxess.imageloader.BuildConfig
import com.axxess.imageloader.application.ImageLoaderApplication
import com.axxess.imageloader.db.ImageDatabase
import com.axxess.imageloader.mvvmbase.di.ApplicationContext
import com.axxess.imageloader.mvvmbase.network.NetworkService
import com.axxess.imageloader.mvvmbase.network.Networking
import com.axxess.imageloader.mvvmbase.rx.RxSchedulerProvider
import com.axxess.imageloader.mvvmbase.rx.SchedulerProvider
import com.axxess.imageloader.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: ImageLoaderApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            "",
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024,//10mb
            application
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

}