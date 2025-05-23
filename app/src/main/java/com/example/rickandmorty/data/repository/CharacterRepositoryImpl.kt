package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.api.CharacterApiService
import com.example.rickandmorty.data.model.CharacterSerie
import com.example.rickandmorty.data.Resource
import com.example.rickandmorty.data.model.toDomain

class CharacterRepositoryImpl(private val characterApiService: CharacterApiService) :
    CharacterRepository {

    override suspend fun getCharacterApi(): Resource<List<CharacterSerie>> {
        val response = characterApiService.getMultipleCharacters()
        return if (response.isSuccessful) {
            Resource.Success(response.body()?.results?.map { characterModel ->
                characterModel.toDomain()
            } ?: emptyList())
        } else {
            Resource.Failure(Exception("Error"))
        }
    }

}