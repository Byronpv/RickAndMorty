package com.example.rickandmorty.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.Repository
import com.example.rickandmorty.data.model.dataSource.characteres.CharacterRemoteDataSource

class MainViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = Repository(
            remoteCharacter = CharacterRemoteDataSource()
        )
        Log.d("Factory","$repository")
        return MainViewModel(repository) as T
    }
}
