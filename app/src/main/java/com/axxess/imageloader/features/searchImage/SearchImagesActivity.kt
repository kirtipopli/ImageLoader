package com.axxess.imageloader.features.searchImage

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.axxess.imageloader.R
import com.axxess.imageloader.features.imageDetails.ImageDetailsActivity
import com.axxess.imageloader.models.Data
import com.axxess.imageloader.mvvmbase.base.BaseActivity
import com.axxess.imageloader.mvvmbase.di.components.ActivityComponent
import com.axxess.imageloader.utils.AppConstants
import com.axxess.imageloader.utils.AppPreferencesHelper
import com.axxess.imageloader.utils.Toaster
import kotlinx.android.synthetic.main.activity_main.*

class SearchImagesActivity : BaseActivity<SearchImageViewModel>() {

    lateinit var imagesAdapter: ImagesAdapter
    private var searchKeyWord: String = ""

    override fun provideLayoutId(): Int =
        R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(view: View) {

    }

    override fun setupView(savedInstanceState: Bundle?) {
        AppPreferencesHelper.getInstance(this).storeToken(AppConstants.Credentials.TOKEN)

        if (searchKeyWord.isEmpty()) {
            tv_gallery_error.text = "No images searched yet!"
            progress_gallery.visibility = View.GONE
        }

        img_searchIcon.setOnClickListener {
            if (searchKeyWord.isNotEmpty()) {
                progress_gallery.visibility = View.VISIBLE
                tv_gallery_error.visibility = View.GONE
                hideKeyboard(this)
                viewModel.searchImageWithKeyword(searchKeyWord)
            } else {
                Toaster.show(this@SearchImagesActivity, "Please enter text to search!")
            }
        }

        setRecyclerViewAdapter()

        et_search_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().trim().isNotEmpty()) {
                    searchKeyWord = s.toString().trim()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > 0) {
                    rv_imagesList.visibility = View.GONE
                }
            }
        })
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.searchedImagesLD.observe(this, Observer {
            it?.data?.let { resp ->
                progress_gallery.visibility = View.GONE
                tv_gallery_error.visibility = View.GONE
                rv_imagesList.visibility = View.VISIBLE
                imagesAdapter.differ.submitList(resp.data)
            }
        })
    }

    private fun setRecyclerViewAdapter() {
        imagesAdapter = ImagesAdapter(::onImageSelected)
        rv_imagesList.apply {
            rv_imagesList.visibility = View.GONE
            adapter = imagesAdapter
            layoutManager = GridLayoutManager(this@SearchImagesActivity, 4)
        }
    }

    private fun onImageSelected(data: Data, position: Int) {
        startActivity(
            Intent(this@SearchImagesActivity, ImageDetailsActivity::class.java)
                .putExtra("data", data)
                .putExtra("position", position)
        )
    }
}
