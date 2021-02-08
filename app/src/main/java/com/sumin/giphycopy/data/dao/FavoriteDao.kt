package com.sumin.giphycopy.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sumin.giphycopy.data.entity.FavoriteEntity

@Dao
interface FavoriteDao {

    @Insert
    fun insertFavorite(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM t_favorite")
    fun getAllFavorite(): List<FavoriteEntity>

    @Query("SELECT * FROM t_favorite WHERE id=:id")
    fun getOne(id: String): LiveData<FavoriteEntity>

    @Query("SELECT count(*) FROM t_favorite WHERE id=:id")
    fun findOne(id: String): Int

    @Query("DELETE FROM t_favorite WHERE id=:id")
    fun deleteOne(id: String)
}