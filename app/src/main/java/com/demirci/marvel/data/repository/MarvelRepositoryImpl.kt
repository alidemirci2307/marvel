package com.demirci.marvel.data.repository

import com.demirci.marvel.data.source.MarvelApi
import com.demirci.marvel.data.source.dto.characters.CharactersDTO
import com.demirci.marvel.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val api: MarvelApi
) : MarvelRepository {
    override suspend fun getAllCharacters(offset: Int): CharactersDTO {
        return api.getALlCharacters(offset = offset.toString())
    }

}