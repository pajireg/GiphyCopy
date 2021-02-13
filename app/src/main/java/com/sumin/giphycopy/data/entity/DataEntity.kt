package com.sumin.giphycopy.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sumin.giphycopy.data.DataModel

@Entity(tableName = "t_data")
data class DataEntity(
        @PrimaryKey val id: String,
        val type: String?,
        val url: String,
        val username: String,
        val title: String,
        val rating: String,
        val importDatetime: String,
        val trendingDatetime: String,
        val imageOriginalUrl: String,
        val imageDownsizedUrl: String,
        val isFavorite: Boolean?
)
fun List<DataEntity>.asDomainModel(): List<DataModel> {
    return map {
        DataModel(
                id = it.id,
                type = it.type,
                url = it.url,
                username = it.username,
                title = it.title,
                rating = it.rating,
                importDatetime = it.importDatetime,
                trendingDatetime = it.trendingDatetime,
                imageOriginalUrl = it.imageOriginalUrl,
                imageDownsizedUrl = it.imageDownsizedUrl,
                isFavorite = it.isFavorite
        )
    }
}