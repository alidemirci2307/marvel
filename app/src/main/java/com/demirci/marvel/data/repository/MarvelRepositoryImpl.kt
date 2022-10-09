package com.demirci.marvel.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.demirci.marvel.data.source.MarvelApi
import com.demirci.marvel.data.source.dto.characters.CharactersDTO
import com.demirci.marvel.data.source.dto.characters.Result
import com.demirci.marvel.domain.model.CharacterPagingDataSource
import com.demirci.marvel.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val api: MarvelApi
) : MarvelRepository {
    override suspend fun getAllCharacters(offset: Int): CharactersDTO {
        return api.getAllCharacters(offset = offset.toString())
    }

    override suspend fun getAllCharactersWithPaging(offset: Int): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = {
                CharacterPagingDataSource(marvelApi = api)
            }).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }

}