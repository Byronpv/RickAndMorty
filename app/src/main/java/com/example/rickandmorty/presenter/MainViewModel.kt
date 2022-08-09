package com.example.rickandmorty.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmorty.Repository
import com.example.rickandmorty.data.model.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: Repository) : ViewModel() {

    val getCharacterApiVM = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repository.getCharacterApi())
        } catch (e: Exception) {
            Log.d("RemoteApiFailed:", "failed")
            emit(Resource.Failure(e))
        }
    }


}