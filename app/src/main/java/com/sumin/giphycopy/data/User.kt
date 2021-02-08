package com.sumin.giphycopy.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("username") val username: String,
    @SerializedName("display_name") val displayName: String
) : Parcelable