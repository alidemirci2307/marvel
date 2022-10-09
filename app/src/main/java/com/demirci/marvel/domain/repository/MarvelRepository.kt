package com.demirci.marvel.domain.repository

import androidx.paging.PagingData
import com.demirci.marvel.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getAllCharactersWithPaging() : Flow<PagingData<CharacterModel>>
}