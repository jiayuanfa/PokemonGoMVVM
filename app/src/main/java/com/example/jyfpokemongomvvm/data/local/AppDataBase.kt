package com.example.jyfpokemongomvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jyfpokemongomvvm.data.entity.PokemonEntity
import com.example.jyfpokemongomvvm.data.entity.PokemonInfoEntity
import com.example.jyfpokemongomvvm.data.entity.RemoteKeysEntity

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/23
 *     desc  : 数据库
 * </pre>
 */
@Database(
    entities = [PokemonEntity::class, RemoteKeysEntity::class, PokemonInfoEntity::class],
    version = 1, exportSchema = false
)
@TypeConverters(value = [LocalTypeConverter::class])
abstract class AppDataBase : RoomDatabase() {
    abstract class pokemonDao(): PokemonDao
    abstract class pokemonInfoDao(): PokemonInfoDao
    abstract class remoteKeysDao(): RemoteKeysDao
}