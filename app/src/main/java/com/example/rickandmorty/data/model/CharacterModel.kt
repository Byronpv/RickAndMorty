package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("image") val image: String,
    @SerializedName("origin") val origin: OriginListModel
) : Serializable

data class OriginListModel(@SerializedName("name") val planetName: String) : Serializable

data class CharacterListModel(@SerializedName("results") val results: List<CharacterModel>)

data class Origin(val planetName: String) : Serializable

data class CharacterSerie(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val imageUrl: String,
    val origin: Origin
) : Serializable