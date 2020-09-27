package com.example.jyfpokemongomvvm.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jyfpokemongomvvm.ext.getEmptyOrDefault

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/23
 *     desc  :
 * </pre>
 */
@Entity
data class PokemonInfoEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<Type>,
    val stats: List<Stats>,
    @Embedded val sprites: Sprites
) {
    data class Sprites(
        val backDefault: String,
        val backFemale: String,
        val backShiny: String,
        val backShinyFemale: String,
        val frontDefault: String,
        val frontFemale: String,
        val frontShiny: String,
        val frontShinyFemale: String
    )
    data class Type(val name: String, val url: String)
    data class Stats(val baseStat: Int, val name: String, val url: String)


    companion object {
        fun convert2PokemonInfoEntity(networkPokemonInfo: NetworkPokemonInfo) : PokemonInfoEntity {
            return networkPokemonInfo.run {
                val dbTypes = mutableListOf<Type>()
                val dbStats = mutableListOf<Stats>()

                types.forEach {
                    dbTypes.add(
                        Type(
                            name = it.type.name,
                            url = it.type.url
                        )
                    )
                }

                stats.forEach {
                    dbStats.add(
                        Stats(
                            baseStat = it.baseStat,
                            name = it.stat.name,
                            url = it.stat.url
                        )
                    )
                }

                val dbSprites = Sprites(
                    backDefault = sprites.backDefault.getEmptyOrDefault { "" },
                    backFemale = sprites.backFemale.getEmptyOrDefault { "" },
                    backShiny = sprites.backShiny.getEmptyOrDefault { "" },
                    backShinyFemale = sprites.backShinyFemale.getEmptyOrDefault { "" },
                    frontDefault =  sprites.frontDefault.getEmptyOrDefault { "" },
                    frontFemale = sprites.frontfemale.getEmptyOrDefault { "" },
                    frontShiny = sprites.frontShiny.getEmptyOrDefault { "" },
                    frontShinyFemale = sprites.frontShinyFemale.getEmptyOrDefault { "" }
                )

                PokemonInfoEntity(
                    name = name,
                    height = height,
                    weight = weight,
                    experience = experience,
                    types = dbTypes,
                    stats = dbStats,
                    sprites = dbSprites
                )
            }
        }
    }
}