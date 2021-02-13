package com.sumin.giphycopy.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Images(
    @SerializedName("original") val original: Original,
    @SerializedName("downsized") val downsized: Downsized
) : Parcelable
@Parcelize
data class Original(
    @SerializedName("height") val height: String,
    @SerializedName("width") val width: String,
    @SerializedName("size") val size: String,
    @SerializedName("url") val url: String,
    @SerializedName("mp4_size") val mp4Size: String,
    @SerializedName("webp_size") val webpSize: String,
    @SerializedName("webp") val webp: String,
    @SerializedName("frames") val frames: String,
    @SerializedName("hash") val hash: String
) : Parcelable
@Parcelize
data class Downsized(
    @SerializedName("height") val height: String,
    @SerializedName("width") val width: String,
    @SerializedName("size") val size: String,
    @SerializedName("url") val url: String
) : Parcelable