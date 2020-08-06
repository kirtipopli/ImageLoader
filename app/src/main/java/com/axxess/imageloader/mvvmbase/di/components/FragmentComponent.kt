package com.axxess.imageloader.mvvmbase.di.components

import com.axxess.imageloader.mvvmbase.di.FragmentScope
import com.axxess.imageloader.mvvmbase.di.modules.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {


}