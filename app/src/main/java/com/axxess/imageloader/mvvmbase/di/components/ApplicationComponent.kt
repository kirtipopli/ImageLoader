package com.axxess.imageloader.mvvmbase.di.components

import android.app.Application
import android.content.Context
import com.axxess.imageloader.application.ImageLoaderApplication
import com.axxess.imageloader.db.ImageDatabase
import com.axxess.imageloader.mvvmbase.di.ApplicationContext
import com.axxess.imageloader.mvvmbase.di.modules.ApplicationModule
import com.axxess.imageloader.mvvmbase.network.NetworkService
import com.axxess.imageloader.mvvmbase.rx.SchedulerProvider
import com.axxess.imageloader.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: ImageLoaderApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

}