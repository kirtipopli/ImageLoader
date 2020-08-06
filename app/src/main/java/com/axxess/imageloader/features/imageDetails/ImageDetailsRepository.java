package com.axxess.imageloader.features.imageDetails;

import android.util.Log;

import com.axxess.imageloader.db.ImageDatabase;
import com.axxess.imageloader.models.Data;

import java.util.List;

public class ImageDetailsRepository {

    private ImageDatabase mImageDatabase;

    public ImageDetailsRepository(ImageDatabase imageDatabase) {
        mImageDatabase = imageDatabase;
    }

    public void setCaptionForImage(List<Data> data) {
        if (mImageDatabase != null)
            mImageDatabase.getImageDao().upsert(data);
        else
            Log.d("ImageRepo", "database was null");
    }
}
