package com.demirci.marvel.domain.repository

import androidx.paging.PagingData
import com.demirci.marvel.data.source.model.character_details.CharacterDetailsResponse
import com.demirci.marvel.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getAllCharactersWithPaging(): Flow<PagingData<CharacterModel>>

    suspend fun getCharacterDetails(id: String): CharacterDetailsResponse
}