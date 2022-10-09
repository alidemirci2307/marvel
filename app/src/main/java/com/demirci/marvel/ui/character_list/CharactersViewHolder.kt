package com.demirci.marvel.ui.character_list

import androidx.recyclerview.widget.RecyclerView
import com.demirci.marvel.databinding.ItemCharacterBinding
import com.demirci.marvel.util.ext.executeWithAction

class CharactersViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(characterItemUiState: CharacterItemUiState) {
        binding.executeWithAction {
            this.characterItemUiState = characterItemUiState
        }
    }
}