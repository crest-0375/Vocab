package com.app.vocab.features.home.data.repository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey val word: String,
    val description: String
)