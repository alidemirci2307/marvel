package com.demirci.marvel.domain.repository

import androidx.paging.PagingData
import com.demirci.marvel.data.source.dto.characters.CharactersDTO
import com.demirci.marvel.data.source.dto.characters.Result
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    suspend fun getAllCharacters(offset: Int) : CharactersDTO

    suspend fun getAllCharactersWithPaging(offset: Int) : Flow<PagingData<Result>>
}