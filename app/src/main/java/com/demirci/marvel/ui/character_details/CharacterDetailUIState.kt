package com.demirci.marvel.ui.character_details

import com.demirci.marvel.domain.model.CharacterDetailsModel

data class CharacterDetailUIState(
    val isLoading : Boolean = false,
    val characterDetail : List<CharacterDetailsModel> = emptyList(),
    val error : String = ""
)