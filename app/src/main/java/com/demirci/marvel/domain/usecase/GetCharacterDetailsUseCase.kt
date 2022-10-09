package com.demirci.marvel.domain.usecase

import com.demirci.marvel.common.Resource
import com.demirci.marvel.domain.model.CharacterDetailsModel
import com.demirci.marvel.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository
) {
    operator fun invoke(id: String): Flow<Resource<List<CharacterDetailsModel>?>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(marvelRepository.getCharacterDetails(id).data?.results?.map {
                it.toDomain()
            }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}