package com.axxess.imageloader.features.imageDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.axxess.imageloader.R;
import com.axxess.imageloader.databinding.ActivityImageDetailsBinding;
import com.axxess.imageloader.db.ImageDatabase;
import com.axxess.imageloader.db.ImageDatabaseDao;
import com.axxess.imageloader.models.Data;
import com.axxess.imageloader.ui.ImageViewModelFactory;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageDetailsActivity extends AppCompatActivity {

    private Data imageData = null;
    private ActivityImageDetailsBinding mBinding = null;
    private int position = 0;

    private ImageDetailsRepository imageDetailsRepository;
    private ImageDetailsViewModel imageDetailsViewModel;

    @Override
    protected void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_details);

        imageDetailsRepository = new ImageDetailsRepository(new ImageDatabase() {
            @NonNull
            @Override
            protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
                return null;
            }

            @NonNull
            @Override
            protected InvalidationTracker createInvalidationTracker() {
                return null;
            }

            @Override
            public void clearAllTables() {

            }

            @NotNull
            @Override
            public ImageDatabaseDao getImageDao() {
                return null;
            }
        });
        ImageViewModelFactory viewModelFactory = new ImageViewModelFactory(imageDetailsRepository);
        imageDetailsViewModel = new ViewModelProvider(this, viewModelFactory).get(ImageDetailsViewModel.class);

        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent().hasExtra("data")) {
            imageData = (Data) getIntent().getSerializableExtra("data");
            position = getIntent().getIntExtra("position", 0);
            getSupportActionBar().setTitle(imageData.getTitle());
            if (imageData != null) {
                Glide.with(this).load(imageData.getLink()).placeholder(R.drawable.ic_action_image)
                        .into(mBinding.ivImage);
            }
        }

        mBinding.btnSubmit.setOnClickListener(v -> {
            if (mBinding.etCaption.getText().toString().trim().length() > 0) {
                List<Data> data = Collections.singletonList(imageData);
                data.get(0).setDescription(mBinding.etCaption.getText().toString().trim());
                imageDetailsViewModel.setImageCaption(data);
            }
        });
    }

}
