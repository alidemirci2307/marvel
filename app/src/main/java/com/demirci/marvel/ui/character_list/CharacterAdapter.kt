package com.demirci.marvel.ui.character_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.demirci.marvel.R
import com.demirci.marvel.databinding.ItemCharacterBinding
import javax.inject.Inject

class CharacterAdapter @Inject constructor() :
    PagingDataAdapter<CharacterItemUiState, CharactersViewHolder>(Comparator) {

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { userItemUiState -> holder.bind(userItemUiState) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {

        val binding = DataBindingUtil.inflate<ItemCharacterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_character,
            parent,
            false
        )

        return CharactersViewHolder(binding)
    }

    object Comparator : DiffUtil.ItemCallback<CharacterItemUiState>() {
        override fun areItemsTheSame(oldItem: CharacterItemUiState, newItem: CharacterItemUiState): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(
            oldItem: CharacterItemUiState,
            newItem: CharacterItemUiState
        ): Boolean {
            return oldItem == newItem
        }
    }

}