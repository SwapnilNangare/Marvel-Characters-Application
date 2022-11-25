package com.example.marvelcomicapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.marvelcomicapp.model.character.Character
import com.example.marvelcomicapp.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow

class AllCharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

    fun getListData(): Flow<PagingData<Character>> {
        return repository.getResultStream()
            .cachedIn(viewModelScope)
    }
}