package com.demirci.marvel.domain.usecase

import com.demirci.marvel.domain.model.CharacterModel
import com.demirci.marvel.domain.repository.MarvelRepository
import com.demirci.marvel.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    operator fun invoke(offset: Int): Flow<Response<List<CharacterModel>>> =
        flow {
            try {
                emit(Response.Loading<List<CharacterModel>>())
                val list = repository.getAllCharacters(offset = offset).data?.results?.map {
                    it.toCharacter()
                }
                emit(Response.Success<List<CharacterModel>>(list))
            } catch (e: HttpException) {
                emit(Response.Error<List<CharacterModel>>(e.printStackTrace().toString()))
            } catch (e: IOException) {
                emit(Response.Error<List<CharacterModel>>(e.printStackTrace().toString()))
            }
        }
}