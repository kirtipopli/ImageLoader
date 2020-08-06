package com.axxess.imageloader.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.axxess.imageloader.models.Data


@Dao
interface ImageDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(data: List<Data>)
}