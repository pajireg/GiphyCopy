package com.sumin.giphycopy.data.repository

import androidx.lifecycle.LiveData
import com.sumin.giphycopy.data.AppDatabase
import com.sumin.giphycopy.data.entity.FavoriteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteRepository(private val database: AppDatabase) {
    suspend fun insertFavorite(favoriteEntity: FavoriteEntity) {
        withContext(Dispatchers.IO) {
            database.favoriteDao.insertFavorite(favoriteEntity)
        }
    }
    suspend fun getOne(id: String): LiveData<FavoriteEntity> {
        return withContext(Dispatchers.IO) {
            database.favoriteDao.getOne(id)
        }
    }
    suspend fun findOne(id: String): Int {
        return withContext(Dispatchers.IO) {
            database.favoriteDao.findOne(id)
        }
    }
    suspend fun deleteFavorite(id: String) {
        withContext(Dispatchers.IO) {
            database.favoriteDao.deleteOne(id)
        }
    }
    suspend fun findAll(): List<FavoriteEntity> {
        return withContext(Dispatchers.IO) {
            database.favoriteDao.getAllFavorite()
        }
    }
}