package com.sumin.giphycopy.api

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("original") val original: Original,
    @SerializedName("preview_gif") val previewGif: PreviewGif
)
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
)
data class PreviewGif(
    @SerializedName("height") val height: String,
    @SerializedName("width") val width: String,
    @SerializedName("size") val size: String,
    @SerializedName("url") val url: String
)