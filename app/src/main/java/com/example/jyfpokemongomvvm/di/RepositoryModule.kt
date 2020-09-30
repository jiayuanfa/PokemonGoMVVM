package com.example.jyfpokemongomvvm.di

import com.example.jyfpokemongomvvm.data.PokemonFactory
import com.example.jyfpokemongomvvm.data.local.AppDataBase
import com.example.jyfpokemongomvvm.data.remote.PokemonService
import com.example.jyfpokemongomvvm.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTasksRepository(
        api: PokemonService,
        db: AppDataBase
    ): Repository {
        return PokemonFactory.makePokemonRepository(api, db)
    }
}