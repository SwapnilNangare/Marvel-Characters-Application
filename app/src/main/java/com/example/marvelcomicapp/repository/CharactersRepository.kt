package com.example.marvelcomicapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ozaltun.marvel.constant.Constant
import com.ozaltun.marvel.api.MarvelService
import kotlinx.coroutines.flow.Flow

class CharactersRepository(private val apiService: MarvelService) {

    fun getResultStream(): Flow<PagingData<Character>> {
        return Pager(config = PagingConfig(pageSize = pageSize, maxSize = pageMax),
            pagingSourceFactory = { CharacterPagingSource(apiService) }
        ).flow
    }

    companion object {
        const val pageSize: Int = Constant.PAGE_SIZE
        const val pageMax: Int = Constant.MAX_PAGE
    }
}