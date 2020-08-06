package com.axxess.imageloader.mvvmbase.di.components

import com.axxess.imageloader.features.imageDetails.ImageDetailsActivity
import com.axxess.imageloader.features.searchImage.SearchImagesActivity
import com.axxess.imageloader.mvvmbase.di.ActivityScope
import com.axxess.imageloader.mvvmbase.di.modules.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(newsFeedActivity: SearchImagesActivity)
    fun inject(imageDetailsActivity: ImageDetailsActivity)

}