package com.sumin.giphycopy.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sumin.giphycopy.api.DataApi
import com.sumin.giphycopy.data.AppDatabase
import com.sumin.giphycopy.data.DataContainer
import com.sumin.giphycopy.data.DataModel
import com.sumin.giphycopy.data.entity.FavoriteEntity
import com.sumin.giphycopy.data.repository.DataRepository
import com.sumin.giphycopy.data.repository.FavoriteRepository
import kotlinx.coroutines.launch

class TrendingViewModel(application: Application) : AndroidViewModel(application) {

    companion object{
        private val TAG = TrendingViewModel::class.toString()
    }
    private val dataRepository = DataRepository(AppDatabase.getInstance(application))
    private val favoriteRepository = FavoriteRepository(AppDatabase.getInstance(application))

    private val _dataContainer = MutableLiveData<DataContainer>()

    var listData = dataRepository.data

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    init {
        getDataProperties()
    }
    private fun getDataProperties() {
        viewModelScope.launch {
            try {
                _dataContainer.value = DataApi.apiService.getData(50, "g")
                _dataContainer.value?.let { dataRepository.insertAll(it) }
            } catch (e: Exception) {
                e.message?.let { Log.e(TAG, it) }
            }
        }
    }

    // favorite 버튼 누르기
    fun getFavorite(data: DataModel) {
        viewModelScope.launch {
            when (favoriteRepository.findOne(data.id)) {
                // favorite 엔터티에 데이터가 없으면 favorite 넣기
                0 -> {
                    val favorite = FavoriteEntity(
                            type = data.type,
                            id = data.id,
                            url = data.url,
                            title = data.title,
                            rating = data.rating,
                            username = data.username,
                            originalUrl = data.imageOriginalUrl,
                            downsizedUrl = data.imageDownsizedUrl,
                    )
                    favoriteRepository.insertFavorite(favorite)
                    dataRepository.updateIsFavorite(true, data.id)
                    data.isFavorite = true
                    _isFavorite.value = true
                }
                // favorite 엔터티에 데이터가 있으면 해당 엔터티 삭제
                else -> {
                    favoriteRepository.deleteFavorite(data.id)
                    dataRepository.updateIsFavorite(false, data.id)
                    data.isFavorite = false
                    _isFavorite.value = false
                }
            }
        }
    }
}