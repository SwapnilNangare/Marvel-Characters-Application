package com.example.marvelcomicapp.repository

import com.example.marvelcomicapp.api.MarvelService
import com.example.marvelcomicapp.model.comics.Comic
import com.example.marvelcomicapp.resource.Output
import com.example.marvelcomicapp.resource.parseResponse
import java.lang.Exception

class ComicsRepositoryImpl(
    private val service: MarvelService
): ComicsRepository {
    override suspend fun getComicsByCharacterId(characterId: Int): List<Comic> {
        return when (val result = service.getComicsByCharacterId(characterId).parseResponse()) {
            is Output.Success -> {
                result.value.data.results
            }
            is Output.Failure -> throw GetComicsException()
        }
    }
}

interface ComicsRepository {
    suspend fun getComicsByCharacterId(characterId: Int): List<Comic>
}

class GetComicsException: Exception()