package com.sumin.giphycopy.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModel(
    val id: String,
    val type: String?,
    val url: String,
    val username: String,
    val title: String,
    val rating: String,
    val importDatetime: String,
    val trendingDatetime: String,
    val imageOriginalUrl: String,
    val imageDownsizedUrl: String,
    var isFavorite: Boolean?
) : Parcelable