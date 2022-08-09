package com.example.rickandmorty.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OriginListModel(@SerializedName("name") val namePlanet: String):Serializable
