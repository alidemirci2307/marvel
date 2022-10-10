package com.demirci.marvel.data.source

import com.demirci.marvel.BuildConfig
import com.demirci.marvel.data.source.model.character_details.CharacterDetailsResponse
import com.demirci.marvel.data.source.model.characters.CharactersResponse
import com.demirci.marvel.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("apikey") apiKey: String = BuildConfig.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String,
        @Query("offset") offset: String

    ): CharactersResponse

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getCharacterDetails(
        @Path("characterId") id: String,
        @Query("dateRange") dateRange: String = Constants.DATE_RANGE,
        @Query("orderBy") orderBy: String = Constants.ORDER_BY,
        @Query("limit") limit: String = Constants.COMICS_LIMIT,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),

    ): CharacterDetailsResponse


}