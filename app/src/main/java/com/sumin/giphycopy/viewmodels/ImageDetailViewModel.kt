package com.sumin.giphycopy.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sumin.giphycopy.data.AppDatabase
import com.sumin.giphycopy.data.Data
import com.sumin.giphycopy.data.entity.FavoriteEntity
import com.sumin.giphycopy.data.repository.FavoriteRepository
import kotlinx.coroutines.launch

class ImageDetailViewModel(data: Data, application: Application) : AndroidViewModel(application) {

    private val favoriteRepository = FavoriteRepository(AppDatabase.getInstance(application))
    val data = data

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    init {
        getImageDetail()
    }
    private fun getImageDetail() {
//        _isFavorite.value = when (isFavorite(data.id)) {
//            false -> false
//            true -> true
//        }
        Log.i("ImageDetailViewModel", "data: ${data.id}")
    }

    // favorite 버튼 누르기
    fun getFavorite() {
        viewModelScope.launch {
            when (favoriteRepository.findOne(data.id)) {
                // favorite 엔터티에 데이터가 없으면 favorite 넣기
                0 -> {
                    var favorite = FavoriteEntity(
                        type = data.type,
                        id = data.id,
                        url = data.url,
                        title = data.title,
                        rating = data.rating,
                        username = data.username,
                        originalUrl = data.images.original.url,
                        previewUrl = data.images.previewGif.url
                    )
                    favoriteRepository.insertFavorite(favorite)
                    _isFavorite.value = true
                    Log.i("ddd", "저장완료")
                }
                // favorite 엔터티에 데이터가 있으면 해당 엔터티 삭제
                else -> {
                    favoriteRepository.deleteFavorite(data.id)
                    _isFavorite.value = false
                    Log.i("ddd", "삭제완료")
                }
            }
        }
    }
    // favorite 엔터티에 있는지 확인하기
//    private fun isFavorite(id: String): Boolean {
//        var result = false
//        viewModelScope.launch {
//            result = when (favoriteRepository.findOne(data.id)) {
//                0 -> false // 엔터티 데이터 없음
//                else -> true    // 데이터 있음
//            }
//        }
//        return result
//    }
}