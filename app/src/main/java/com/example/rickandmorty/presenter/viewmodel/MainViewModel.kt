package com.example.rickandmorty.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.model.CharacterSerie
import com.example.rickandmorty.data.Resource
import com.example.rickandmorty.data.repository.CharacterRepository
import kotlinx.coroutines.launch

class MainViewModel(private val characterRepository: CharacterRepository) : ViewModel() {

    private val _characterListState = MutableLiveData<Resource<List<CharacterSerie>>>()
    val characterListState: LiveData<Resource<List<CharacterSerie>>> = _characterListState

    fun fetchCharacterList() {
        viewModelScope.launch {
            _characterListState.value = Resource.Loading()
            val result = characterRepository.getCharacterApi()

            _characterListState.value = result

            when(result) {
                is Resource.Success -> {
                    result.data.let { data ->
                        _characterListState.value = Resource.Success(data)
                    }
                }
                is Resource.Failure -> TODO()
                is Resource.Loading -> TODO()
            }

        }
    }

}