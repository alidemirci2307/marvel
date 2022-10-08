package com.demirci.marvel.data.source

import com.demirci.marvel.data.source.dto.characters.CharactersDTO
import com.demirci.marvel.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getALlCharacters(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String

    ): CharactersDTO


}