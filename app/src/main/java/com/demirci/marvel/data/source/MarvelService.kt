package com.demirci.marvel.data.source

import com.demirci.marvel.data.source.model.character_details.CharacterDetailsResponse
import com.demirci.marvel.data.source.model.characters.CharactersResponse
import com.demirci.marvel.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {


    //https://gateway.marvel.com:443/v1/public/characters?limit=3&offset=3&apikey=aac6883646e2108adcfb4890228767cd
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: String,
        @Query("offset") offset: String

    ): CharactersResponse

    //https://gateway.marvel.com:443/v1/public/characters/1011334/comics?dateRange=2005-01-01%2C2023-01-01&orderBy=focDate&limit=10&apikey=aac6883646e2108adcfb4890228767cd
    //https://gateway.marvel.com/v1/public/characters/1011334/comics?dateRange=2005-01-01%252C2023-01-01&orderBy=focDate&limit=10&apikey=aac6883646e2108adcfb4890228767cd&ts=1665351146584&hash=f11f21792dfe46ecb5991eb66f7d96c9
    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getCharacterDetails(
        @Path("characterId") id: String,
        @Query("dateRange") dateRange: String = Constants.DATE_RANGE,
        @Query("orderBy") orderBy: String = Constants.ORDER_BY,
        @Query("limit") limit: String = Constants.COMICS_LIMIT,
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),

    ): CharacterDetailsResponse


}