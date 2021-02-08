package com.sumin.giphycopy.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.sumin.giphycopy.data.AppDatabase
import com.sumin.giphycopy.data.entity.FavoriteEntity
import com.sumin.giphycopy.data.repository.FavoriteRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteRepository = FavoriteRepository(AppDatabase.getInstance(application))
    private val _listFavorite = MutableLiveData<List<FavoriteEntity>>()
    val listFavorite: LiveData<List<FavoriteEntity>>
        get() = _listFavorite

    init {
        getFavorite()
    }
    private fun getFavorite() {
        viewModelScope.launch {
            try {
                _listFavorite.value = favoriteRepository.findAll()
            } catch (e: Exception) {
                e.message?.let { Log.e("UserViewModel", it) }
            }
        }
    }
}