package com.axxess.imageloader.features.searchImage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.axxess.imageloader.R
import com.axxess.imageloader.models.Data
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_search_image_details.view.*

class ImagesAdapter(var onImageSelected: (Data, Int) -> Unit) :
    RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_search_image_details,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(image.link).placeholder(R.drawable.ic_action_image)
                .into(img_imageIcon)
            holder.itemView.setOnClickListener {
                onImageSelected(image, position)
            }

        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.link == newItem.link
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}