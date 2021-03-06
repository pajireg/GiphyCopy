package com.sumin.giphycopy.data

import android.os.Parcelable
import androidx.fragment.app.viewModels
import com.google.gson.annotations.SerializedName
import com.sumin.giphycopy.data.entity.DataEntity
import com.sumin.giphycopy.viewmodels.TrendingViewModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataProperty(
    val data: List<Data>,
    val pagination: Pagination,
    val meta: Meta
) : Parcelable
@Parcelize
data class Data(
    @SerializedName("type:") val type: String,
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("bitly_gif_url") val bitlyGifUrl: String,
    @SerializedName("bitly_url")val bitlyUrl: String,
    @SerializedName("embed_url") val embedUrl: String,
    @SerializedName("username") val username: String,
    @SerializedName("source") val source: String,
    @SerializedName("title") val title: String,
    @SerializedName("rating") val rating: String,
    @SerializedName("content_url") val contentUrl: String,
    @SerializedName("source_tld") val sourceTld: String,
    @SerializedName("source_post_url") val sourcePostUrl: String,
    @SerializedName("is_sticker") val isSticker: Int,
    @SerializedName("import_datetime") val importDatetime: String,
    @SerializedName("trending_datetime") val trendingDatetime: String,
    @SerializedName("images") val images: Images,
    @SerializedName("user") val user: User
) : Parcelable

data class DataContainer(val data: List<Data>)

fun DataContainer.asDatabaseModel(): List<DataEntity> {
    return data.map {
        DataEntity(
                id = it.id,
                type = it.type,
                url = it.url,
                username = it.username,
                title = it.title,
                rating = it.rating,
                importDatetime = it.importDatetime,
                trendingDatetime = it.trendingDatetime,
                imageOriginalUrl = it.images.original.url,
                imageDownsizedUrl = it.images.downsized.url,
                isFavorite = false
        )
    }
}
@Parcelize
data class Pagination(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("offset") val offset: Int
) : Parcelable
@Parcelize
data class Meta(
    @SerializedName("status") val status: Int,
    @SerializedName("msg") val msg: String,
    @SerializedName("response_id") val responseId: String
) : Parcelable