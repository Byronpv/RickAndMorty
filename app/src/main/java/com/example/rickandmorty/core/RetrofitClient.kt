package com.example.rickandmorty.core

import com.example.rickandmorty.data.api.CharacterApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val characterApiService: CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }
}