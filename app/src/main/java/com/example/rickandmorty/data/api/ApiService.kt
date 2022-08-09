package com.example.rickandmorty.data.api

import com.example.rickandmorty.data.model.CharacterListModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

//test
    @GET("character")
    suspend fun getMultipleCharacters() : Response<CharacterListModel>
}