package com.demirci.marvel.domain.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.demirci.marvel.data.source.MarvelApi
import com.demirci.marvel.data.source.dto.characters.Result


class CharacterPagingDataSource(private val marvelApi: MarvelApi) :
    PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = marvelApi.getAllCharacters(offset = (page*params.loadSize).toString())
            LoadResult.Page(
                data = response.data!!.results,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.data.results.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}
