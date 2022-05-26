package com.example.rickandmorty

import com.example.rickandmorty.data.CharacterRemoteDataSource
import com.example.rickandmorty.model.CharacterModel
import com.example.rickandmorty.model.Resource

class Repository(val remoteCharacter: CharacterRemoteDataSource) {

    suspend fun getCharacterApi(): Resource<List<CharacterModel>?> {
        return remoteCharacter.getCharacterApi()
    }

}