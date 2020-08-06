package com.axxess.imageloader.features.imageDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.axxess.imageloader.models.Data;

import java.util.List;

public class ImageDetailsViewModel extends ViewModel {

    private ImageDetailsRepository mImageDetailsRepository;

    private MutableLiveData<Boolean> success = new MutableLiveData();

    public ImageDetailsViewModel(ImageDetailsRepository imageDetailsRepository) {
        mImageDetailsRepository = imageDetailsRepository;
    }

    public void setImageCaption(List<Data> data) {
        mImageDetailsRepository.setCaptionForImage(data);
    }
}
