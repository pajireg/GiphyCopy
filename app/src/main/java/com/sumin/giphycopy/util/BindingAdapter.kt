package com.sumin.giphycopy.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sumin.giphycopy.adapters.TrendingAdapter
import com.sumin.giphycopy.api.Data

@BindingAdapter("listTrending")
fun bindTrendingRecyclerView(recyclerView: RecyclerView, data: List<Data>?) {
    val adapter = recyclerView.adapter as TrendingAdapter
    adapter.submitList(data)
}
@BindingAdapter("previewGif")
fun bindPreviewGif(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}
@BindingAdapter("dataId")
fun TextView.setDataId(item: Data) {
    text = item.id
}