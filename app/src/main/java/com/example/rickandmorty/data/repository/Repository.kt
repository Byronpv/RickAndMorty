package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.model.dataSource.characteres.CharacterRemoteDataSource
import com.example.rickandmorty.data.model.CharacterModel
import com.example.rickandmorty.data.model.Resource

class Repository(val remoteCharacter: CharacterRemoteDataSource) {

    suspend fun getCharacterApi(): Resource<List<CharacterModel>?> {
        return remoteCharacter.getCharacterApi()
    }

}