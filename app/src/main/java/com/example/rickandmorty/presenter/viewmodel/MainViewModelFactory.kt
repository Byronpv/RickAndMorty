package com.example.rickandmorty.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.api.CharacterApiService
import com.example.rickandmorty.data.repository.CharacterRepositoryImpl

class MainViewModelFactory(private val characterApiService: CharacterApiService) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val characterRepositoryImpl = CharacterRepositoryImpl(
            characterApiService = characterApiService
        )
        return MainViewModel(characterRepositoryImpl) as T
    }
}
