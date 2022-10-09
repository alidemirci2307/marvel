package com.demirci.marvel.data.source

import com.demirci.marvel.data.source.dto.characters.CharactersResponse
import com.demirci.marvel.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String

    ): CharactersResponse


}