package com.sumin.giphycopy.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.sumin.giphycopy.R
import com.sumin.giphycopy.adapters.TrendingAdapter
import com.sumin.giphycopy.adapters.UserAdapter
import com.sumin.giphycopy.data.Data
import com.sumin.giphycopy.data.DataModel
import com.sumin.giphycopy.data.entity.FavoriteEntity


@BindingAdapter("listTrending")
fun bindTrendingRecyclerView(recyclerView: RecyclerView, data: List<DataModel>?) {
    val adapter = recyclerView.adapter as TrendingAdapter
    adapter.submitList(data)
}
@BindingAdapter("previewGif")
fun bindPreviewGif(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context)
            .load(imageUrl)
            .override(SIZE_ORIGINAL, SIZE_ORIGINAL)
            .into(view)
    }
}
@BindingAdapter("isFavorite")
fun ImageView.isFavorite(isFavorite: Boolean) {
    setImageResource(when (isFavorite) {
        false -> R.drawable.ic_outline_thumb_up_48
        true -> R.drawable.ic_baseline_thumb_up_48
    })
}

@BindingAdapter("listFavorite")
fun bindFavoriteRecyclerView(recyclerView: RecyclerView, data: List<FavoriteEntity>?) {
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(data)
}
@BindingAdapter("favoritePreview")
fun bindFavoritePreview(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context)
            .load(imageUrl)
            .override(SIZE_ORIGINAL, SIZE_ORIGINAL)
            .into(view)
    }
}