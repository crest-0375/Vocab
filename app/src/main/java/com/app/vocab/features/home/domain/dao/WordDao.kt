package com.app.vocab.features.home.domain.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.vocab.features.home.data.repository.entities.WordEntity

@Dao
interface WordDao {

    @Query("SELECT * FROM words")
    fun getDatabaseWords(): PagingSource<Int, WordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordsToDatabase(words: List<WordEntity>)

    @Query("DELETE FROM words")
    suspend fun clearData()
}