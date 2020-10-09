package com.example.jyfpokemongomvvm.ui.detail

import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.jyfpokemongomvvm.data.remote.doFailure
import com.example.jyfpokemongomvvm.data.remote.doSuccess
import com.example.jyfpokemongomvvm.data.repository.Repository
import com.example.jyfpokemongomvvm.model.PokemonInfoModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/10/9
 *     desc  :
 * </pre>
 */
class DetailViewModel @ViewModelInject constructor(
    private val pokemonRepository: Repository
) : ViewModel() {
    val mLoading = ObservableBoolean()

    // 私有的 MutableLiveData 可变的 对内访问
    private val _pokemon = MutableLiveData<PokemonInfoModel>()

    // 对外暴露不可变的 LiveData 只能查询
    val pokemon: LiveData<PokemonInfoModel> = _pokemon

    private val _failure = MutableLiveData<String>()

    val failure =  _failure

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun fetchPokemonInfo3(name: String) =
        pokemonRepository.fetchPokemonInfo(name)
            .onStart {
                mLoading.set(true)
            }
            .catch {
                mLoading.set(false)
            }
            .onCompletion {
                mLoading.set(false)
            }.asLiveData()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun fetchPokemonInfo2(name: String) = liveData<PokemonInfoModel>{
        pokemonRepository.fetchPokemonInfo(name)
            .onStart {
                mLoading.set(true)
            }
            .catch {
                mLoading.set(false)
            }
            .onCompletion {
                mLoading.set(false)
            }
            .collectLatest { result ->
                result.doFailure { throwable ->
                    _failure.value = throwable?.message?: "failure"
                }
                result.doSuccess {value ->
                    _pokemon.postValue(value)
                    emit(value)
                }
            }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun fetchPokemonInfo1(name: String) = viewModelScope.launch {
        pokemonRepository.fetchPokemonInfo(name)
            .onStart {
                mLoading.set(true)
            }
            .catch {
                mLoading.set(false)
            }
            .onCompletion {
                mLoading.set(false)
            }
            .collectLatest { result ->
                result.doFailure { throwable ->
                    _failure.value = throwable?.message ?: "failure"
                }
                result.doSuccess { value ->
                    _pokemon.postValue(value)
                }
            }
    }
}