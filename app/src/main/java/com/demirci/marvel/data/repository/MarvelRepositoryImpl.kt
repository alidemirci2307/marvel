package com.demirci.marvel.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.demirci.marvel.data.source.MarvelService
import com.demirci.marvel.data.source.dto.characters.CharactersResponse
import com.demirci.marvel.data.source.dto.characters.Result
import com.demirci.marvel.domain.model.CharacterModel
import com.demirci.marvel.domain.model.CharacterPagingDataSource
import com.demirci.marvel.domain.repository.MarvelRepository
import com.demirci.marvel.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val marvelService: MarvelService
) : MarvelRepository {

    override fun getAllCharactersWithPaging(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.limit.toInt()
            ),
            pagingSourceFactory = { CharacterPagingDataSource(marvelService) }
        ).flow
    }




}