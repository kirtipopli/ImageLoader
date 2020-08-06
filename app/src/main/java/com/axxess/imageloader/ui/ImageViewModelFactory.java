package com.axxess.imageloader.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.axxess.imageloader.features.imageDetails.ImageDetailsRepository;
import com.axxess.imageloader.features.imageDetails.ImageDetailsViewModel;

public class ImageViewModelFactory implements ViewModelProvider.Factory {

    private ImageDetailsRepository mImageDetailsRepository;

    public ImageViewModelFactory(ImageDetailsRepository imageDetailsRepository) {
        mImageDetailsRepository = imageDetailsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ImageDetailsViewModel(mImageDetailsRepository);
    }
}
