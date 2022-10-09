package com.demirci.marvel.ui.character_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demirci.marvel.common.Resource
import com.demirci.marvel.domain.model.CharacterModel
import com.demirci.marvel.domain.usecase.GetCharacterDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    val characterDetailsUseCase: GetCharacterDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val characterDetails = MutableStateFlow(CharacterDetailUIState())

    private val comics: MutableStateFlow<String> = MutableStateFlow(String())

    val _comics: MutableStateFlow<String> = comics

    var character: MutableStateFlow<CharacterModel?> = MutableStateFlow(CharacterModel())

    init {
        viewModelScope.launch {
            character.value = savedStateHandle["characterModel"]
            getCharacterByIdValue(character.value?.id.toString())
           // getCharacterByIdValue("1011334")
        }

    }


    private fun getCharacterByIdValue(id: String) = viewModelScope.launch {
        characterDetailsUseCase(id).collect { characterDetailsModel ->
            when (characterDetailsModel) {
                is Resource.Success -> {
                    characterDetails.value = CharacterDetailUIState(
                        characterDetail = characterDetailsModel.data ?: emptyList()
                    )
                    var comics = ""
                    characterDetailsModel.data?.forEach {
                        comics += it.title + "\n"
                    }
                    this@CharacterDetailsViewModel.comics.value = comics.trim()
                }
                is Resource.Loading -> {
                    characterDetails.value = CharacterDetailUIState(isLoading = true)
                }
                is Resource.Error -> {
                    characterDetails.value = CharacterDetailUIState(
                        error = characterDetailsModel.errorMessage ?: "An Unexpected Error"
                    )
                }
            }
        }
    }


}