package com.demirci.marvel.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demirci.marvel.domain.model.CharacterModel
import com.demirci.marvel.domain.usecase.CharactersUseCase
import com.demirci.marvel.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterUseCase: CharactersUseCase
) : ViewModel(), CharacterListener {

    private val marvelValue = MutableStateFlow(MarvelListState())
    var _marvelValue : StateFlow<MarvelListState> = marvelValue

    init {
        getAllCharactersWithPaing(30)
    }

    fun getAllCharactersWithPaing(offset: Int) = viewModelScope.launch(Dispatchers.IO) {
        characterUseCase(offset = offset).collect() {
            when (it) {
                is Response.Success -> {
                    marvelValue.value = MarvelListState(characterModelList = it.data?: emptyList())
                }

                is Response.Loading -> {
                    marvelValue.value = MarvelListState(isLoading = true)
                }

                is Response.Error -> {
                    marvelValue.value = MarvelListState(error = it.message ?: "Response Error")
                }
            }
        }
    }

    override fun onCharacterClicked(characterModel: CharacterModel) {
        TODO("Not yet implemented")
    }
}