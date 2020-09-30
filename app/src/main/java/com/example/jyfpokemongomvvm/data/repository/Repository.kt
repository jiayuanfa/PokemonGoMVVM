package com.example.jyfpokemongomvvm.data.repository

import androidx.paging.PagingData
import com.example.jyfpokemongomvvm.data.remote.PokemonResult
import com.example.jyfpokemongomvvm.model.PokemonInfoModel
import com.example.jyfpokemongomvvm.model.PokemonItemModel
import dagger.Provides
import kotlinx.coroutines.flow.Flow

/**
 * 数据仓库
 */
interface Repository {

    /**
     * 获取列表数据流 可翻页
     */
    fun fetchPokemonList(): Flow<PagingData<PokemonItemModel>>

    /**
     * 获取详情页数据
     */
    suspend fun fetchPokemonInfo(name: String): Flow<PokemonResult<PokemonInfoModel>>
}