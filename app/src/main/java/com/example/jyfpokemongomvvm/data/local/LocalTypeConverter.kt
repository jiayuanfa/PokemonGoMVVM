package com.example.jyfpokemongomvvm.data.local

import androidx.room.TypeConverter
import com.example.jyfpokemongomvvm.data.entity.PokemonInfoEntity
import com.google.gson.GsonBuilder
import com.example.jyfpokemongomvvm.ext.fromJson
import com.example.jyfpokemongomvvm.ext.typedToJson

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/24
 *     desc  :
 * </pre>
 */
open class LocalTypeConverter {

    @TypeConverter
    fun json2StatsEntity(src: String): List<PokemonInfoEntity.Stats>? =
        GsonBuilder().create().fromJson(src)

    @TypeConverter
    fun statsEntity2Json(data: List<PokemonInfoEntity.Stats>) : String =
        GsonBuilder().create().typedToJson(data)

    @TypeConverter
    fun json2TypeEntity(src: String): List<PokemonInfoEntity.Type>? =
        GsonBuilder().create().fromJson(src)

    @TypeConverter
    fun typeEntity2Json(data: List<PokemonInfoEntity.Type>): String =
        GsonBuilder().create().typedToJson(data)
}