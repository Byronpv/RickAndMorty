package com.example.rickandmorty.data

import android.util.Log
import com.example.rickandmorty.data.api.ApiService
import com.example.rickandmorty.model.Resource
import com.example.rickandmorty.core.RetrofitClient
import com.example.rickandmorty.model.CharacterModel
import java.lang.Exception

class CharacterRemoteDataSource {

    private val retrofit = RetrofitClient.getRetrofit().create(ApiService::class.java)

    suspend fun getCharacterApi(): Resource<List<CharacterModel>?> {
        val response = retrofit.getMultipleCharacters()
        return if (response.isSuccessful) {
            Log.d("RemoteApi:", "${response.body()?.results}")
            Resource.Success(response.body()?.results)
        } else {
            Resource.Failure(Exception())
        }
    }


}
