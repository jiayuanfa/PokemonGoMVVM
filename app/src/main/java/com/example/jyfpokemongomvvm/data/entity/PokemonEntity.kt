package com.example.jyfpokemongomvvm.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/23
 *     desc  : 数据库列表类
 * </pre>
 */
@Entity
data class PokemonEntity (
    @PrimaryKey
    val name: String,
    var pokemonId: Int = 0,
    val page: Int = 0,
    val url: String,
    val remoteName: String
)
