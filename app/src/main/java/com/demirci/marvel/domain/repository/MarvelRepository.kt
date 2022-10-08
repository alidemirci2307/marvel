package com.demirci.marvel.domain.repository

import com.demirci.marvel.data.source.dto.characters.CharactersDTO

interface MarvelRepository {

    suspend fun getAllCharacters(offset: Int) : CharactersDTO
}