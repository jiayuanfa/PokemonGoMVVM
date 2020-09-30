package com.example.jyfpokemongomvvm.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jyfpokemongomvvm.data.entity.PokemonEntity

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/24
 *     desc  :
 * </pre>
 */
@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemonList: List<PokemonEntity>)

    @Query("SELECT * FROM PokemonEntity")
    fun getPokemon(): PagingSource<Int, PokemonEntity>

    @Query("DELETE FROM PokemonEntity where remoteName = :name")
    suspend fun clearPokemon(name: String)
}