package com.sumin.giphycopy.api

import com.sumin.giphycopy.data.DataContainer
import com.sumin.giphycopy.util.Constants.API_KEY
import com.sumin.giphycopy.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DataService {
    @GET("trending?api_key=$API_KEY")
    suspend fun getData(
        @Query("limit") limit: Int,
        @Query("rating") rating: String
    ): DataContainer
}

object DataApi {
    val apiService: DataService by lazy {
        retrofit.create(DataService::class.java)
    }
}