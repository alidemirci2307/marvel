package com.demirci.marvel.ui.character_list

import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import com.demirci.marvel.common.BaseUiState
import com.demirci.marvel.domain.model.CharacterModel

data class CharacterItemUiState(private val characterModel: CharacterModel) : BaseUiState() {

    fun getId() = characterModel.id

    fun getImageUrl() = "${characterModel.thumbnail.replace("http", "https")}/portrait_xlarge.${characterModel.thumbnailExtension}"

    fun getName() = characterModel.name

    fun onClick(view : View) {
        val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(characterModel)
        Log.e("CharacterItemUiState", "onClick: tiklandi" )
        view.findNavController().navigate(action)
    }


}