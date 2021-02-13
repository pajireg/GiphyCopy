package com.sumin.giphycopy.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sumin.giphycopy.data.AppDatabase
import com.sumin.giphycopy.data.DataContainer
import com.sumin.giphycopy.data.DataModel
import com.sumin.giphycopy.data.asDatabaseModel
import com.sumin.giphycopy.data.entity.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataRepository(private val database: AppDatabase) {

    var data: LiveData<List<DataModel>> = Transformations.map(database.dataDao.getAllData()) {
        it.asDomainModel()
    }

    suspend fun insertAll(data: DataContainer) {
        withContext(Dispatchers.IO) {
            database.dataDao.insertAll(data.asDatabaseModel())
        }
    }

    suspend fun updateIsFavorite(isFavorite: Boolean, id: String) {
        withContext(Dispatchers.IO) {
            database.dataDao.updateIsFavorite(isFavorite, id)
        }
    }
}