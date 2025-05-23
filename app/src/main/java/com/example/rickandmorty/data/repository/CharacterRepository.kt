package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.Resource
import com.example.rickandmorty.data.model.CharacterSerie

interface CharacterRepository {

    suspend fun getCharacterApi(): Resource<List<CharacterSerie>>
}