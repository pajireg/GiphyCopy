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
import com.sumin.giphycopy.adapters.TrendingAdapter
import com.sumin.giphycopy.adapters.UserAdapter
import com.sumin.giphycopy.data.Data
import com.sumin.giphycopy.data.entity.FavoriteEntity


@BindingAdapter("listTrending")
fun bindTrendingRecyclerView(recyclerView: RecyclerView, data: List<Data>?) {
    val adapter = recyclerView.adapter as TrendingAdapter
    adapter.submitList(data)
}
@BindingAdapter("previewGif")
fun bindPreviewGif(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context)
            .load(imageUrl)
            .transform(CenterCrop(), RoundedCorners(2))
            .override(SIZE_ORIGINAL, SIZE_ORIGINAL)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}
@BindingAdapter("dataId")
fun TextView.setDataId(item: Data) {
    text = item.id
}
@BindingAdapter("showImage")
fun bindShowImage(view: ImageView, data: Data?) {
    data?.images?.original?.url.let {
        Glide.with(view.context)
            .load(it)
            .into(view)
    }
}
@BindingAdapter("showUser")
fun bindShowUser(view: ImageView, data: Data?) {
    data?.user?.avatarUrl.let {
        Glide.with(view.context)
            .load(it)
            .into(view)
    }
}
@BindingAdapter("showDisplayName")
fun TextView.setDisplayName(data: Data?) {
    text = data?.user?.displayName
}
@BindingAdapter("showUsername")
fun TextView.setUsername(data: Data?) {
    text = data?.user?.username
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
            .transform(CenterCrop(), RoundedCorners(2))
            .override(SIZE_ORIGINAL, SIZE_ORIGINAL)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}