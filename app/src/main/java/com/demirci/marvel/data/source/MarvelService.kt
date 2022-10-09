package com.demirci.marvel.data.source

import com.demirci.marvel.data.source.model.character_details.CharacterDetailsResponse
import com.demirci.marvel.data.source.model.characters.CharactersResponse
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

    //https://gateway.marvel.com:443/v1/public/characters/1017100/comics?startYear=2005&orderBy=focDate&limit=10&apikey=aac6883646e2108adcfb4890228767cd
    @GET("/v1/public/characters/{characterId}/comics/")
    suspend fun getCharacterDetails(
        @Query("characterId") id: String,
        @Query("startYear") startYear: String = Constants.START_YEAR,
        @Query("orderBy") orderBy: String = Constants.ORDER_BY,
        @Query("limit") limit: String = Constants.COMICS_LIMIT,
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String

    ): CharacterDetailsResponse


}