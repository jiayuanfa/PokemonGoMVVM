package com.example.jyfpokemongomvvm.data.remote

import com.example.jyfpokemongomvvm.data.entity.ListingResponse
import com.example.jyfpokemongomvvm.data.entity.NetworkPokemonInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/23
 *     desc  :
 * </pre>
 */
interface PokemonService {
    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): ListingResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String): NetworkPokemonInfo
}