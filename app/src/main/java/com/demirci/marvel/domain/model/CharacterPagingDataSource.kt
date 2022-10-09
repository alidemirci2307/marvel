package com.demirci.marvel.domain.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.demirci.marvel.data.source.MarvelService
import com.demirci.marvel.util.Constants


class CharacterPagingDataSource(private val marvelService: MarvelService) :
    PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = marvelService.getAllCharacters(limit = Constants.CHARACTER_LIMIT, offset = ((page-1)*params.loadSize).toString())
            LoadResult.Page(
                data = response.data!!.results.map {
                    it.toCharacter()
                },
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.data.results.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}
