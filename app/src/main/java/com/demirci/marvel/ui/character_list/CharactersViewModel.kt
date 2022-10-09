package com.demirci.marvel.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.demirci.marvel.domain.repository.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val marvelRepository: MarvelRepository
) : ViewModel() {

    val characterItemsUiStates = marvelRepository.getAllCharactersWithPaging().map { pagingData ->
        pagingData.map { characterModel -> CharacterItemUiState(characterModel) }
    }.cachedIn(viewModelScope)


}