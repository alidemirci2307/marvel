package com.demirci.marvel.ui.character_list

import com.demirci.marvel.R
import com.demirci.marvel.base.BaseAdapter
import com.demirci.marvel.databinding.ItemCharacterBinding
import com.demirci.marvel.domain.model.CharacterModel

class CharacterAdapter (
    list: List<CharacterModel>,
    private val characterListener: CharacterListener
) : BaseAdapter<ItemCharacterBinding, CharacterModel>(list) {

    override val layoutId: Int = R.layout.item_character

    override fun bind(binding: ItemCharacterBinding, item: CharacterModel) {
        binding.apply {
            character = item
            listener = characterListener
            executePendingBindings()
        }
    }
}

interface CharacterListener {
    fun onCharacterClicked(characterModel: CharacterModel)
}