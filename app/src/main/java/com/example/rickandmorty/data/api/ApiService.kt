package com.example.rickandmorty.data.api

import com.example.rickandmorty.model.CharacterListModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("character")
    suspend fun getMultipleCharacters() : Response<CharacterListModel>
}