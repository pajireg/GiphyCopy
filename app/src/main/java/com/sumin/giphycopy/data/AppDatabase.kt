package com.sumin.giphycopy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sumin.giphycopy.data.dao.DataDao
import com.sumin.giphycopy.data.dao.FavoriteDao
import com.sumin.giphycopy.data.entity.DataEntity
import com.sumin.giphycopy.data.entity.FavoriteEntity

@Database(
    entities = [
        FavoriteEntity::class,
        DataEntity::class
    ]
    , version = 1
    , exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract val favoriteDao: FavoriteDao
    abstract val dataDao: DataDao

    companion object {
        private lateinit var INSTANCE: AppDatabase
        fun getInstance(context: Context): AppDatabase {
            synchronized(AppDatabase::class.java) {
                if(!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java, "app_database"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}