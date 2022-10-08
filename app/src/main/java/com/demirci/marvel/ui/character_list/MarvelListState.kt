package com.demirci.marvel.ui.character_list

import com.demirci.marvel.domain.model.CharacterModel
data class MarvelListState(
    val isLoading : Boolean = false,
    val characterModelList : List<CharacterModel> = emptyList(),
    val error : String = ""
)
