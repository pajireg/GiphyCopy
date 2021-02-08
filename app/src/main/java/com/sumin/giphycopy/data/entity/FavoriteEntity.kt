package com.sumin.giphycopy.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_favorite")
data class FavoriteEntity(
    @PrimaryKey val id: String,
    val type: String?,
    val url: String?,
    val username: String?,
    val title: String?,
    val rating: String?,
    val originalUrl: String?,
    val previewUrl: String?
)
