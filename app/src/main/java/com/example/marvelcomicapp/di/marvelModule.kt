package com.example.marvelcomicapp.di

import com.example.marvelcomicapp.api.MarvelService
import com.example.marvelcomicapp.repository.*
import com.example.marvelcomicapp.resource.MarvelRetrofit
import com.example.marvelcomicapp.viewmodel.AllCharactersViewModel
import com.example.marvelcomicapp.viewmodel.CharacterDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val marvelModule = module {

    single { MarvelRetrofit.createService(MarvelService::class.java) }

    single { CharactersRepository(get()) }

    viewModel { AllCharactersViewModel(get()) }

    single<ComicsRepository> { ComicsRepositoryImpl(get()) }

    single<GetComicsByCharacterIdUseCase> { GetComicsByCharacterId(get()) }

    viewModel { CharacterDetailsViewModel(get()) }
}