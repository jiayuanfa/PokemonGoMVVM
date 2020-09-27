package com.example.jyfpokemongomvvm.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jyfpokemongomvvm.data.entity.PokemonInfoEntity

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/24
 *     desc  :
 * </pre>
 */
interface PokemonInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemonInfoEntity: PokemonInfoEntity)

    @Query("SELECT * FROM PokemonInfoEntity where name = :name")
    suspend fun getPokemon(name: String): PokemonInfoEntity?

    @Query("DELETE FROM PokemonInfoEntity where id = :id")
    suspend fun clearPokemonInfo(id: Int)
}