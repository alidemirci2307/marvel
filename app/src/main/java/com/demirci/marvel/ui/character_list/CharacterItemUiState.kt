package com.demirci.marvel.ui.character_list

import com.demirci.marvel.common.BaseUiState
import com.demirci.marvel.domain.model.CharacterModel

data class CharacterItemUiState(private val characterModel: CharacterModel) : BaseUiState() {

    fun getId() = characterModel.id

    fun getImageUrl() = "${characterModel.thumbnail?.replace("http", "https")}/portrait_xlarge.${characterModel.thumbnailExtension}"

    fun getName() = characterModel.name

    fun getDescription() = characterModel.description

    fun getComics() = characterModel.comics


}