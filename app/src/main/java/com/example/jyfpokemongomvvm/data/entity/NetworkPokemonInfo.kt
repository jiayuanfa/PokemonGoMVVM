package com.example.jyfpokemongomvvm.data.entity

import com.google.gson.annotations.SerializedName

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/23
 *     desc  : 网络返回的Pokemon数据信息
 * </pre>
 */
class NetworkPokemonInfo (
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("base_experience") val experience: Int,
    @SerializedName("types") val types: List<Types>,
    @SerializedName("stats") val stats: List<Stats>,
    @SerializedName("sprites") val sprites: Sprites
) {
    data class Sprites(
        @SerializedName("back_default") val backDefault: String,
        @SerializedName("back_female") val backFemale: String,
        @SerializedName("back_shiny") val backShiny: String,
        @SerializedName("back_shiny_female") val backShinyFemale: String,
        @SerializedName("front_default") val frontDefault: String,
        @SerializedName("front_female") val frontfemale: String,
        @SerializedName("front_shiny") val frontShiny: String,
        @SerializedName("front_shiny_female") val frontShinyFemale: String
    )

    data class Types(val slot: Int, val type: Type) {
        data class Type(val name: String, val url: String)
    }

    data class Stats(@SerializedName("base_stat") val baseStat: Int, val stat: Stat) {
        data class Stat(val name: String, val url: String)
    }

    override fun toString(): String {
        return "NetWorkPokemonInfo(name='$name', height=$height, weight=$weight, experience=$experience, types=$types, stats=$stats, sprites=$sprites)"
    }
}