package com.example.jyfpokemongomvvm.model

import androidx.recyclerview.widget.DiffUtil
import kotlin.random.Random

data class PokemonInfoModel(
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<Type>,
    val stats: List<Stats>,
    val albums: List<AlbumModel>,
    val hp: Int = Random.nextInt(maxHp),
    val attack: Int = Random.nextInt(maxAttack),
    val speed: Int = Random.nextInt(maxSpeed),
    val exp: Int = Random.nextInt(maxExp)
) {

    // 格式化输出
    fun generateWeight(): String = "%.1f KG".format(weight.toFloat() / 10)
    fun generateHeight(): String = "%.1f M".format(height.toFloat() / 10)
    fun generateHP(): String = "$hp/$maxHp HP"
    fun generateAttack(): String = "$attack/$maxAttack"
    fun generateSpeed(): String = "$speed/$maxSpeed"
    fun generateExp(): String = "$exp/$maxExp"

    override fun toString(): String {
        return "PokemonInfoModel(name=$name, height=$height, weight=$weight, experience=$experience)"
    }

    data class AlbumModel(val index: Int, val url: String) {
        companion object {
            val diffCallback = object : DiffUtil.ItemCallback<AlbumModel>() {
                override fun areItemsTheSame(
                    oldItem: AlbumModel,
                    newItem: AlbumModel
                ): Boolean =
                    oldItem.index == newItem.index

                override fun areContentsTheSame(
                    oldItem: AlbumModel,
                    newItem: AlbumModel
                ): Boolean =
                    oldItem == newItem

            }
        }
    }
    data class Type(val name: String, val url: String)
    data class Stats(val baseStat: Int, val name: String, val url: String)

    companion object {
        const val maxHp = 500
        const val maxAttack = 600
        const val maxSpeed = 400
        const val maxExp = 800
    }
}