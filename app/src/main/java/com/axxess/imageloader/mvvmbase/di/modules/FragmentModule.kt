package com.axxess.imageloader.mvvmbase.di.modules

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.axxess.imageloader.mvvmbase.base.BaseFragment
import com.axxess.imageloader.mvvmbase.base.ViewModelProviderFactory
import com.axxess.imageloader.mvvmbase.rx.SchedulerProvider
import com.axxess.imageloader.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

}