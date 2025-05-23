package com.example.rickandmorty.core.di

import com.example.rickandmorty.data.api.CharacterApiService
import com.example.rickandmorty.data.repository.CharacterRepository
import com.example.rickandmorty.data.repository.CharacterRepositoryImpl
import com.example.rickandmorty.presentation.ui.viewmodel.CharacterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/") // ¡Tu URL base!
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(CharacterApiService::class.java) }
}

val repositoryModule = module {
    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }
}

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
}