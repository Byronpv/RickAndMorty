package com.example.rickandmorty.data.model

fun OriginListModel.toDomain(): Origin {
    return Origin(
        planetName = this.planetName
    )
}

fun CharacterModel.toDomain(): CharacterSerie {
    return CharacterSerie(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        gender = this.gender,
        imageUrl = this.image,
        origin = this.origin.toDomain()
    )
}