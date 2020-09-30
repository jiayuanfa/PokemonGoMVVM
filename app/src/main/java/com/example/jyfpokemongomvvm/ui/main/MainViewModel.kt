package com.example.jyfpokemongomvvm.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jyfpokemongomvvm.data.repository.Repository
import com.example.jyfpokemongomvvm.model.PokemonItemModel

class MainViewModel @ViewModelInject constructor(
    private val pokemonRepository: Repository
) : ViewModel(){
    fun postOfData(): LiveData<PagingData<PokemonItemModel>> =
        pokemonRepository.fetchPokemonList().cachedIn(viewModelScope).asLiveData()
}