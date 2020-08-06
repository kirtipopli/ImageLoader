package com.axxess.imageloader.db

import androidx.room.TypeConverter
import com.axxess.imageloader.models.Data
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<Data>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Data>::class.java).toList()

}