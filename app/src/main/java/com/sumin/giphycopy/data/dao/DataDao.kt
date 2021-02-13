package com.sumin.giphycopy.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sumin.giphycopy.data.entity.DataEntity

@Dao
interface DataDao {

    @Query("SELECT * FROM t_data")
    fun getAllData(): LiveData<List<DataEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(dataEntity: List<DataEntity>)

    @Query("UPDATE t_data SET isFavorite=:isFavorite WHERE id=:id")
    fun updateIsFavorite(isFavorite: Boolean, id: String)
}