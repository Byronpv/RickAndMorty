package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class CharacterListModel(@SerializedName("results") val results: List<CharacterModel>) {
}