package com.demirci.marvel.domain.model

data class CharacterModel(
    val id: Int?,
    val name: String?,
    val description: String?,
    val thumbnail: String?,
    val thumbnailExtension: String?,
    val comics: List<String?>
)
