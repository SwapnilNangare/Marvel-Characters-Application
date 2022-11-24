package com.example.marvelcomicapp.model.character

import java.lang.Character

data class Data(
    var offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
)