package com.example.jyfpokemongomvvm.data.mapper

import com.example.jyfpokemongomvvm.data.entity.PokemonEntity
import com.example.jyfpokemongomvvm.model.PokemonItemModel

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/29
 *     desc  : 制造PokemonItemModel的map方法
 * </pre>
 */
class Entity2ItemModelMapper : Mapper<PokemonEntity, PokemonItemModel> {
    override fun map(input: PokemonEntity): PokemonItemModel {
        return PokemonItemModel(name = input.name, url = input.url)
    }
}